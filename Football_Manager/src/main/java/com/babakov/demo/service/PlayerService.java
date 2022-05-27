package com.babakov.demo.service;

import com.babakov.demo.models.Player;
import com.babakov.demo.models.Team;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService extends BaseService<Player>{
    List<Player> findAllByTeamId(Long teamId);

}
