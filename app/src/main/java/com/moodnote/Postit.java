package com.moodnote;

import java.time.LocalDateTime;

public class Postit {

    private Long id;
    private LocalDateTime createDateTime;
    private String contents;
    private String picture;
    private Long moodId;

    Postit(LocalDateTime createDateTime, String contents, String picture, long moodId) {
        this.createDateTime = createDateTime;
        this.contents = contents;
        this.picture = picture;
        this.moodId = moodId;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Long getMoodId() {
        return moodId;
    }

    public void setMoodId(Long moodId) {
        this.moodId = moodId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
