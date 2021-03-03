package com.moodnote;

public class MoodItem {
    int moodIcon;
    String contents;
    String mood;

    public MoodItem(int moodIcon, String contents, String mood) {
        this.moodIcon = moodIcon;
        this.contents = contents;
        this.mood = mood;
    }

    public int getMoodIcon() {
        return moodIcon;
    }

    public void setMoodIcon(int moodIcon) {
        this.moodIcon = moodIcon;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
