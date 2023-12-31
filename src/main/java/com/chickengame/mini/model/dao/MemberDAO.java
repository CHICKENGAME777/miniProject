package com.chickengame.mini.model.dao;

import com.chickengame.mini.model.dto.MemberDTO;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MemberDAO {
    private static MemberDAO instance;
    private List<MemberDTO> members;
    private MemberDTO me;

    private MemberDAO() {
        members = new ArrayList<>();
        me = new MemberDTO();

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

        load(); //생성자 호출하면서 load() 부름
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
        me = null;
        sortScoreDESC();
        save();
    }


    public void addMember(MemberDTO memberDTO) {
        members.add(memberDTO);
        sortScoreDESC();
        save();
    }

    public void load() {
        ObjectInputStream objIn = null;
        try {
            objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(
                    "src/main/java/com/chickengame/mini/model/members.txt"
            )));
            while (true) {
                members.add((MemberDTO) objIn.readObject());
            }
        } catch (EOFException e){}
        catch (IOException e){
        }
        catch (ClassNotFoundException e) {
        } finally {
            if (objIn != null) {
                try {
                    objIn.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public void save() {
        ObjectOutputStream objOut = null;

        try {
            objOut = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    "src/main/java/com/chickengame/mini/model/members.txt"
                            )
                    )
            );
            for (int i = 0; i < members.size(); i++) {
                objOut.writeObject(members.get(i));
            }
            objOut.flush();
            System.out.println("성공적으로 저장되었습니다.");
        } catch (IOException e) {
        } finally {
            if (objOut != null) {
                try {
                    objOut.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
