package com.moodnote;

// 포스트잇 클래스 하나에 몽땅 데이터 넣고
//필요한것만 꺼내 쓰는 방식으로
public class PostItem {
    String contents;

    public PostItem(String contents) {
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
