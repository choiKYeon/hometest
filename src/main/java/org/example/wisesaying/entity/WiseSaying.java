package org.example;

public class WiseSaying {
// 기본적으로 인스턴스 변수는 private값으로 받아야한다.
    private long id;
    private String content;
    private String author;
    WiseSaying(long id, String content, String author){
        this.id = id;
        this.content = content;
        this.author = author;
    }
    public long getId() {
        return id;
    }
    public String getContent(){
        return content;
    }
    public String getAuthor() {
        return author;
    }
}
