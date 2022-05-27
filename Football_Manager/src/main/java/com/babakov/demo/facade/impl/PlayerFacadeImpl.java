package com.babakov.demo.facade.impl;

import com.babakov.demo.dto.player.PlayerRequestDto;
import com.babakov.demo.dto.player.PlayerResponseDto;
import com.babakov.demo.facade.PlayerFacade;
import com.babakov.demo.models.Player;
import com.babakov.demo.models.Team;
import com.babakov.demo.service.PlayerService;
import com.babakov.demo.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerFacadeImpl implements PlayerFacade {

    private final PlayerService playerService;
    private final TeamService teamService;

    public PlayerFacadeImpl(PlayerService playerService, TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }

    @Override
    public void create(PlayerRequestDto playerRequestDto) {
        Team team = teamService.findById(playerRequestDto.getTeamId());
        Player player = new Player();
        player.setFirstName(playerRequestDto.getFirstName());
        player.setLastName(playerRequestDto.getLastName());
        player.setAge(playerRequestDto.getAge());
        player.setExperience(playerRequestDto.getExperience());
        //player.setTransfer(playerRequestDto.getExperience() * 100000 / playerRequestDto.getAge());
        player.setTeam(team);
        playerService.create(player);
    }

    @Override
    public void update(PlayerRequestDto playerRequestDto, Long id) {
        Player player = playerService.findById(id);
        player.setFirstName(playerRequestDto.getFirstName());
        player.setLastName(playerRequestDto.getLastName());
        player.setAge(playerRequestDto.getAge());
        player.setExperience(playerRequestDto.getExperience());
        //player.setTransfer(playerRequestDto.getExperience() * 100000 / playerRequestDto.getAge());
        playerService.update(player);
    }

    @Override
    public void delete(Long id) {
        playerService.delete(id);
    }

    @Override
    public PlayerResponseDto findById(Long id) {

        return new PlayerResponseDto(playerService.findById(id));
    }

    @Override
    public List<PlayerResponseDto> findAll() {
        return convertToDtoByEntity(playerService.findAll());
    }

    @Override
    public List<PlayerResponseDto> findAllByTeamId(Long teamId) {
        return convertToDtoByEntity(playerService.findAllByTeamId(teamId));
    }

    private List<PlayerResponseDto> convertToDtoByEntity(List<Player> employees) {
        return employees.stream()
                .map(PlayerResponseDto::new)
                .collect(Collectors.toList());
    }
}

