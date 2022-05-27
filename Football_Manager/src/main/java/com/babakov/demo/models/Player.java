package com.babakov.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "players")
public class Player extends BaseEntity {
@Column(name = "first_name")
    private String firstName;
@Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "experience")
    private Integer experience;
    private Integer transfer;
    private Integer price;
    @ManyToOne
    private Team team;

    public Player(){
        super();
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

    public int getAge() {
        return age;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public void setTransfer(Integer transfer) {
        this.transfer = transfer;
    }

    public Integer getExperience() {
        return experience;
    }

    public Integer getTransfer() {
        return transfer;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", experience=" + experience +
                ", transfer=" + transfer +
                ", price=" + price +
                ", team=" + team +
                '}';
    }
}
