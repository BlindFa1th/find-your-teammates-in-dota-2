package kpi.iasa.team.up.demo.Services;

import kpi.iasa.team.up.demo.Model.User;
import kpi.iasa.team.up.demo.Exepcions.UserNotFoundExcepcion;
import kpi.iasa.team.up.demo.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public User saveUser(User newUser){
        return userRepository.save(newUser);
    }
    public User getUsersById(Long id){
        Optional<User> users = userRepository.findById(id);
        if(users.isPresent()){
            return users.get();
        }
        throw new UserNotFoundExcepcion();
    }

    public User updateUsersById(Long id, User updatedUser) {
        Optional<User> users = userRepository.findById(id);
        if(users.isPresent()){
            User oldUser = users.get();
            updateUsers(oldUser, updatedUser);
            return userRepository.save(oldUser);
        }
        throw new UserNotFoundExcepcion();
    }

    private void updateUsers(User oldUser, User updatedUser) {
        oldUser.setNickname(updatedUser.getNickname());
        oldUser.setPassword(updatedUser.getPassword());
        oldUser.setEmail(updatedUser.getEmail());
        oldUser.setRole_id(updatedUser.getRole_id());
        oldUser.setTeam_id(updatedUser.getTeam_id());
    }

    public String deleteUsersById(Long id) {
        userRepository.deleteById(id);
        return "User was successfully deleted!";
    }
}
