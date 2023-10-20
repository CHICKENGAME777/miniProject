package com.chickengame.mini.games;

import com.chickengame.mini.model.dao.MemberDAO;
import com.chickengame.mini.model.dto.MemberDTO;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class UpDownGame implements Game{

    public void gameStart() {
        // 작업 된 것
        // 1. 계정의 스코어 점수 게임과 연동
        // 2. Game Interface 구현
        // 3. try catch로 문자열 입력했을 때 런타임에러 방지 처리

        // 작업해 줘야 할 것
        // 1. 내 계정의 스코어가 부족하면 게임을 더 할 수 없게
        // 2. 플레이 할 때 계정에 남은 스코어 보여주기
        // 3. 스코어 몇 점 깎는지 보여주기
        System.out.println();
        System.out.println(" ☻UP☻  숫자를 맞춰보세요  ☻DOWN☻ ");
        System.out.println("˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖");
        System.out.println("       총 3번의 기회! \n   첫 번째 시도에 맞추면 5점 \n   두 번째 시도에 맞추면 3점 \n   세 번째 시도에 맞추면 1점");
        System.out.println("˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖✧˖");

        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        boolean isSuccess = false;
        int score = MemberDAO.getInstance().getMe().getScore(); // 내 계정의 스코어를 뜻함
        int[] reward = {1,3,5};        //보상으로 주는 스코어를 뜻함

        while (true) {
            int rNum = r.nextInt(10) + 1;
            System.out.println(rNum);

            for (int i = 1; i <= 3; i++) {
                System.out.print("1 ~ 10 사이의 정수를 입력하세요 : ");
                int userNum;
                try {
                    userNum = sc.nextInt();
                    if (rNum > userNum) {
                        System.out.println("UP! 더 높은 숫자입니다.");
                        score -= 2;
                    } else if (rNum < userNum) {
                        System.out.println("DOWN! 더 낮은 숫자입니다.");
                        score -= 2;
                    } else {
                        System.out.println("맞추셨습니다! " + i + "번 째 시도에 성공하여 " + reward[i-1] + "점을 획득하셨습니다.");
                        isSuccess = true;
                        MemberDAO.getInstance().getMe().setScore(score + reward[i-1]);
                        break;
                    }
                }catch (InputMismatchException e){
                    System.out.println("올바른 수를 입력해주세요.");
                    sc.nextLine();
                    i--;
                }
            }

            if (!isSuccess) {
                System.out.println("실패!");
                MemberDAO.getInstance().getMe().setScore(score);
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
