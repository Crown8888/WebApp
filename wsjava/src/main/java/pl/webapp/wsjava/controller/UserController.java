package pl.webapp.wsjava.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.webapp.wsjava.dto.UserDTO;
import pl.webapp.wsjava.service.Mapper;
import pl.webapp.wsjava.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final Mapper modelMapper;

    public UserController(UserService userService, Mapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    //Get user by id
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(modelMapper.toDTO(userService.findById(id)), HttpStatus.OK);
    }

}
