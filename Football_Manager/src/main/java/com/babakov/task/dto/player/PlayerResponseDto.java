package com.babakov.task.dto.player;

import com.babakov.task.dto.ResponseDto;
import com.babakov.task.models.Player;
import com.babakov.task.models.Team;

public class PlayerResponseDto extends ResponseDto {

    private String firstName;
    private String lastName;
    private Integer age;

    private Integer experience;

    private Long price;

    private Integer transfer;
    private Team team;

    public PlayerResponseDto() { }

    public PlayerResponseDto(Player player) {
        this.firstName = player.getFirstName();
        this.lastName = player.getLastName();
        this.age = player.getAge();
        this.experience = player.getExperience();
        this.transfer = player.getExperience() * 100000 / player.getAge();
        if(player.getTeam()!= null) {
            this.team = player.getTeam();
        }
        this.price = (long) transfer * team.getCommission();
        super.setId(player.getId());
        super.setCreated(player.getCreated());
        super.setUpdated(player.getUpdated());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getTransfer() {
        return transfer;
    }

    public void setTransfer(Integer transfer) {
        this.transfer = transfer;
    }
}
