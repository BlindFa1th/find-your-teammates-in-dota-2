package kpi.iasa.team.up.demo.Services;

import kpi.iasa.team.up.demo.Exepcions.UserNotFoundExcepcion;
import kpi.iasa.team.up.demo.Model.Team;
import kpi.iasa.team.up.demo.Repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getTeams(){
        return teamRepository.findAll();
    }
    public Team saveTeam(Team newTeam){
        return teamRepository.save(newTeam);
    }
    public Team getTeamsById(Long id){
        Optional<Team> teams = teamRepository.findById(id);
        if(teams.isPresent()){
            return teams.get();
        }
        throw new UserNotFoundExcepcion();
    }

    public Team updateTeamsById(Long id, Team updatedTeam) {
        Optional<Team> teams = teamRepository.findById(id);
        if(teams.isPresent()){
            Team oldTeam = teams.get();
            updateTeams(oldTeam, updatedTeam);
            return teamRepository.save(oldTeam);
        }
        throw new UserNotFoundExcepcion();
    }

    private void updateTeams(Team oldTeam, Team updatedTeam) {
        oldTeam.setName(updatedTeam.getName());
        oldTeam.setOwner(updatedTeam.getOwner());
    }

    public String deleteTeamsById(Long id) {
        teamRepository.deleteById(id);
        return "Team was successfully deleted!";
    }
}
