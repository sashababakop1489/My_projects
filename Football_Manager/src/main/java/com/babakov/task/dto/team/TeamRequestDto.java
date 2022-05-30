package com.babakov.task.dto.team;

import com.babakov.task.dto.RequestDto;
import com.babakov.task.type.TeamType;

public class TeamRequestDto extends RequestDto {

    private String name;
    private TeamType teamType;

    private int purse;

    private int commission;

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

    public int getPurse() {
        return purse;
    }

    public void setPurse(int purse) {
        this.purse = purse;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }
}
