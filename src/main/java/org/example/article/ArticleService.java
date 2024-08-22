package org.example.article;

import java.util.ArrayList;
import java.util.List;

public class ArticleService {
    List<Article> articleList = new ArrayList<>();

    public int create(String subject, String content) {
        int lastId = 1;

        Article article = new Article(lastId, subject, content);
        articleList.add(article);

        lastId++;

        return article.getId();
    }

    public List<Article> findAll() {
        return articleList;
    }

    public Article _getFindById(int id) {
        for (Article item : articleList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void remove(Article article) {
        articleList.remove(article);
    }

    public void modify(Article article, String modifySubject, String modifyContent) {
        article.setSubject(modifySubject);
        article.setContent(modifyContent);
    }
}

