package com.chickengame.mini.controller;

import com.chickengame.mini.games.*;
import com.chickengame.mini.model.dao.MemberDAO;
import com.chickengame.mini.model.dto.GameDTO;
import com.chickengame.mini.model.dto.GameRankingDTO;
import com.chickengame.mini.model.dto.MemberDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.*;

public class GameManager {
    Date currentDate = new Date();
    private List<GameInterface> gameMenuList;
    private List<GameDTO> gameList;
    private List<GameRankingDTO> gameRankingList;
    private List<GameRankingDTO> meGameRankingList;

    Scanner sc;

    public GameManager() {
        gameMenuList = new ArrayList<>();
        gameList = new ArrayList<>();
        gameRankingList = new ArrayList<>();
        meGameRankingList = new ArrayList<>();
        sc = new Scanner(System.in);
        loadGames();
        loadGameRankings();
        // ...
    }


    public void gameStart() {
        loadGameRankings(MemberDAO.getInstance().getMe());
        gameMenuList.add(new UpDownGame(meGameRankingList.get(0)));
        gameMenuList.add(new SlotMachine777(meGameRankingList.get(1)));
        gameMenuList.add(new Lotto(meGameRankingList.get(2)));
        gameMenuList.add(new RSP(meGameRankingList.get(3)));
        gameMenuList.add(new SleepyCrocodile(meGameRankingList.get(4)));
        gameMenuList.add(new RPG(meGameRankingList.get(5)));
        while (true) {
            System.out.println();
            System.out.println(MemberDAO.getInstance().getMe().getName() + " 님! 게임을 선택해주세요.");
            for (int i = 0; i < gameList.size(); i++) {
                System.out.print((gameList.get(i).getGameId() + 1) + ". " + gameList.get(i).getGameName());
                System.out.println("(현재 점수: " + meGameRankingList.get(i).getScore() + ")");
            }
            // ...
            System.out.println("9. 메인 메뉴로 돌아가기");
            try {
                System.out.print("메뉴: ");
                int num = sc.nextInt();
                sc.nextLine();
                if (num == 9) {
                    return;
                }
                if (gameMenuList.size() < num || num <= 0) {
                    System.out.println("다시 입력해주세요.");
                } else {
                    gameMenuList.get(num - 1).gameStart();
                    saveGameRankings_UPDATE(meGameRankingList.get(num - 1));
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자로 입력해주세요.");
                sc.nextLine();
            }
        }
    }

    public void loadGames() {
        Connection con = ConnectAndClose.getInstance().getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        GameDTO gameDTO;
        String query = "SELECT * FROM GAMES";
        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                gameDTO = new GameDTO(
                        rset.getInt("GameID"),
                        rset.getString("GameName")
                );
                gameList.add(gameDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectAndClose.getInstance().close(rset);
            ConnectAndClose.getInstance().close(stmt);
        }
    }

    public void loadGameRankings() {
        Connection con = ConnectAndClose.getInstance().getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        GameRankingDTO gameRankingDTO;
        String query = "SELECT * FROM GAMERANKINGS";
        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                gameRankingDTO = new GameRankingDTO(
                        rset.getInt("RankingID"),
                        rset.getString("MemberID"),
                        rset.getInt("GameID"),
                        rset.getInt("Score"),
                        rset.getTimestamp("RankDate")
                );
                gameRankingList.add(gameRankingDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectAndClose.getInstance().close(rset);
            ConnectAndClose.getInstance().close(stmt);
        }
    }

    public void loadGameRankings(MemberDTO memberDTO) {
        for (var gameRanking : gameRankingList) {
            if (memberDTO.getId().equals(gameRanking.getMemberId())) {
                meGameRankingList.add(gameRanking);
            }
        }
    }

    public int saveGameRankings_INSERT(MemberDTO me) {
        Connection con = ConnectAndClose.getInstance().getConnection();
        PreparedStatement pstmt = null;
        int result = 0;
        Properties prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/chickengame/mini/controller/game-ranking-query.xml"));
            String query = prop.getProperty("insert");
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, me.getId());
            pstmt.setInt(3, me.getScore() / 6);
            pstmt.setTimestamp(4, me.getRegistDate());
            for (int i = 0; i < gameList.size(); i++) {
                pstmt.setInt(2, i);
                result = pstmt.executeUpdate();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectAndClose.getInstance().close(pstmt);
        }
        return result;
    }

    public int saveGameRankings_DELETE(MemberDTO me) {
        Connection con = ConnectAndClose.getInstance().getConnection();
        PreparedStatement pstmt = null;
        int result;
        Properties prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/chickengame/mini/controller/game-ranking-query.xml"));
            String query = prop.getProperty("delete");
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, me.getId());
            result = pstmt.executeUpdate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectAndClose.getInstance().close(pstmt);
        }
        return result;
    }

    public int saveGameRankings_UPDATE(GameRankingDTO gameRankingDTO) {
        Connection con = ConnectAndClose.getInstance().getConnection();
        PreparedStatement pstmt = null;
        int result;
        Properties prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/chickengame/mini/controller/game-ranking-query.xml"));
            String query = prop.getProperty("update");
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, gameRankingDTO.getScore());
            pstmt.setTimestamp(2, new Timestamp(currentDate.getTime()));
            pstmt.setInt(3, gameRankingDTO.getRankingId());
            result = pstmt.executeUpdate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectAndClose.getInstance().close(pstmt);
        }
        return result;
    }
}
