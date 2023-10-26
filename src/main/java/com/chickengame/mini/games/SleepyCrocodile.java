package com.chickengame.mini.games;

import com.chickengame.mini.model.dao.MemberDAO;

import java.util.Scanner;

public class SleepyCrocodile implements Game {
    @Override
    public void gameStart() {
        Scanner sc = new Scanner(System.in);
        int mile = MemberDAO.getInstance().getMe().getScore();
        System.out.printf("\n%25s", "당신의 현재 스코어 : "+mile+"점");
        System.out.printf("\n%25s", "┌───────────────────┐");
        System.out.printf("\n%25s", "|  SleepyCrocodile  |");
        System.out.printf("\n%26s", "└───────────────────┘\n");
        System.out.printf("\n%25s", "\u001B[31m잠든 악어의 아픈 이빨을 피해");
        System.out.printf("\n%26s", "\u001B[31m모든 이빨을 눌러보세요!\n\n");


        int[][] tooth = new int[2][10];
        boolean[][] isOpen = new boolean[2][10];
        int score = 0;


//        boolean[] usedNumbers = new boolean[20]; // 인덱스 0에서 19까지 사용된 숫자를 추적
//        for (int i = 0; i < tooth.length; i++) {
//            for (int j = 0; j < tooth[i].length; j++) {
//                int randomNumber;
//                do {
//                    // 1에서 20 사이의 랜덤 숫자 생성
//                    randomNumber = (int)(Math.random() * 20 + 1);
//                } while (usedNumbers[randomNumber - 1]  ==  true); // 이미 사용된 숫자인지 확인
//
//                tooth[i][j] = randomNumber;
//                usedNumbers[randomNumber - 1] = true; // 사용된 숫자로 표시
//            }
//        }
        int randomNumber = (int) (Math.random() * 20 + 1);

        tooth[(randomNumber - 1) / 10][(randomNumber - 1) % 10] = 1;


        while (true) {
            System.out.printf("\n%25s", "\u001B[32m‿︵‿︵‿︵‿︵‿︵‿︵\n");
            System.out.print("\u001B[0m                                              Z       Z");
            System.out.printf("\n%18s", "            | | |                        Z  Z\n");
            System.out.printf("\n%20s", "            | | |                 z   Z\n\n");
            System.out.println("       U              U      ");
            System.out.print("\u001B[0m");
            System.out.println("             ..            ");
            System.out.println("\u001B[32m︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵");
            System.out.print("\u001B[0m");

            for (int i = 0; i < tooth.length; i++) {
                for (int j = 0; j < tooth[i].length; j++) {
                    if (isOpen[i][j] == false) {
                        System.out.print("\u001B[33mO  ");
                        System.out.print("\u001B[0m");
                    } else {
                        System.out.print("X  ");    //  열면, 해당하는 곳의 숫자를 보여주겠다
                    }
                }
                System.out.println();
            }
            System.out.println("\u001B[32m︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵\n");
            System.out.print("\u001B[0m");

            System.out.print("\n1부터 20까지의 숫자중 한 개를 입력하세요. : ");
            try {
                int user = sc.nextInt();
                if (user >= 1 && user <= 20) {                                 // 정수를 범위( ~20) 밖으로 입력 했을 때
                    if (isOpen[(user - 1) / 10][(user - 1) % 10] == true) {
                        System.out.println("이미 뽑은 번호입니다. 다시 입력해 주세요.");
                    } else {
                        if (tooth[(user - 1) / 10][(user - 1) % 10] == 1) {
                            System.out.printf("\n%25s", "\u001B[32m‿︵‿︵‿︵‿︵‿︵‿︵\n");
                            System.out.print("\u001B[0m");
                            System.out.printf("\n%45s", "| | |                ╬         ╬\n");
                            System.out.printf("\n%34s", "| | |              ╬\n\n");
                            System.out.println("\u001B[31m      ʘ              ʘ      ");
                            System.out.print("\u001B[0m");
                            System.out.println("             ..            ");
                            System.out.println("\u001B[32m︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵");
                            System.out.print("\u001B[0m");
                            System.out.println("\u001B[31mV V  V  V  V  V  V  V  V  V ");
                            System.out.println("\u001B[31m^ ^  ^  ^  ^  ^  ^  ^  ^  ^ ");
                            System.out.print("\u001B[0m");
                            System.out.printf("%25s", "\u001B[32m︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵\n\n");
                            System.out.print("\u001B[0m");
                            System.out.println("  악어가 깨어났습니다. 도망치세요!");
                            System.out.println("\u001B[33m   총 누적 점수는 " + score + "점 입니다.\n");
                            MemberDAO.getInstance().getMe().setScore(mile+score);
                            System.out.print("\u001B[0m");
                            return;
                        }

                        isOpen[(user - 1) / 10][(user - 1) % 10] = true;    //  좌표
                        score++;
//                    score = 19;             // score 확인
                        System.out.println("\u001B[33m    현재 누적 점수는 " + score + "점 입니다.\n");
                        if (score == 19) {
                            System.out.println("\u001B[31m악어의 아픈 이빨을 피해 이빨 누르기 성공!");
                            System.out.print("\u001B[0m");
                            MemberDAO.getInstance().getMe().setScore(mile+score);
                            break;
                        }
                    }
                } else {
                    System.out.println("\n\n\u001B[31m잘못 입력하셨습니다. 1에서 20 사이의 값을 입력하세요.\n\n");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("\n\n\u001B[31m숫자가 아닌 값을 입력하셨습니다. 1에서 20 사이의 값을 입력하세요.\n\n");
                sc.next();                   // 에러를 제대로 처리하기 위해 입력 버퍼 비우기
            }
        }
    }
}