package org.example;

public class WiseSaying {
    private long id;
    private String content;
    private String author;
    public WiseSaying(long id, String author, String content){
        this.id = id;
        this.content = content;
        this.author = author;
    }
    public long getId() {
        return id;
    }
    public String getAuthor() {
        return author;
    }
    public String getContent() {
        return content;
    }
}
