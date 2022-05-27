package com.babakov.demo.repository;

import com.babakov.demo.models.Player;
import com.babakov.demo.models.Team;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends BaseRepository<Player>{

    void deleteAllByTeam(Team team);

    List<Player> findAllByTeamId(Long departmentId);

}
