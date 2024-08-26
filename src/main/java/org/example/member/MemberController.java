package org.example.member;

import org.example.Container;

import java.util.ArrayList;
import java.util.List;

public class MemberController {
    MemberService memberService;
    public MemberController () {
        memberService = new MemberService();
    }
     public void singup(){
         System.out.print("회원가입 ID : ");
         String memberid = Container.getSc().nextLine().trim();
         System.out.print("비밀번호 PW : ");
         String memberpw = Container.getSc().nextLine().trim();

         int id = memberService.create(memberid, memberpw);

         System.out.printf("%d번 회원이 등록되었습니다.\n", id);
    }
    public void list(){
        List<Member> memberList = memberService.findAll();
        System.out.println("번호 / 제목 / 내용");
        System.out.println("----------------------");
        for (int i = memberList.size() - 1; i >= 0; i--) {
            Member member = memberList.get(i);
            System.out.printf("%d / %s\n", member.getId(), member.getMemberid());
        }
    }
}