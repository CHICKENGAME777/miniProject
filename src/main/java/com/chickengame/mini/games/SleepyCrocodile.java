package com.chickengame.mini.games;

import java.util.Scanner;

public class SleepyCrocodile implements Game {
    @Override
    public void gameStart() {


        Scanner sc = new Scanner(System.in);
        System.out.println("잠든 악어의 아픈 이빨을 피해 모든 이빨을 눌러보세요!");


        int[][] tooth = new int[2][10];
        boolean[] usedNumbers = new boolean[20]; // 인덱스 0에서 19까지 사용된 숫자를 추적

        for (int i = 0; i < tooth.length; i++) {
            for (int j = 0; j < tooth[i].length; j++) {
                int randomNumber;
                do {
                    // 1에서 20 사이의 랜덤 숫자 생성
                    randomNumber = (int) (Math.random() * 20 + 1);
                } while (usedNumbers[randomNumber - 1]); // 이미 사용된 숫자인지 확인

                tooth[i][j] = randomNumber;
                usedNumbers[randomNumber - 1] = true; // 사용된 숫자로 표시

                System.out.print(tooth[i][j] + " ");
            }
            System.out.println();
        }
    }
}







//        int tooth[][] = new int[2][10];
//
//
//        System.out.println("게임을 진행하시겠습니까? ( Y / N ) : ");
//        char user = sc.next().charAt(0);
//        if(user == 'Y') {
//            for (int i = 0; i < tooth.length; i++) {
//                for (int j = 0; j < tooth[i].length; j++) {
//
//                    tooth[i][j] = (int)(Math.random() * 20 + 1);
//                    System.out.print(tooth[i][j] + " ");
//                }
//                System.out.println();
//            }
//        }
