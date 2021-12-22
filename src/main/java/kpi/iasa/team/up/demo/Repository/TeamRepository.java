package kpi.iasa.team.up.demo.Repository;

import kpi.iasa.team.up.demo.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {
    Optional<Team> findById(Long Id);
}