package com.chickengame.mini.view;

import com.chickengame.mini.model.dao.MemberDAO;
import com.chickengame.mini.model.dto.MemberDTO;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static java.util.Comparator.*;

public class MenuManager {
    private static MenuManager instance;
    private Scanner sc;

    private MenuManager() {
        sc = new Scanner(System.in);
    }

    public static MenuManager getInstance() {
        if (instance == null) {
            instance = new MenuManager();
        }
        return instance;
    }

    public boolean login() {
        System.out.println("== 로그인을 시작합니다 ==");
        System.out.print("아이디: ");
        String id = sc.nextLine();
        int index = MemberDAO.getInstance().containsMemberById(id);
        if (index < 0) {
            System.out.println("로그인에 실패했습니다.");
            return false;
        } else {
            System.out.println("기존 회원으로 로그인 하였습니다.");
            MemberDAO.getInstance().setMe(index);
            return true;
        }
    }

    public boolean register() {
        System.out.println("== 회원가입을 시작합니다 ==");
        System.out.print("아이디: ");
        String id = sc.nextLine();
        int index = MemberDAO.getInstance().containsMemberById(id);
        if (index < 0) {
            System.out.print("이름: ");
            String name = sc.nextLine();
            MemberDTO me = new MemberDTO(id, name);
            MemberDAO.getInstance().addMember(me);
            MemberDAO.getInstance().setMe(me);
            System.out.println("회원가입을 환영합니다.");
            return true;
        } else {
            System.out.println("이미 아이디가 있습니다.");
            return false;
        }
    }

    public void showRank() {
        List<MemberDTO> members = MemberDAO.getInstance().getMembers();
                System.out.println("== 전체 멤버를 출력합니다. ==");
                Collections.sort(members, new Comparator<MemberDTO>() {
                    @Override
                    public int compare(MemberDTO o1, MemberDTO o2) {
                        return 0;
                    }
                });
        for (MemberDTO member : members) {
            System.out.println(member);
        }
    }

    public void showProfile() {
        System.out.println("내 프로필을 출력합니다.");
        MemberDTO me = MemberDAO.getInstance().getMe();
        System.out.println(me);
    }

    public int updateProfile() {
        MemberDTO me = MemberDAO.getInstance().getMe();
        while (true) {
            System.out.println("내 프로필을 수정합니다.");
            System.out.println("1. 이름 수정");
            System.out.println("2. 계정 삭제");
            System.out.println("9. 이전 메뉴로 나가기");
            System.out.print("메뉴: ");
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    System.out.print("변경할 이름: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    me.setName(name);
                    System.out.println("변경이 완료됐습니다.");
                    return 0;
                case 2:
                    System.out.print("정말로 삭제하시겠습니까? (Y, N) : ");
                    sc.nextLine();
                    String delete = sc.nextLine();
                    if (delete.equalsIgnoreCase("Y")) {
                        MemberDAO.getInstance().deleteMe();
                        System.out.println("삭제를 완료했습니다. 게임을 종료합니다.");
                        return 1; // 게임을 종료하는 케이스
                    } else if (delete.equalsIgnoreCase("N")) {
                        System.out.println("메인 메뉴로 나갑니다.");
                    } else {
                        System.out.println("잘못 입력했습니다. 메인메뉴로 나갑니다.");
                    }
                    return 0;
                case 9:
                    System.out.println("이전 메뉴로 나갑니다.");
                    return 0;
                default:
                    System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
                    break;
            }
        }
    }
}