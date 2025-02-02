package pl.webapp.wsjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import pl.webapp.wsjava.dto.ResponseDTO;
import pl.webapp.wsjava.dto.UserDTO;
import pl.webapp.wsjava.service.Mapper;
import pl.webapp.wsjava.service.SessionService;
import pl.webapp.wsjava.service.UserService;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    public AuthenticationManager manager;
    public SessionService sessionService;
    UserService userService;
    Mapper mapper;


    public AuthenticationController(SessionService sessionService, UserService userService, Mapper mapper) {
        this.sessionService = sessionService;
        this.userService = userService;
        this.mapper = mapper;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody UserDTO userDTO) {
        manager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));
        String token = SessionService.generateToken(userDTO.getUsername());
        UserDTO userDTOEntity = mapper.toDTO(userService.findByUsername(userDTO.getUsername()));
        if(userDTOEntity != null && userDTOEntity.isEnabled() == false){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(new ResponseDTO(token, userDTOEntity));
    }




}