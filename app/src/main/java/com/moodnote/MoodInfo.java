package com.moodnote;

public class MoodInfo {

    private Long id;
    private String color;
    private String icon;
    private String name;

    public MoodInfo(String color, String icon, String name) {
        this.color = color;
        this.icon = icon;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
