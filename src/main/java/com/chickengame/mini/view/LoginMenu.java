package com.chickengame.mini.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginMenu {
    private Scanner sc;
    private boolean isLogin;    //로그인 되어 있는지 확인

    public LoginMenu() {
        sc = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            isLogin = false;    //로그인 false
            System.out.println("로그인 화면 입니다.");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("3. 나가기");
            System.out.print("메뉴: ");
            try {
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
            } catch (InputMismatchException e) {
                System.out.println("숫자로 입력해주세요.");
                sc.nextLine();
            }
        }
        MainMenu mainMenu = new MainMenu();
        mainMenu.run();
    }

    private boolean login() {
        return MenuManager.getInstance().login();
    }

    private boolean register() {
        return MenuManager.getInstance().register();
    }
}
