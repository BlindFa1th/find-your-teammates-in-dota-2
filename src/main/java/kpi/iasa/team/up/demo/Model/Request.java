package kpi.iasa.team.up.demo.Model;

import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Table(name = "request_list")
@ToString
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Valid
    private Long Id;
    @Column(name = "id_player")
    @Valid
    private Long id_player;
    @Column(name = "id_of_team")
    @Valid
    private Long id_of_team;
    @Column(name = "status")
    @Valid
    private Long status;

    public Long getId_player() {
        return id_player;
    }

    public void setId_player(Long id_player) {
        this.id_player = id_player;
    }

    public Long getId_of_team() {
        return id_of_team;
    }

    public void setId_of_team(Long id_of_team) {
        this.id_of_team = id_of_team;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}
