package com.solvd.enums;

public enum TypeOfEmail {

    GMAIL,
    YANDEX,
    EMAIL;

    private String title;

    @Override
    public String toString() {
        return "TypeOfEmail{" +
                "title='" + title + '\'' +
                '}';
    }


    public void setTitle(String title) {
        this.title = title;
    }


    void TypeOfEmail(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
