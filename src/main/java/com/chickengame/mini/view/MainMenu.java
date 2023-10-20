package com.chickengame.mini.view;

import com.chickengame.mini.controller.GameManager;

import java.util.Scanner;

public class MainMenu {
    private GameManager gameManager = new GameManager();

    private Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("메인 메뉴 화면입니다.");
            System.out.println("1. 전체 멤버 순위 출력");
            System.out.println("2. 내 정보 출력");
            System.out.println("3. 내 정보 수정");
            System.out.println("4. 게임 시작");
            System.out.println("5. 게임 종료");
            System.out.print("메뉴: ");
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    showRank();
                    break;
                case 2:
                    showProfile();
                    break;
                case 3:
                    updateProfile();
                case 4:
                    gameStart();
                    break;
                case 5:
                    System.out.println("게임을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못 입력했습니다. 다시 입력하세요.");
                    break;
            }
        }
    }

    private void showRank() {
        MenuManager.getInstance().showRank();
    }

    private void showProfile() {
        MenuManager.getInstance().showProfile();
    }

    private void updateProfile() {
        MenuManager.getInstance().updateProfile();
    }

    private void gameStart() {
        gameManager.gameStart();
    }
}
