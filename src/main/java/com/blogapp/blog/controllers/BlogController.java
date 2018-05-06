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
	@CrossOrigin(origins = "*")
	@RequestMapping("/allblogs")
	public List<BlogModel> getBlogs(){
		System.out.println("getting all blogs");
		return blogservice.getAllBlogs();
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/blogs/{id}")
	public BlogModel getSingleBlog(@PathVariable int id){
		return blogservice.getSingleBlog(id);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(method=RequestMethod.POST,value="/postblog")
	public BlogModel postBlog(@RequestBody BlogModel blogmodelobj){
		System.out.println("post blog controller");
		return blogservice.postBlog(blogmodelobj);
		
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(method=RequestMethod.POST,value="/deleteblog/{id}")
	public void deleteBlog(@PathVariable int id){
		System.out.println("id to be deleted "+id);
		blogservice.deleteBlog(id);
		
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(method=RequestMethod.PUT,value="/updateblog/{id}")
	public void updateBlog(@PathVariable int id,@RequestBody BlogModel blogmodelobj){
		System.out.println("update blog controller");
		blogservice.updateBlog(id, blogmodelobj);
	}
}
