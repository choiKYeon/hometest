package org.example;

import org.example.system.controller.SystemController;
import org.example.wisesaying.controller.WiseSayingController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App { // 시스템을 켜고 끈다.

    public void run() {
        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = Container.getScanner().nextLine().trim();
            Request request = new Request(command);

            switch (request.getActionCode()){
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    wiseSayingController.write();
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;
                case "삭제":
                    wiseSayingController.remove(request);
                    break;
                case "수정":
                    wiseSayingController.modify(request);
                    break;
            }
        }
    }
}


