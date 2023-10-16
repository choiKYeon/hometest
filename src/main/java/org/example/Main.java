package org.example;

import java.util.*;
//실행 관련 로직
public class Main {
    public static void main(String[] args) {
        Container.init();
        new App().run();
        Container.close();
    }
}