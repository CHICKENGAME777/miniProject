package com.chickengame.mini.games;

import java.util.Random;
import java.util.Scanner;

public class UpDownGame implements Game{

    public static void main(String[] args) {

        System.out.println();
        System.out.println(" ☻UP☻  숫자를 맞춰보세요  ☻DOWN☻ ");
        System.out.println("˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖");
        System.out.println("       총 3번의 기회! \n   첫 번째 시도에 맞추면 5점 \n   두 번째 시도에 맞추면 3점 \n   세 번째 시도에 맞추면 1점");
        System.out.println("˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖");

        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        boolean isSuccess = false;
        int score = 5;

        while (true) {
            int rNum = r.nextInt(10) + 1;
            System.out.println(rNum);

            for (int i = 1; i <= 3; i++) {
                System.out.print("1 ~ 10 사이의 정수를 입력하세요 : ");
                int userNum = sc.nextInt();

                if (rNum > userNum) {
                    System.out.println("UP! 더 높은 숫자입니다.");
                    score -= 2;
                } else if (rNum < userNum) {
                    System.out.println("DOWN! 더 낮은 숫자입니다.");
                    score -= 2;
                } else {
                    System.out.println("맞추셨습니다! " + i + "번 째 시도에 성공하여 " + score + "점을 획득하셨습니다.");
                    isSuccess = true;
                    break;
                }
            }

            if (isSuccess == false) {
                System.out.println("실패!");
            }

            while (true) {
                System.out.println("˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖");
                System.out.print("게임을 더 진행하시겠습니까? (Y/N) : ");
                char ch = sc.next().charAt(0);
                sc.nextLine();
                if (ch == 'y' || ch == 'Y') {
                    System.out.println("게임 재시작!");
                    break;
                } else if (ch == 'n' || ch == 'N') {
                    return;
                } else {
                    System.out.println("Y 또는 N을 입력해주세요₍₍ (̨̡ ‾᷄⌂‾᷅)̧̢ ₎₎");
                }
            }



        }


    }


}
