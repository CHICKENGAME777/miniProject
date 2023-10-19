package com.chickengame.mini.model;

import com.chickengame.mini.model.dto.MemberDTO;

import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    private static MemberDAO instance;
    private List<MemberDTO> members;
    private MemberDTO me;

    private MemberDAO() {
        members = new ArrayList<>();
        me = new MemberDTO();
        members.add(new MemberDTO(1, "아이디1", "이름1", 1));
        members.add(new MemberDTO(2, "아이디2", "이름2", 2));
        members.add(new MemberDTO(3, "아이디3", "이름3", 3));
        members.add(new MemberDTO(4, "아이디4", "이름4", 4));
        members.add(new MemberDTO(5, "아이디5", "이름5", 5));
        members.add(new MemberDTO(6, "아이디6", "이름6", 6));
        members.add(new MemberDTO(7, "아이디7", "이름7", 7));
        members.add(new MemberDTO(8, "아이디8", "이름8", 8));
        members.add(new MemberDTO(9, "아이디9", "이름9", 9));
        members.add(new MemberDTO(10, "아이디10", "이름10", 10));
    }

    public static MemberDAO getInstance() {
        if (instance == null) {
            instance = new MemberDAO();
        }
        return instance;
    }

    public int containsMemberById(String memberId) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId().equals(memberId)) {
                return i;
            }
        }
        return -1;
    }

    public void setMe(int index) {
        this.me = members.get(index);
    }

    public List<MemberDTO> getMembers() {
        return members;
    }

    public MemberDTO getMe() {
        return me;
    }

    public void addMember(MemberDTO memberDTO) {
        members.add(memberDTO);
        this.me = memberDTO;
    }
}
