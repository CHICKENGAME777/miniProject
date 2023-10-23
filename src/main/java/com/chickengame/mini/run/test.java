package com.chickengame.mini.run;

import com.chickengame.mini.model.dao.MemberDAO;
import com.chickengame.mini.model.dto.MemberDTO;

import java.util.List;

public class test {
    public static void main(String[] args) {
        List<MemberDTO> list = MemberDAO.getInstance().getMembers();
        for (var x : list) {
            System.out.println(x);
        }
    }
}
