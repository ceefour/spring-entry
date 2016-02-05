package com.lazaridis.spring;

import java.util.List;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

@RepositoryRestResource(collectionResourceRel = "posts", path = "posts")
public interface PostRepository extends CrudRepository<Post, Long> {
	List<Post> findByTitle(@Param("title") String title);
}
