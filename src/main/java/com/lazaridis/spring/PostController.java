package com.lazaridis.spring;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostController {

	@Autowired
	private PostRepository 	postRepository; 

	@RequestMapping(value = "/post-create", method = RequestMethod.GET)
	public String createPost(Post post) {
		return "post-create";
	}
        
	@RequestMapping(value = "/post-create", method = RequestMethod.POST)
	public String addNewPost(@Valid Post post, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "post-create";
		}
		postRepository.save(new Post(post.getTitle(), post.getContent()));
		model.addAttribute("posts", postRepository.findAll());
		return "redirect:post-list";
	}
	
	@RequestMapping(value = "/post-list", method = RequestMethod.GET)
	public String showAllPosts(Model model) {
		model.addAttribute("posts", postRepository.findAll());
		return "post-list";
	}
}