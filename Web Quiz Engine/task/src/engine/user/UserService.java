package engine.user;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService {
    final
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void add(User user) throws IllegalArgumentException {
        userRepository.save(user);
    }

    public User get(Long id){
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such user");
        }
    }

    public User getByEmail(String email){
        return userRepository.findByEmail(email).isPresent() ?
                userRepository.findByEmail(email).get() : null;
    }
}
