package org.example.member;

public class LoginMember {
    public void setLoginmember(String name){
        try {
            String[] loginmember = new String[0];
            loginmember[0] = name;
        }catch (Exception e){
            System.out.println("이미 로그인 되어 있습니다.");
        }
    }
}
