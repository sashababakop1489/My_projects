package com.babakov.demo.facade;

import com.babakov.demo.dto.player.PlayerRequestDto;
import com.babakov.demo.dto.player.PlayerResponseDto;

import java.util.List;

public interface PlayerFacade extends BaseFacade<PlayerRequestDto, PlayerResponseDto>{

    List<PlayerResponseDto> findAllByTeamId(Long teamId);

}
