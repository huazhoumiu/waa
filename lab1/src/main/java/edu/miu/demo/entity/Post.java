package edu.miu.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private long id;
    private String title;
    private String content;
    private String author;

    public Post(long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
}
