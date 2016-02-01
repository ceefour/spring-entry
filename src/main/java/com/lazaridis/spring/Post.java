package com.lazaridis.spring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Post {

	private @GeneratedValue @Id Long id;
	private final String title;
	private final String content;
}
