package com.chickengame.mini.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class MemberDTO implements Serializable {
    private int score;
    private String name;
    private String id;
    private String registDate;
    private int rank;

    public MemberDTO() {
    }

    public MemberDTO(String id, String name) {
        //회원 가입 때 호출
        this.score = 20;
        this.id = id;
        this.name = name;
        String date = String.valueOf(LocalDate.now());
        String time = String.valueOf(LocalTime.now().withNano(0));
        this.registDate = date + " " + time;
    }

    public MemberDTO(int score, String id, String name, String registDate, int rank) {
        // 로드 메소드에서 쓰는 생성자
        this.score = score;
        this.id = id;
        this.name = name;
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
