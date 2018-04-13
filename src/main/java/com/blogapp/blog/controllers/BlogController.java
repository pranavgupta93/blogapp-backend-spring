package com.blogapp.blog.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
	@Autowired
	private BlogService blogservice;
	//@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/allblogs")
	public String getBlogs(){
		return blogservice.getAllBlogs();
	}
	//@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/blogs/{id}")
	public String getSingleBlog(@PathVariable int id){
		return blogservice.getSingleBlog(id);
	}
	//@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/postblog")
	public void postBlog(@RequestBody String blogmodelstring){
		blogservice.postBlog(blogmodelstring);
	}
	//@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/deleteblog/{id}")
	public String deleteBlog(@PathVariable int id){
		blogservice.deleteBlog(id);
		return "deleted";
	}
	//@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.PUT,value="/updateblog/{id}")
	public void updateBlog(@PathVariable int id,@RequestBody String blogmodelstring){
		blogservice.updateBlog(id, blogmodelstring);
	}
}
