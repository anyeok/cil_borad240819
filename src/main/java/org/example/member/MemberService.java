package org.example.member;

import org.example.article.Article;

import java.util.List;

public class MemberService {
    MemberRepository MemberRepository;

    public MemberService() {
        MemberRepository = new MemberRepository();
    }

    public int create(String userid, String password) {
        return MemberRepository.create(userid, password);
    }
    public void search(String userid, String password){

    }
}
