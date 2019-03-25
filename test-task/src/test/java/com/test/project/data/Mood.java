package com.test.project.data;

public enum Mood {
    SUPER("Супер", null),
    GOOD("Хорошо", null),
    NORMAL("Нормально", null),
    SATISFIED("Удовлетворительно", null),
    BAD("Плохо", null),
    OTHER("Інше:", "Other");

    private String value;
    private String input;

    Mood(String mood, String input) {
        this.value = mood;
        this.input = input;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
