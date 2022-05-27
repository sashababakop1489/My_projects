package com.babakov.demo.service.impl;

import com.babakov.demo.models.Player;
import com.babakov.demo.repository.PlayerRepository;
import com.babakov.demo.service.PlayerService;
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
        System.out.println("player = " + player);
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
        return playerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> findAllByTeamId(Long teamId) {
        return playerRepository.findAllByTeam(teamId);
    }

}
