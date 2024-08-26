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

    public List<Member> findAll() {
        return MemberRepository.findAll();
    }

    public Member findById(int id) {
        return MemberRepository.findById(id);
    }

    public void remove(Member member) {
        MemberRepository.remove(member);
    }

//    public void modify(Member member, String modifySubject, String modifyContent) {
//        MemberRepository.modify(article, modifySubject, modifyContent);
//    }

//    public void reset() {
//        MemberRepository.reset();
//    }
}
