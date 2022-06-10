package com.babakov.task.service;

import com.babakov.task.models.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService extends BaseService<Player>{
    List<Player> findAllByTeamId(Long teamId);
}
