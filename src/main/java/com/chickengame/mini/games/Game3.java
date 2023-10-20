package com.chickengame.mini.games;

import java.util.Random;
import java.util.Scanner;


public class Game3 implements Game {
    // 가위바위보 다희
    Game3 g = new Game3();

    public static void main(String[] args) {
        int score = 20;

        while (true) {

            // 사용자 입력 받기
            Scanner sc = new Scanner(System.in);
            System.out.println("-------------- 가위바위보게임 --------------");
            System.out.println("(1)가위 (2)바위 (3)보 (4)종료");
            System.out.print("숫자입력 : ");
            int userChoice = sc.nextInt();

            // 컴퓨터의 선택 무작위 생성 (1:가위, 2:바위, 3:보 4:게임끝)
            Random random = new Random();
            int computerChoice = random.nextInt(3) + 1;
            if (userChoice == 4) {
                System.out.println("게임을 종료합니다!!");
                break;
            } else if (userChoice > 4) {
                System.out.println("1~4까지만 입력해주세요!");
                continue;
            }

            // 사용자와 컴퓨터의 선택 출력
            System.out.println("사용자 : " + change(userChoice));
            System.out.println("컴퓨터 : " + change(computerChoice));


            int choice = userChoice - computerChoice;

            if (choice == 0) {
                System.out.println("무승부");
            } else if (choice == -1 || choice == 2) {
                score = score - 2;
                System.out.println("패배");
            } else {
                score = score + 3;
                System.out.println("승리");
            }

            // 숫자를 문자열로 수정
        }
    }

    public static String change(int value) {
        switch (value) {
            case 1:
                return "가위";
            case 2:
                return "바위";
            case 3:
                return "보";
        }
        return "";
    }

}



