package com.babakov.task.repository;

import com.babakov.task.models.Player;

import java.util.List;

public interface PlayerRepository extends BaseRepository<Player>{

    List<Player> findAllByTeamId(Long teamId);
}
