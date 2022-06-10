package com.babakov.task.facade.impl;

import com.babakov.task.dto.player.PlayerRequestDto;
import com.babakov.task.dto.player.PlayerResponseDto;
import com.babakov.task.facade.PlayerFacade;
import com.babakov.task.models.Player;
import com.babakov.task.models.Team;
import com.babakov.task.service.PlayerService;
import com.babakov.task.service.TeamService;
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
        playerService.update(player);
    }

    @Override
    public void changeTeam(Long id, Long newTeamId) {
        Team team = teamService.findById(newTeamId);
        Player player = playerService.findById(id);
        player.setTeam(team);
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

    private List<PlayerResponseDto> convertToDtoByEntity(List<Player> players) {
        return players.stream()
                .map(PlayerResponseDto::new)
                .collect(Collectors.toList());
    }
}

