package org.example;

import java.util.Scanner;

public class Container {// 필요할 때 한번 불러오는 용도로 쓰는 클래스
    private static Scanner sc; // static키워드를 쓰면 값을 공유할 수 있다. static으로 설정하면 같은 메모리 주소를 바라보기 때문이다. 즉, 공유의 목적 및 메모리 효율 증가
    public static void init (){
        sc = new Scanner(System.in); // 최초에 딱 한 번만 설정하면 된다.
    }
    public static void close(){
        sc.close();
    }
    public static Scanner getScanner(){
        return sc;
    }
}
