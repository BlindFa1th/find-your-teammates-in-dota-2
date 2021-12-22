package kpi.iasa.team.up.demo.Repository;

import kpi.iasa.team.up.demo.Model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<Request,Long> {
    Optional<Request> findById(Long Id);
}
