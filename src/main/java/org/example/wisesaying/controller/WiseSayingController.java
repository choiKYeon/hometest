package org.example.wisesaying.controller;

import org.example.Container;
import org.example.Request;
import org.example.wisesaying.entity.WiseSaying;

import java.util.*;

public class WiseSayingController {
    long lastWiseSayingId = 0;
    List<WiseSaying> wiseSayings = new ArrayList<>();
    public void write() {
        long id = lastWiseSayingId + 1;

        System.out.println("명언을 등록합니다.");
        System.out.print("명언 :");
        String content = Container.getScanner().nextLine().trim();
        System.out.print("작가 :");
        String author = Container.getScanner().nextLine().trim();// trim은 앞 뒤에 공백을 방지하기 위해 공백을 지워줌
        System.out.println(id + "번 명언이 등록되었습니다.");
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);

        lastWiseSayingId++;
    }
    public void list() {
        System.out.println("명언 목록을 출력합니다.");
        System.out.println("번호 / 명언 / 작가");
        System.out.println("-".repeat(17));
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d, %s, %s\n", wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthor());
        }
    }
    public void remove(Request request){
        int id = request.getIntParam("id", -1);

        if (id == -1){
            System.out.println("정수 id 값을 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = findById(id); //이동된 값을 여기서 삭제

        if (wiseSaying == null){
            System.out.println(id + "번 명언은 존재하지않습니다.");
            return;
        }
        wiseSayings.remove(wiseSaying);

        System.out.println(id + "번 목록이 삭제되었습니다.");
    }
    public void modify(Request request) {
        int id = request.getIntParam("id", -1);

        if (id == -1){
            System.out.println("정수 id 값을 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = findById(id);
        if (wiseSaying == null){
            System.out.println(id + "번 명언은 존재하지않습니다.");
            return;
        }
        System.out.printf("기존명언 : %s\n", wiseSaying.getContent());
        System.out.printf("명언 :%s", wiseSaying.getContent());
        String content = Container.getScanner().nextLine().trim();

        System.out.printf("기존작가 : %s\n", wiseSaying.getAuthor());
        System.out.printf("작가 :%s", wiseSaying.getAuthor());
        String author = Container.getScanner().nextLine().trim();

        wiseSaying.setAuthor(author);
        wiseSaying.setContent(content);

        System.out.printf(id + "번 명언이 수정되었습니다.");
    }
    private WiseSaying findById (int id){ // private로 닫아놓고 내부적으로 쓰겠다. 즉 wiseSayingController에서만 쓰겠다 라는 뜻.
        for (WiseSaying wiseSaying : wiseSayings){
            if (wiseSaying.getId() == id){
                return wiseSaying; // 순회 후 remove로 이동
            }
        }
        return null;
    }
}
