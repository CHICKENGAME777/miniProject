package com.chickengame.mini.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class GameRankingDTO implements Serializable {
    private int rankingId;
    private String memberId;
    private int gameId;
    private int score;
    private Timestamp rankDate;

    public GameRankingDTO() {
    }

    public GameRankingDTO(int rankingId,
                          String memberId,
                          int gameId,
                          int score,
                          Timestamp rankDate) {
        this.rankingId = rankingId;
        this.memberId = memberId;
        this.gameId = gameId;
        this.score = score;
        this.rankDate = rankDate;
    }

    public int getRankingId() {
        return rankingId;
    }

    public void setRankingId(int rankingId) {
        this.rankingId = rankingId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Timestamp getRankDate() {
        return rankDate;
    }

    public void setRankDate(Timestamp rankDate) {
        this.rankDate = rankDate;
    }

    @Override
    public String toString() {
        return "GameRankingDTO{" +
                "rankingId=" + rankingId +
                ", memberId='" + memberId + '\'' +
                ", gameId=" + gameId +
                ", score=" + score +
                ", rankDate=" + rankDate +
                '}';
    }
}
