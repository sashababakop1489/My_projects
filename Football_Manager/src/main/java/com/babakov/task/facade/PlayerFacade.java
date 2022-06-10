package com.babakov.task.facade;

import com.babakov.task.dto.player.PlayerRequestDto;
import com.babakov.task.dto.player.PlayerResponseDto;

import java.util.List;

public interface PlayerFacade extends BaseFacade<PlayerRequestDto, PlayerResponseDto>{

    List<PlayerResponseDto> findAllByTeamId(Long teamId);

    void changeTeam(Long id, Long teamId);
}
