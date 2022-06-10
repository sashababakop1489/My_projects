package com.babakov.task.dto.player;

import com.babakov.task.dto.RequestDto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PlayerRequestDto extends RequestDto {

    @NotEmpty(message = "Firstname should not be empty")
    @Size(min = 2, max = 30, message = "Firstname should be between 2 and 30 characters")
    private String firstName;
    @NotEmpty(message = "Lastname should not be empty")
    @Size(min = 2, max = 30, message = "Lastname should be between 2 and 30 characters")
    private String lastName;
    @Min(value = 0, message = "Age should be greater than 0 !")
    @Max(value = 120, message = "Age must be under 120!")
    private int age;
    @Min(value = 0, message = "Experience should be greater than 0 !")
    private int experience;
    private Long teamId;

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

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "PlayerRequestDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", experience=" + experience +
                ", teamId=" + teamId +
                '}';
    }
}
