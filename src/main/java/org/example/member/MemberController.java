package org.example.member;

import org.example.Container;
import org.example.Request;

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
    public void list(){
        List<Member> memberList = memberService.findAll();
        System.out.println("번호 / 제목 / 내용");
        System.out.println("----------------------");
        for (int i = memberList.size() - 1; i >= 0; i--) {
            Member member = memberList.get(i);
            System.out.printf("%d / %s\n", member.getId(), member.getUserid());
        }
    }
    public void delete(Request request) {
        int id = _getIntParam(request.getParams("id"));

        if (id == -1) {
            System.out.println("잘못된 입력입니다. ex)삭제?id=1&id=2");
            return;
        }

        Member member = this.memberService.findById(id);

        if (member == null) {
            System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
        } else {
            memberService.remove(member);
            System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);
        }
    }

    private int _getIntParam(String id) {
        int defaultValue = -1;
        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}