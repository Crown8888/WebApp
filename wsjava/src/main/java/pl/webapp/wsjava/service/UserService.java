package pl.webapp.wsjava.service;

import org.springframework.stereotype.Service;
import pl.webapp.wsjava.model.User;
import pl.webapp.wsjava.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
