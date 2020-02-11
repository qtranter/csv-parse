package com.company;

public class AuthorParser {
    private String author_name;
    private String author_email;
    private String author_url;

    protected void setName(String name) {
        this.author_name = name;
    }

    protected void setEmail(String email) {
        this.author_email = email;
    }

    protected void setUrl(String url) {
        this.author_url = url;
    }

    protected String getName() {
        return author_name;
    }

    protected String getEmail() {
        return author_email;
    }

    protected String getURL() {
        return author_url;
    }
}
