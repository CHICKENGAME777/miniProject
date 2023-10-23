package com.chickengame.mini.run;

import com.chickengame.mini.model.dao.MemberDAO;
import com.chickengame.mini.model.dto.MemberDTO;

import java.util.List;

public class test {
    public static void main(String[] args) {
        var x = MemberDAO.getInstance();
        List<MemberDTO> list = x.getMembers();
        for (var t : list) {
            System.out.println(t);
        }
    }
}
