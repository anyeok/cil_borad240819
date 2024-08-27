package org.example;

import org.example.article.ArticleController;
import org.example.db.DBConnection;
import org.example.member.MemberController;
import org.example.system.SystemController;

import java.util.List;
import java.util.Map;

public class App {
    ArticleController articleController;
    SystemController systemController;
    MemberController memberController;


    App() {
        DBConnection.DB_NAME = "proj1";
        DBConnection.DB_PORT = 3306;
        DBConnection.DB_USER = "root";
        DBConnection.DB_PASSWORD = "";

        Container.getDBConnection().connect();

        articleController = new ArticleController();
        systemController = new SystemController();
    }

    public void run() {
        System.out.println("== 게시판 앱 ==");
        while (true) {
            System.out.print("ex) o, x 회원여부 : ");
            String command = Container.getSc().nextLine().trim();

            Request request = new Request(command);

            if(request.getActionCode().equals("o")) {
                System.out.println("명령)");
                if (request.getActionCode().equals("종료")) {
                    systemController.exit();
                    break;
                } else if (request.getActionCode().equals("로그인")) {
                    memberController.login();
                } else if (request.getActionCode().equals("로그아웃")) {
                    memberController.logout();
                } else if (request.getActionCode().equals("등록")) {
                    articleController.write();
                } else if (request.getActionCode().equals("목록")) {
                    articleController.list();
                } else if (request.getActionCode().startsWith("삭제")) {
                    articleController.delete(request);
                } else if (request.getActionCode().startsWith("수정")) {
                    articleController.modify(request);
                } else if (request.getActionCode().startsWith("리셋")) {
                    articleController.reset();
                }
            } else if(request.getActionCode().equals("x")){
                System.out.println("'회원가입'을 입력하여 회원가입을 진행하여주세요.");
                if (request.getActionCode().startsWith("회원가입")) {
                    memberController.singup();
                }
            }
        }
    }
}