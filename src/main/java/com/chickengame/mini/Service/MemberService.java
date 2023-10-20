package com.chickengame.mini.Service;

import com.chickengame.mini.model.dao.MemberDAO;
import com.chickengame.mini.model.dto.MemberDTO;

import java.util.Comparator;
import java.util.List;

public class MemberService {
    private MemberDAO memberDAO;

    public void addMember(MemberDTO memberDTO) {
        memberDAO = MemberDAO.getInstance();
        List<MemberDTO> members = memberDAO.getMembers();
        members.add(memberDTO);
        members.sort(new Comparator<>() {
            @Override
            public int compare(MemberDTO o1, MemberDTO o2) {
                return o2.getScore() - o1.getScore();
            }
        });
        members.get(0).setRank(1);
        for (int i = 1; i < members.size(); i++) {
            if (members.get(i - 1).getScore() == members.get(i).getScore()) {
                members.get(i).setRank(members.get(i - 1).getRank());
            } else {
                members.get(i).setRank(i + 1);
            }
        }
    }

    public int containsMemberById(String memberId) {
        memberDAO = MemberDAO.getInstance();
        List<MemberDTO> members = memberDAO.getMembers();
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId().equals(memberId)) {
                return i;
            }
        }
        return -1;
    }
}
