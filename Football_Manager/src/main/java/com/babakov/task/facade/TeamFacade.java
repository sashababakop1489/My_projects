package com.babakov.task.facade;

import com.babakov.task.dto.team.TeamRequestDto;
import com.babakov.task.dto.team.TeamResponseDto;

public interface TeamFacade extends BaseFacade<TeamRequestDto, TeamResponseDto>{

    void changePurse(Long id, Integer price);
}
