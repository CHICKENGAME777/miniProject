package com.chickengame.mini.games;

import java.util.Scanner;

public class slotMachine777 implements Game {

        public static void Game() {

            /* 슬롯머신 777
             *
             * 1. 인덱스에 문자 세 개 입력 (7, ♥, ⑩)
             * 2. random 선언
             * 3. index 번호에 맞는 문자 세 개 출력
             *
             * */

//        Scanner sc = new Scanner(System.in);

//        System.out.println("=============");
//        System.out.println("| 7 | ♥ | ⑩ | ");
//        System.out.println("=============");
//        System.out.println("");
//        System.out.println("축하합니다. 0 0 0 당첨입니다!);



            int score = 50;             // 마일리지
            int count = 0;              // 몇 번 만에 당첨 되는지
            int discount = -1;          // 마일리지 차감
            int correct = 50;           // 당첨되면 주는 마일리지

            Scanner sc = new Scanner(System.in);
            System.out.printf("%55s", "\u001B[33m=============\n");

            System.out.printf("%53s", "\u001B[33m| 슬롯머신777 |\n");
            System.out.printf("%56s", "\u001B[33m=============\n\n");
            while (true) {
                System.out.print("\u001B[0m");
                System.out.print("슬롯머신777을 돌리시겠습니까? ( Y / N ): ");
                char user = sc.next().charAt(0);

                if (user == 'Y') {
                    if(score == 0) {
                        System.out.printf("\n%55s", "\u001B[33m남은 기회가 없습니다.\n");
                        System.out.printf("\n%51s", "슬롯머신777을 종료합니다.\n");
                        System.out.print("\u001B[0m");
                        break;
                    }

                    String stringArray[] = {"\u001B[31m7", "\u001B[34m♥", "\u001B[32m⑩"};


                    int random = 0;
                    int temp[] = new int[3];

                    System.out.printf("\n%50s", "=============");
                    System.out.print("\u001B[0m");
                    System.out.printf("\n%39s", "| ");
                    System.out.print("\u001B[0m");
//          String str = "";
                    for (int i = 0; i < stringArray.length; i++) {
                        random = (int) (Math.random() * 3);
                        System.out.print("\u001B[0m");
//          str += stringArray[random] + "\u001B[0m | ";
                        System.out.print(stringArray[random] + "\u001B[0m | ");
                        System.out.print("\u001B[0m");
                        temp[i] = random;
                    }
                    score--;
                    count++;

                    System.out.printf("\n%50s", "=============");
                    System.out.printf("\n%52s", "* 마일리지를" + discount + "차감 했습니다. *\n");

//temp[0] = 0;
//temp[1] = 0;              // 잘 출력 되는지 시험
//temp[2] = 0;

                    if (temp[0] == 0 && temp[1] == 0 && temp[2] == 0) {
                        score += 50;
                        System.out.printf("\n%57s", "\u001B[33m︵‿︵‿︵‿︵‿︵‿︵︵‿︵‿︵‿︵‿︵‿︵\n");
                        System.out.printf("\n%53s", "축하합니다. 7 7 7 당첨입니다!\n\n");
                        System.out.printf("%54s", "︵‿︵‿︵‿︵‿︵‿︵︵‿︵‿︵‿︵‿︵‿︵\n\n\n");
                        System.out.print("\u001B[0m");
                        System.out.printf("%54s", "! ! ! " + count + "번 만에 당첨 ! ! !\n");
                        System.out.printf("%52s", "마일리지 " + correct + "점을 추가합니다.\n\n");
                        count = 0;
                    } else if (temp[0] == 1 && temp[1] == 1 && temp[2] == 1) {
                        score += 50;
                        System.out.printf("\n%57s", "\u001B[33m︵‿︵‿︵‿︵‿︵‿︵︵‿︵‿︵‿︵‿︵‿︵\n");
                        System.out.printf("\n%53s", "축하합니다. ♥ ♥ ♥ 당첨입니다!\n\n");
                        System.out.printf("%54s", "︵‿︵‿︵‿︵‿︵‿︵︵‿︵‿︵‿︵‿︵‿︵\n\n\n");
                        System.out.print("\u001B[0m");
                        System.out.printf("%54s", "! ! ! " + count + "번 만에 당첨 ! ! !\n");
                        System.out.printf("%52s", "마일리지 " + correct + "점을 추가합니다.\n\n");
                        count = 0;
                    } else if (temp[0] == 2 && temp[1] == 2 && temp[2] == 2) {
                        score += 50;
                        System.out.printf("\n%57s", "\u001B[33m︵‿︵‿︵‿︵‿︵‿︵︵‿︵‿︵‿︵‿︵‿︵\n");
                        System.out.printf("\n%53s", "축하합니다. ⑩ ⑩ ⑩ 당첨입니다!\n\n");
                        System.out.printf("%54s", "︵‿︵‿︵‿︵‿︵‿︵︵‿︵‿︵‿︵‿︵‿︵\n\n\n");
                        System.out.print("\u001B[0m");
                        System.out.printf("%54s", "! ! ! " + count + "번 만에 당첨 ! ! !\n");
                        System.out.printf("%52s", "마일리지 " + correct + "점을 추가합니다.\n\n");
                        System.out.print("\u001B[0m");
                        count = 0;
                    } else {
//            System.out.println("");
                        System.out.printf("\n%45s", "꽝!\n");
                    }
                    System.out.printf("%52s", "남은 마일리지는 " + score + "점 입니다.\n\n");
                } else if(user == 'N') {
                    System.out.printf("\n%50s", "\u001B[33m슬롯머신777을 종료합니다.");
                    System.out.print("\u001B[0m");
                    break;
                } else {
                    System.out.println("잘못 입력하셨습니다. 다시 입력하세요.\n");
                }
            }
        }
    }

