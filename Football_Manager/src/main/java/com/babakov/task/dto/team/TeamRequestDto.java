package com.babakov.task.dto.team;

import com.babakov.task.dto.RequestDto;
import com.babakov.task.type.TeamType;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class TeamRequestDto extends RequestDto {
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;
    private TeamType teamType;
    @Min(value = 0, message = "Purse should be greater than 0 !")
    @Max(value = 9223372036854775807L, message = "Purse must be under 9223372036854775807 !")
    private long purse;
    @Min(value = 0, message = "Commission should be greater than 0 !")
    @Max(value = 10, message = "Commission must be under 10!")
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
