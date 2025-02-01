package pl.webapp.wsjava.service;

import org.springframework.stereotype.Component;
import pl.webapp.wsjava.dto.UserDTO;
import pl.webapp.wsjava.model.User;

@Component
public class Mapper {
    public UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getEmail());
    }

    public User toEntity(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getUsername(), userDTO.getEmail(), userDTO.getPassword());
    }
}
