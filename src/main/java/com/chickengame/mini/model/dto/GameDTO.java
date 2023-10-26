package com.chickengame.mini.model.dto;

import java.io.Serializable;

public class GameDTO implements Serializable {
    private int gameId;
    private String gameName;

    public GameDTO() {
    }

    public GameDTO(int gameId, String gameName) {
        this.gameId = gameId;
        this.gameName = gameName;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    @Override
    public String toString() {
        return "GameDTO{" +
                "gameId=" + gameId +
                ", gameName='" + gameName + '\'' +
                '}';
    }
}
