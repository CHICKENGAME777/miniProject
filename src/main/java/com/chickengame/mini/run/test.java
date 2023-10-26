//package com.chickengame.mini.run;
//
//import com.chickengame.mini.model.dao.MemberDAO;
//import com.chickengame.mini.model.dto.MemberDTO;
//
//public class test {
//    public static void main(String[] args) {
//        var x = MemberDAO.getInstance();
//
//        x.addMember(new MemberDTO(150, "아이디1", "이름1", "2023-09-30 12:16:23", 1));
//        x.addMember(new MemberDTO(110, "아이디2", "이름2", "2022-11-21 01:13:45", 1));
//        x.addMember(new MemberDTO(557, "아이디3", "이름3", "2022-03-14 05:37:55", 1));
//        x.addMember(new MemberDTO(380, "아이디4", "이름4", "2021-05-05 17:20:33", 1));
//        x.addMember(new MemberDTO(230, "아이디5", "이름5", "2020-02-01 19:24:01", 1));
//        x.addMember(new MemberDTO(230, "아이디6", "이름6", "2023-01-08 15:11:33", 1));
//        x.addMember(new MemberDTO(380, "아이디7", "이름7", "2019-12-02 19:28:32", 1));
//        x.addMember(new MemberDTO(557, "아이디8", "이름8", "2020-11-05 04:27:44", 1));
//        x.addMember(new MemberDTO(10, "아이디9", "이름9", "2023-10-24 09:24:01", 1));
//        x.sortScoreDESC();
//        for (var i : x.getMembers()) {
//            System.out.println(i);
//        }
//    }
//}
