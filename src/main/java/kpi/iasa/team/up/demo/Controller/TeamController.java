package kpi.iasa.team.up.demo.Controller;

import kpi.iasa.team.up.demo.Model.Team;
import kpi.iasa.team.up.demo.Services.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
    @GetMapping(value = "/teams")
    public ResponseEntity<List<Team>> getTeam(){
        return ResponseEntity.ok(teamService.getTeams());
    }

    @PostMapping(value = "/teams")
    public ResponseEntity<Team> postTeam(@RequestBody Team newTeam){
        return ResponseEntity.ok(teamService.saveTeam(newTeam));
    }

    @GetMapping(value = "/teams/{id}")
    public ResponseEntity<Team> getTeam(@PathVariable Long id){
        return ResponseEntity.ok(teamService.getTeamsById(id));
    }

    @PutMapping(value = "/teams/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long id, @Valid @RequestBody Team updatedTeam){
        return ResponseEntity.ok(teamService.updateTeamsById(id, updatedTeam));
    }

    @DeleteMapping(value = "/teams/{id}")
    public ResponseEntity<String> deleteTeam(@PathVariable Long id){
        return ResponseEntity.ok(teamService.deleteTeamsById(id));
    }
}
