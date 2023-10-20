package com.chickengame.mini.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

public class MemberDTO implements Serializable {
    private int score;
    private String name;
    private String id;
    private String registDate;
    private int rank;

    public MemberDTO() {
    }

    public MemberDTO(int score, String name, String id, String registDate) {
        this.score = score;
        this.name = name;
        this.id = id;
        this.registDate = registDate;
    }

    public MemberDTO(String id, String name, String registDate) {   //회원 가입 때 호출
        this.score = 20;
        this.id = id;
        this.name = name;
        this.registDate = registDate;
    }

    public MemberDTO(String id, String name) {
        //this.score = 50;
        this.id = id;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegistDate() {
        return registDate;
    }

    public void setRegistDate(String registDate) {
        this.registDate = registDate;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void resetScore() {
        this.score = 0;
    }

    @Override
    public String toString() {
        return  "마일리지=" + score +
                ", 이름='" + name +
                ", ID='" + id +
                ", 회원가입 날짜=" + registDate +
                ", rank=" + rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberDTO memberDTO = (MemberDTO) o;
        return score == memberDTO.score && registDate == memberDTO.registDate && Objects.equals(name, memberDTO.name) && Objects.equals(id, memberDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, name, id, registDate);
    }
}
