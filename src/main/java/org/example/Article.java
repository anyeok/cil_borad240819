package org.example;

public class Article {
    private final int id;
    private final String subject;
    private final String content;

    Article(int id, String subject, String content) {
        this.id = id;
        this.subject = subject;
        this.content = content;
    }

    public int getId() {
        return this.id;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getContent() {
        return this.content;
    }
}
