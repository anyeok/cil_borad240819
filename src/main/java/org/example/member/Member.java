package org.example.member;

import java.util.Map;

public class Member {
    private int id;
    private String memberid;
    private String memberpw;

    Member (Map<String, Object> row){
        this.id = (int)row.get("id");
        this.memberid = (String) row.get("memberid");
        this.memberpw = (String) row.get("memberpw");
    }

    public int getId() {
        return this.id;
    }

    public String getMemberid() {
        return this.memberid;
    }

    public String getMemberpw() {
        return this.memberpw;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public void setMemberpw(String memberpw) {
        this.memberpw = memberpw;
    }
}
