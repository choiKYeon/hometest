package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<WiseSaying> wisesayings = new ArrayList<>();
        System.out.println("== 명언 앱 ==");
        long id = 1;

        while (true) {
            System.out.print("명령)");
            String answer = sc.nextLine().trim();
            if (answer.equals("종료")) {
                break;
            } else if (answer.equals("등록")) {
                System.out.print("작가 :");
                String author = sc.nextLine().trim();
                System.out.print("명언 :");
                String content = sc.nextLine().trim();
                System.out.println(id + "번 명언이 등록되었습니다.");
                WiseSaying wiseSaying = new WiseSaying(id, author, content);
                wisesayings.add(wiseSaying);

                id++;
            } else if (answer.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------");
                for (int i = wisesayings.size() - 1; i >= 0; i--) {
                    WiseSaying wiseSaying = wisesayings.get(i);
                    System.out.printf("%d, %s, %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
                }
            } else if (answer.startsWith("삭제")) {
                Map<String, String> params = new HashMap<>();
                String[] answerarray = answer.split("\\?", 2);
                String A = answerarray[0];
                String[] B = answerarray[1].split("=", 2);
                // 삭제?
                // id
                // 1
                String key = B[0];
                String value = B[1];
                params.put(key, value);
                int v = Integer.parseInt(params.get(key));
                try {
                    wisesayings.remove(v- 1);
                    System.out.println(v + "번 명언이 삭제되었습니다.");
                } catch (Exception e) {
                    System.out.println(v + "번 명언은 존재하지 않습니다.");
                }
            }
        }
        sc.close();
    }
}