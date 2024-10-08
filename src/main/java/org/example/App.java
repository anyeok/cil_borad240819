package org.example;

import org.example.article.ArticleController;
import org.example.db.DBConnection;
import org.example.member.MemberController;
import org.example.system.SystemController;

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
        memberController = new MemberController();
    }

    public void run() {
        System.out.println("== 게시판 앱 ==");

        System.out.print("명령) ");
        String command = Container.getSc().nextLine().trim();
        Request request = new Request(command);

        while (true) {
            if (request.getActionCode().equals("종료")) {
                systemController.exit();
                break;
            } else if (request.getActionCode().equals("등록")) {
                articleController.write();
                break;
            } else if (request.getActionCode().equals("목록")) {
                articleController.list();
                break;
            } else if (request.getActionCode().startsWith("삭제")) {
                articleController.delete(request);
                break;
            } else if (request.getActionCode().startsWith("수정")) {
                articleController.modify(request);
                break;
            } else if (request.getActionCode().startsWith("리셋")) {
                articleController.reset();
                break;
            } else if (request.getActionCode().startsWith("회원가입")) {
                memberController.singup();
                break;
            } else if (request.getActionCode().equals("로그인")) {
                memberController.login();
                break;
            } else if (request.getActionCode().equals("로그아웃")) {
                memberController.logout();
                break;
            }
        }
    }
}