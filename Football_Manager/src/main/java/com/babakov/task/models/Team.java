package com.babakov.task.models;

import com.babakov.task.type.TeamType;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "team_type", nullable = false, updatable = false)
    private TeamType teamType;
    @Column(nullable = false)
    private long purse;
    @Column(nullable = false)
    private int commission;

    public Team(){
        super();
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

    public void setTeamType(TeamType teamtype) {
        this.teamType = teamtype;
    }

    public long getPurse() {
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
