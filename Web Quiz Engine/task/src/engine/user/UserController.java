package engine.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
/*
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/api/register")
    public ResponseEntity addUser(@Valid @RequestBody User user){
        if (userService.getByEmail(user.getEmail()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user already exists");
        }

        user.encryptPassword();
        userService.add(user);
        return ResponseEntity.ok(user);
    }

}

 */

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    UserService userService;

    //Register a user
    @PostMapping("/api/register")
    public ResponseEntity addUser(@RequestBody @Valid User newUser)
            throws ResponseStatusException {
        if (userService.getByEmail(newUser.getEmail()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user already exists");
        }

        newUser.encryptPassword();
        userService.add(newUser);
        return ResponseEntity.ok(newUser);
    }

}