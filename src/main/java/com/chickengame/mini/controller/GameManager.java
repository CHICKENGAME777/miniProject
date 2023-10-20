package com.chickengame.mini.controller;

import com.chickengame.mini.games.*;
import com.chickengame.mini.model.dao.MemberDAO;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    private List<Game> games;

    Scanner sc = new Scanner(System.in);
    public GameManager() {
        games = new ArrayList<>();
        games.add(new UpDownGame());
        games.add(new SlotMachine777());
        games.add(new Lotto());
        // ...
    }
    public void gameStart(){

        while (true) {
            System.out.println(MemberDAO.getInstance().getMe().getName()+" 님! 게임을 선택해주세요.");
            System.out.println("1. Updown Game");
            System.out.println("2. Slot Machine777");
            System.out.println("3. Lotto 번호 추천");
            System.out.println("9. 메인 메뉴로 돌아가기");
            try {
                int num = sc.nextInt();
                sc.nextLine();
                if (num == 9) {
                    return;
                }
                if (games.size() < num) {
                    System.out.println("다시 입력해주세요.");
                } else {
                    games.get(num - 1).gameStart();
                }
            } catch (InputMismatchException e){
                System.out.println("숫자로 입력해주세요.");
                sc.nextLine();
            }
        }
    }
}
