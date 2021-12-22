package kpi.iasa.team.up.demo.Controller;

import kpi.iasa.team.up.demo.Model.Role;
import kpi.iasa.team.up.demo.Services.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @GetMapping(value = "/roles")
    public ResponseEntity<List<Role>> getRole(){
        return ResponseEntity.ok(roleService.getRoles());
    }

    @PostMapping(value = "/roles")
    public ResponseEntity<Role> postRole(@RequestBody Role newRole){
        return ResponseEntity.ok(roleService.saveRole(newRole));
    }

    @GetMapping(value = "/roles/{id}")
    public ResponseEntity<Role> getRole(@PathVariable Long id){
        return ResponseEntity.ok(roleService.getRolesById(id));
    }

    @PutMapping(value = "/roles/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @Valid @RequestBody Role updatedRole){
        return ResponseEntity.ok(roleService.updateRolesById(id, updatedRole));
    }

    @DeleteMapping(value = "/roles/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id){
        return ResponseEntity.ok(roleService.deleteRolesById(id));
    }
}
