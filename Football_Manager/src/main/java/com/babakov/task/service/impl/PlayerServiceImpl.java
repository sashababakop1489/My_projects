package com.babakov.task.service.impl;

import com.babakov.task.models.Player;
import com.babakov.task.repository.PlayerRepository;
import com.babakov.task.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlayerServiceImpl implements PlayerService {


    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void create(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void update(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void delete(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public Player findById(Long id) {
        return playerRepository.findById(id).get();
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> findAllByTeamId(Long teamId) {
        return playerRepository.findAllByTeamId(teamId);
    }
}
