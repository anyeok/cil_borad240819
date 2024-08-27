package org.example.member;

import org.example.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    public int create(String userid, String password) {
        String sql = String.format("INSERT INTO `member` SET userId = '%s', `password` = '%s', regDate = now()", userid, password);
        int id = Container.getDBConnection().insert(sql);
        return id;
    }

//    public List<Member> findAll() {
//        List<Member> memberList = new ArrayList<>();
//        List<Map<String, Object>> rows = Container.getDBConnection().selectRows("select * from member");
//        for (Map<String, Object> row : rows) {
//            Member member = new Member();
//            memberList.add(member);
//        }
//        return memberList;
//    }
}
