package org.example;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private String actionCode;
    private Map<String, String> params = new HashMap<>();
    public Request(String command){
            String[] commandBits = command.split("\\?",2);
            actionCode = commandBits[0];

            if (commandBits.length == 1)return; // ex)등록 or 목록처럼 길이가 1일 때 return해라.

            String[] paramsBits = commandBits[1].split("&");
            for (String paramStr : paramsBits){
                String[] paramStrBits = paramStr.split("=",2);
                String key = paramStrBits[0];
                String value = paramStrBits[1];

                params.put(key, value);
            }
    }
    public String getActionCode() {
        return actionCode;
    }
    public String getParam(String name){
        return params.get(name);
    }
    // string값으로 return하는 값을 남겨두기 위함

    public int getIntParam (String name, int defaultValue){
         //쓰레기 값을 하나 넣어줌  = defaultValue or int id = -1로 설정 후 return id를 할 수도 있음.
        try {
            return Integer.parseInt(getParam(name));
            // id 값이 없으면 null값을 int형으로 바꿀 수 없음. 기본적으로 int값을 초기화 할 떄 -1을 사용함
        }catch (NumberFormatException e){

        }
        return defaultValue;
    }
}
