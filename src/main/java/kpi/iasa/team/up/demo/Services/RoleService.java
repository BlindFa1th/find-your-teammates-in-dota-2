package kpi.iasa.team.up.demo.Services;

import kpi.iasa.team.up.demo.Exepcions.UserNotFoundExcepcion;
import kpi.iasa.team.up.demo.Model.Role;
import kpi.iasa.team.up.demo.Repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getRoles(){
        return roleRepository.findAll();
    }
    public Role saveRole(Role newRole){
        return roleRepository.save(newRole);
    }
    public Role getRolesById(Long id){
        Optional<Role> roles = roleRepository.findById(id);
        if(roles.isPresent()){
            return roles.get();
        }
        throw new UserNotFoundExcepcion();
    }

    public Role updateRolesById(Long id, Role updatedRole) {
        Optional<Role> roles = roleRepository.findById(id);
        if(roles.isPresent()){
            Role oldRole = roles.get();
            updateRoles(oldRole, updatedRole);
            return roleRepository.save(oldRole);
        }
        throw new UserNotFoundExcepcion();
    }

    private void updateRoles(Role oldRole, Role updatedRole) {
        oldRole.setName(updatedRole.getName());
    }

    public String deleteRolesById(Long id) {
        roleRepository.deleteById(id);
        return "Role was successfully deleted!";
    }
}
