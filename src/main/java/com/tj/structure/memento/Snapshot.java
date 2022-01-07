package com.tj.structure.memento;

public class Snapshot {
    private String text;

    public Snapshot(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public String toString() {
        return "Snapshot{" +
                "text='" + text + '\'' +
                '}';
    }
}