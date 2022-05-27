package com.babakov.demo.models;

import com.babakov.demo.type.TeamType;

import javax.persistence.*;
@Entity
@Table(name = "teams")
public class Team extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "team_type", nullable = false, updatable = false)
    private TeamType teamType;
    @Column(nullable = false)
    private int purse;

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
