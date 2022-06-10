package com.babakov.task.dto.team;

import com.babakov.task.dto.ResponseDto;
import com.babakov.task.models.Team;
import com.babakov.task.type.TeamType;

public class TeamResponseDto extends ResponseDto {

    private String name;
    private TeamType teamType;

    private Long purse;

    private int commission;

    public TeamResponseDto(){ }

    public TeamResponseDto(Team team){
        this.teamType = team.getTeamType();
        this.name = team.getName();
        this.purse = team.getPurse();
        this.commission = team.getCommission();
        super.setId(team.getId());
        super.setCreated(team.getCreated());
        super.setUpdated(team.getUpdated());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeamType getTeamType() {
        return teamType;
    }

    public void setTeamType(TeamType teamType) {
        this.teamType = teamType;
    }

    public Long getPurse() {
        return purse;
    }

    public void setPurse(Long purse) {
        this.purse = purse;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }
}
