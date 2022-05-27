package com.babakov.demo.facade.impl;

import com.babakov.demo.dto.team.TeamRequestDto;
import com.babakov.demo.dto.team.TeamResponseDto;
import com.babakov.demo.facade.TeamFacade;
import com.babakov.demo.models.Team;
import com.babakov.demo.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamFacadeImpl implements TeamFacade {

private final TeamService teamService;

    public TeamFacadeImpl(TeamService teamService) {
        this.teamService = teamService;
    }

    @Override
    public void create(TeamRequestDto teamRequestDto) {
        Team team = new Team();
        team.setTeamType(teamRequestDto.getTeamType());
        team.setName(teamRequestDto.getName());
        team.setPurse(teamRequestDto.getPurse());
        team.setCommission(teamRequestDto.getCommission());
        teamService.create(team);
    }

    @Override
    public void update(TeamRequestDto teamRequestDto, Long id) {
        Team team = teamService.findById(id);
        team.setTeamType(teamRequestDto.getTeamType());
        team.setName(teamRequestDto.getName());
        team.setPurse(teamRequestDto.getPurse());
        team.setCommission(teamRequestDto.getCommission());
        teamService.update(team);
    }

    @Override
    public void delete(Long id) {
        teamService.delete(id);
    }

    @Override
    public TeamResponseDto findById(Long id) {
        Team team = teamService.findById(id);
        return new TeamResponseDto(team);
    }

    @Override
    public List<TeamResponseDto> findAll() {
        return teamService.findAll().stream().map(TeamResponseDto::new).collect(Collectors.toList());
    }
}
