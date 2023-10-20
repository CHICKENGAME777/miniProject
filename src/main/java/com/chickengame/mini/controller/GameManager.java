package com.chickengame.mini.controller;

import com.chickengame.mini.games.*;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private List<Game> games;

    public GameManager() {
        games = new ArrayList<>();
        // 여기에서 게임 객체를 생성하고 리스트에 추가
        games.add(new slotMachine777());
//        games.add(new Game2());
        games.add(new Game3());
        // ...
    }

}
