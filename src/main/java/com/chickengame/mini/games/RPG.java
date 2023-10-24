package com.chickengame.mini.games;

import com.chickengame.mini.model.dao.MemberDAO;

import java.util.Scanner;

public class RPG implements Game {
    @Override
    public void gameStart() {
        int score = MemberDAO.getInstance().getMe().getScore();
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------------- RPG 게임 --------------");
        System.out.print("캐릭터 이름을 입력하세요: ");
        String playerName = scanner.nextLine();

        // 캐릭터 초기 상태
        int playerHealth = 100;
        int playerAttack = 20;
        int playerLevel = 1;
        int experience = 0;

        System.out.println("안녕하세요, " + playerName + "! 레벨 " + playerLevel + "부터 게임을 시작합니다.");

        while (playerHealth > 0) {
            System.out.println("\n===== 메뉴 =====");
            System.out.println("1. 싸우기");
            System.out.println("2. 쉬기");
            System.out.println("3. 종료");
            System.out.print("메뉴를 선택하세요: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                // 몬스터 생성 및 전투
                int monsterHealth = 40;
                int monsterAttack = 10;
                System.out.println("==== 몬스터와 전투 ====");

                while (monsterHealth > 0 && playerHealth > 0) {
                    // 몬스터 공격
                    playerHealth -= monsterAttack;
                    System.out.println("몬스터가 플레이어를 공격했습니다. 플레이어의 체력: " + playerHealth);

                    // 플레이어 공격
                    monsterHealth -= playerAttack;
                    System.out.println("플레이어가 몬스터를 공격했습니다. 몬스터의 체력: " + monsterHealth);
                }

                if (playerHealth > 0) {
                    // 전투 승리
                    System.out.println("전투에서 승리했습니다!");
                    System.out.println("경험치를 획득하였습니다.");
                    experience += 20;
                    if (experience >= 100) {
                        playerLevel++;
                        experience -= 100;
                        System.out.println("레벨 업!!");
                        System.out.println("현재 레벨은 " + playerLevel + "입니다.");
                    }
                } else {
                    System.out.println("전투에서 패배했습니다. 게임 종료.");
                    MemberDAO.getInstance().getMe().setScore(((playerLevel*100+experience)/10)+score);
                    break;
                }
            }
            else if (choice == 2) {
                playerHealth += 20;
                System.out.println("체력이 회복되었습니다.");
                System.out.println("현재 체력은 " + playerHealth + "입니다.");
            }
            else if (choice == 3) {
                System.out.println("게임을 종료합니다.");
                MemberDAO.getInstance().getMe().setScore(((playerLevel*100+experience)/10)+score);
                break;
            } else {
                System.out.println("잘못된 선택입니다. 다시 선택하세요.");
            }
        }
    }
}
