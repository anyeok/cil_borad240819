package org.example.member;

import org.example.Container;
import org.example.Request;
import org.example.article.Article;

import java.util.ArrayList;
import java.util.List;

public class MemberController {
    MemberService memberService;
    public MemberController () {
        memberService = new MemberService();
    }
    public void singup(){
        System.out.print("회원가입 ID : ");
        String userid = Container.getSc().nextLine().trim();
        System.out.print("비밀번호 PW : ");
        String password = Container.getSc().nextLine().trim();

        int id = memberService.create(userid, password);

        System.out.printf("%d번 회원이 등록되었습니다.\n", id);
    }
    public void login(){
        MemberRepository memberRepository = new MemberRepository();
        System.out.print("ID : ");
        String userid = Container.getSc().nextLine().trim();
        System.out.print("PW : ");
        String password = Container.getSc().nextLine().trim();

        for(userid : memberRepository.findAll()){

        }

    }
    public void serch(Member member){

    }
}