package com.lazaridis.spring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Post {

    private @GeneratedValue
    @Id
    Long id;

    @Size(min = 2, max = 50)
    private String title;

    @Size(min = 20, max = 2000)
    private String content;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Post() {
    }

}
