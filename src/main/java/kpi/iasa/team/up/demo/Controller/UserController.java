package kpi.iasa.team.up.demo.Controller;

import kpi.iasa.team.up.demo.Model.User;
import kpi.iasa.team.up.demo.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getUser(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> postUser(@RequestBody User newUser){
        return ResponseEntity.ok(userService.saveUser(newUser));
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUsersById(id));
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User updatedUser){
        return ResponseEntity.ok(userService.updateUsersById(id, updatedUser));
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.deleteUsersById(id));
    }
}
