package pl.webapp.wsjava.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.filter.OncePerRequestFilter;
import pl.webapp.wsjava.service.CurrentUserService;
import pl.webapp.wsjava.service.SessionService;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

@Component
public class SessionFilter extends OncePerRequestFilter {
    private final CurrentUserService currentUserService;
    private final ObjectMapper objectMapper;

    public SessionFilter(CurrentUserService currentUserService, ObjectMapper objectMapper) {
        this.currentUserService = currentUserService;
        this.objectMapper = objectMapper;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String authHeader = request.getHeader("Authorization");
            String token = null;
            String username = null;
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                token = authHeader.substring(7);
                username = SessionService.extractUsername(token);
            }
            if (token == null) {
                filterChain.doFilter(request, response);
                return;
            }
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = currentUserService.loadUserByUsername(username);
                System.out.println(userDetails.getAuthorities());
                if (SessionService.validateToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }

            filterChain.doFilter(request, response);
        } catch (AccessDeniedException e) {
            ErrorResponseException errorResponse = new ErrorResponseException(HttpStatus.FORBIDDEN);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write(toJson(errorResponse));
        }

    }

    private String toJson(ErrorResponse response) {
        try {
            return objectMapper.writeValueAsString(response);
        } catch (Exception e) {
            return "";
        }
    }
}