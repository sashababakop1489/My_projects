package com.babakov.task.service.impl;

import com.babakov.task.models.Team;
import com.babakov.task.repository.PlayerRepository;
import com.babakov.task.repository.TeamRepository;
import com.babakov.task.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
private final TeamRepository teamRepository;
    @Autowired
private final PlayerRepository playerRepository;

    public TeamServiceImpl(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public void create(Team team) {
        teamRepository.save(team);
    }

    @Override
    public void update(Team team) {
        teamRepository.save(team);
    }

    @Override
    public void delete(Long id) {
        Optional<Team> team = teamRepository.findById(id);
        if(team.isPresent()) {
//             List<Player> players = playerRepository.findAllByTeamId(id);
//             players.removeAll(players);
            teamRepository.delete(team.get());
        }
    }

    @Override
    public Team findById(Long id) {
        return teamRepository.findById(id).get();
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }
}
