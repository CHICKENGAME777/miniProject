package com.chickengame.mini.model.dto;

import java.util.Objects;

public class MemberDTO {
    int score;
    String name;
    String id;

    int signDate;

    public MemberDTO() {
    }

    public MemberDTO(int score, String id, String name, int signDate) {
        this.score = score;
        this.id = id;
        this.name = name;
        this.signDate = signDate;
    }

    public MemberDTO(String id, String name) {
        this.score = 0;
        this.id = id;
        this.name = name;
        this.signDate = 0;
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

    public int getSignDate() {
        return signDate;
    }

    public void setSignDate(int signDate) {
        this.signDate = signDate;
    }
    public void addScore(int score){
        this.score+=score;
    }
    public void resetScore(){
        this.score = 0;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "score=" + score +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", signDate=" + signDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberDTO memberDTO = (MemberDTO) o;
        return score == memberDTO.score && signDate == memberDTO.signDate && Objects.equals(name, memberDTO.name) && Objects.equals(id, memberDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, name, id, signDate);
    }
}
