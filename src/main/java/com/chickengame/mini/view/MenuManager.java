package com.chickengame.mini.view;

import com.chickengame.mini.model.MemberDAO;
import com.chickengame.mini.model.dto.MemberDTO;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MenuManager {
    private MemberDAO memberDAO = MemberDAO.getInstance();
    private static MenuManager instance;
    Scanner sc = new Scanner(System.in);

    private MenuManager() {
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
        int index = memberDAO.containsMemberById(id);
        if (index < 0) {
            System.out.println("로그인에 실패했습니다.");
            return false;
        } else {
            System.out.println("기존 회원으로 로그인 하였습니다.");
            memberDAO.setMe(index);
            return true;
        }
    }

    public boolean register() {
        System.out.println("== 회원가입을 시작합니다 ==");
        System.out.print("아이디: ");
        String id = sc.nextLine();
        int index = memberDAO.containsMemberById(id);
        if (index < 0) {
            System.out.print("이름: ");
            String name = sc.nextLine();
            memberDAO.addMember(new MemberDTO(id, name));
            System.out.println("회원가입을 환영합니다.");
            return true;
        } else {
            System.out.println("이미 아이디가 있습니다.");
            return false;
        }
    }

    public void showRank() {
        List<MemberDTO> members = memberDAO.getMembers();
        members.sort(new Comparator<>() {
            @Override
            public int compare(MemberDTO o1, MemberDTO o2) {
                return o1.getScore() - o2.getScore();
            }
        });
        System.out.println("== 전체 멤버를 출력합니다. ==");
        for (MemberDTO member : members) {
            System.out.println(member);
        }
    }

    public void showProfile() {
        System.out.println("내 프로필을 출력하빈다.");
        MemberDTO me = memberDAO.getMe();
        System.out.println(me);
    }
}
