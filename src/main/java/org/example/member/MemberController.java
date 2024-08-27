package org.example.member;

import org.example.Container;

public class MemberController {
    Member member;
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
        LoginMember loginMember = new LoginMember();
        System.out.print("ID : ");
        String userid = Container.getSc().nextLine().trim();
        System.out.print("PW : ");
        String password = Container.getSc().nextLine().trim();

        try {
            if (search(member, userid, password)) {
                System.out.print("로그인에 성공하였습니다.");
                loginMember.setLoginmember(userid);
            } else if (false) {
                System.out.print("로그인에 실패하였습니다.");
            }
        }catch (Exception e){
            System.out.print("아이디가 없거나, 비밀번호와 일치하지 않습니다.");
        }
    }
    public void logout(){
        LoginMember loginMember = new LoginMember();
        System.out.print("로그아웃 되었습니다.");
        loginMember.setLoginmember("로그아웃");
    }
    public boolean search(Member member, String id, String pw){
        if (id.equals(member.getUserid()) && pw.equals(member.getPassword())){
            return true;
        }else {
            return false;
        }
    }
}