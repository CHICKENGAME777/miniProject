package com.chickengame.mini.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

public class MemberDTO implements Serializable {
    private int score;
    private String name;
    private String id;
    private java.sql.Timestamp registDate;
    private int rank;

    public MemberDTO() {
    }

    public MemberDTO(int score, String name, String id, Timestamp registDate, int rank) {
        this.score = score;
        this.name = name;
        this.id = id;
        this.registDate = registDate;
        this.rank = rank;
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

    public Timestamp getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Timestamp registDate) {
        this.registDate = registDate;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "마일리지=" + score + ", 이름=" + name + ", ID=" + id + ", 회원가입 날짜=" + registDate + ", rank=" + rank;
    }
}
