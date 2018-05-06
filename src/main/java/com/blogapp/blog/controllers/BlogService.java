package com.blogapp.blog.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BlogService {
	private List<BlogModel> blogs=new ArrayList<BlogModel>();
	public List<BlogModel> getAllBlogs(){
		return blogs;
	}
	public BlogModel getSingleBlog(int id){
		for(BlogModel b:blogs){
			if(b.getBlogid()==id)
			{
				return b;
			}
		}
		
		//return blogs.stream().filter(b->b.getBlogid()==id).findFirst().get();
		return null;
	}
	public BlogModel postBlog(BlogModel blogmodelobj) {
		//blogs.add(Jsonutil.jsontojava(blogmodelstring, BlogModel.class));
		System.out.println(blogmodelobj.toString());
		int id=(int) Math.floor((Math.random()*100));
		blogmodelobj.setBlogid(id);
		blogs.add(blogmodelobj);
		return blogmodelobj;
	}
	public void deleteBlog(int id) {
		System.out.println("in delete blog service");
		for (BlogModel b:blogs){
			if(id==b.getBlogid())
			{
				blogs.remove(b);
				break;
			}
		}
	}
	public void updateBlog(int id,BlogModel blogmodelobj){
		System.out.println("update blog service");
		for (BlogModel b:blogs){
			if(id==b.getBlogid())
			{
				System.out.println(blogmodelobj.toString());
			
				blogs.remove(b);
				//blogs.add(Jsonutil.jsontojava(blogmodelobj, BlogModel.class));
				blogs.add(blogmodelobj);
			}
		}
	}
}
