package com.test.project.data;

public class FormDataModel {
    private String email;
    private String name;
    private Sex sex;
    private Mood mood;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return null == sex ? null : sex.getValue();
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

}
