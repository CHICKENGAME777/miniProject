package com.chickengame.mini.view;

import com.chickengame.mini.controller.GameManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    private GameManager gameManager;

    private Scanner sc;

    public MainMenu() {
        gameManager = new GameManager();
        sc = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("메인 메뉴 화면입니다.");
            System.out.println("1. 전체 멤버 순위 출력");
            System.out.println("2. 내 정보 출력");
            System.out.println("3. 내 정보 수정");
            System.out.println("4. 게임 시작");
            System.out.println("9. 게임 종료");
            System.out.print("메뉴: ");
            try {
                int menu = sc.nextInt();
                switch (menu) {
                    case 1:
                        showRank();
                        break;
                    case 2:
                        showProfile();
                        break;
                    case 3:
                        int cases = updateProfile();
                        if (cases == 1)
                            return;
                        break;
                    case 4:
                        gameStart();
                        break;
                    case 9:
                        System.out.println("게임을 종료합니다.");
                        return;
                    default:
                        System.out.println("잘못 입력했습니다. 다시 입력하세요.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자로 입력해주세요.");
                sc.nextLine();
            }
        }
    }

    private void showRank() {
        MenuManager.getInstance().showRank();
    }

    private void showProfile() {
        MenuManager.getInstance().showProfile();
    }

    private int updateProfile() {
        int cases = MenuManager.getInstance().updateProfile();
        if (cases == 1) {
            return 1; // 게임을 아예 종료하는 케이스
        }
        return 0;
    }

    private void gameStart() {
        gameManager.gameStart();
    }
}
