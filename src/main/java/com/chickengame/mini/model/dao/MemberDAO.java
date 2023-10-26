package com.chickengame.mini.model.dao;

import com.chickengame.mini.controller.ConnectAndClose;
import com.chickengame.mini.controller.DML;
import com.chickengame.mini.controller.GameManager;
import com.chickengame.mini.model.dto.MemberDTO;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

public class MemberDAO {
    private static MemberDAO instance;
    private List<MemberDTO> members;
    private MemberDTO me;
    private GameManager gameManager;

    private MemberDAO() {
        members = new ArrayList<>();
        me = new MemberDTO();
        gameManager = new GameManager();
//        members.add(new MemberDTO(10, "아이디01", "이름01", 5));
//        members.add(new MemberDTO(22, "아이디02", "이름02", 5));
//        members.add(new MemberDTO(40, "아이디03", "이름03", 5));
//        members.add(new MemberDTO(33, "아이디04", "이름04", 5));
//        members.add(new MemberDTO(12, "아이디05", "이름05", 5));
//        members.add(new MemberDTO(96, "아이디06", "이름06", 5));
//        members.add(new MemberDTO(33, "아이디07", "이름07", 5));
//        members.add(new MemberDTO(22, "아이디08", "이름08", 5));
//        members.add(new MemberDTO(16, "아이디09", "이름09", 5));
//        members.add(new MemberDTO(13, "아이디10", "이름10", 5));
//        save(); // 테스트할때 처음 파일을 만들어야 되니깐 이부분 주석을 제거합니다. 충분히 데이터가 채워졌다면 주석으로 만들면 됩니다.

        loadMembers(); //생성자 호출하면서 load() 부름
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

    public void setMe(MemberDTO memberDTO) {
        this.me = memberDTO;
    }

    public List<MemberDTO> getMembers() {
        return members;
    }

    public MemberDTO getMe() {
        return me;
    }

    public void sortScoreDESC() {
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

    public void deleteMe() {
        members.remove(me);
        gameManager.saveGameRankings_DELETE(me);
        saveMembers_DELETE(me);
        me = null;
    }


    public void addMember(MemberDTO memberDTO) {
        members.add(memberDTO);
        sortScoreDESC();
        save();
    }

    public void loadMembers() {
        Connection con = ConnectAndClose.getInstance().getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        String query = "SELECT " +
                "SUM(GR.SCORE) AS SCORE," +
                "M.NAME AS NAME," +
                "M.MEMBERID AS MEMBERID," +
                "M.REGISTDATE AS REGISTDATE " +
                "FROM MEMBERS M " +
                "JOIN GAMERANKINGS GR ON M.MEMBERID = GR.MEMBERID " +
                "GROUP BY M.MEMBERID,M.NAME,M.REGISTDATE " +
                "ORDER BY SCORE DESC";
        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
            int i = 1;
            int temp = 0;
            int inputScore = 0;
            while (rset.next()) {
                inputScore = rset.getInt("SCORE");
                if (temp == inputScore) {
                    i--;
                }
                MemberDTO memberDTO = new MemberDTO(
                        rset.getInt("SCORE"),
                        rset.getString("NAME"),
                        rset.getString("MEMBERID"),
                        rset.getTimestamp("REGISTDATE"),
                        i
                );
                temp = inputScore;
                members.add(memberDTO);
                i++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int saveMembers_INSERT() {
        Connection con = ConnectAndClose.getInstance().getConnection();
        PreparedStatement pstmt = null;
        int result = 0;
        Properties prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/chickengame/mini/model/dao/member-query.xml"));
            String query;
            query = prop.getProperty("insert");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int saveMembers_DELETE(MemberDTO me) {
        Connection con = ConnectAndClose.getInstance().getConnection();
        PreparedStatement pstmt = null;
        int result = 0;
        Properties prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/chickengame/mini/model/dao/member-query.xml"));
            String query;
            query = prop.getProperty("delete");
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,me.getId());
            result = pstmt.executeUpdate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int saveMembers_UPDATE() {
        Connection con = ConnectAndClose.getInstance().getConnection();
        PreparedStatement pstmt = null;
        int result = 0;
        Properties prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/chickengame/mini/model/dao/member-query.xml"));
            String query;
            query = prop.getProperty("update");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
