package com.example.a5tdx1pobieranie;

import org.json.JSONException;
import org.json.JSONObject;

public class Article {
    String title;
    String description;
    String date;
    String author;
    String content;
    public Article(JSONObject articleJSON) {
        try {
            String title = articleJSON.getString("title");
            String description = articleJSON.getString("description");
            String date = articleJSON.getString("date");
            String author = articleJSON.getString("author");
            String content = articleJSON.getString("content");
            setTitle(title);
            setDescription(description);
            setDate(date);
            setAuthor(author);
            setContent(content);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }


    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
