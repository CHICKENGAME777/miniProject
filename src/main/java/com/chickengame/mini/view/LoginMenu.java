package com.chickengame.mini.view;

import java.util.Scanner;

public class LoginMenu {
    MenuManager menuManager = MenuManager.getInstance();
    Scanner sc = new Scanner(System.in);
    boolean isLogin;

    public void run() {
        while (true) {
            isLogin = false;
            System.out.println("로그인 화면 입니다.");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("3. 나가기");
            System.out.print("메뉴: ");
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    isLogin = login();
                    break;
                case 2:
                    isLogin = register();
                    break;
                case 3:
                    System.out.println("게임을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못 입력했습니다. 다시 입력하세요.");
                    break;
            }
            if (isLogin) {
                System.out.println("로그인에 성공했습니다.");
                break;
            }
        }
        MainMenu mainMenu = new MainMenu();
        mainMenu.run();
    }

    private boolean login() {
        return menuManager.login();
    }

    private boolean register() {
        return menuManager.register();
    }
}
