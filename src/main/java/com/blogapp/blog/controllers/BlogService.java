package com.blogapp.blog.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BlogService {
	private List<BlogModel> blogs=new ArrayList<BlogModel>();
	public String getAllBlogs(){
		return Jsonutil.javatojson(blogs);
	}
	public String getSingleBlog(int id){
		for(BlogModel b:blogs){
			if(b.getBlogid()==id)
			{
				return Jsonutil.javatojson(b);
			}
		}
		
		//return blogs.stream().filter(b->b.getBlogid()==id).findFirst().get();
		return null;
	}
	public void postBlog(String blogmodelstring) {
		blogs.add(Jsonutil.jsontojava(blogmodelstring, BlogModel.class));
		
	}
	public void deleteBlog(int id) {
		for (BlogModel b:blogs){
			if(id==b.getBlogid())
			{
				blogs.remove(b);
				break;
			}
		}
	}
	public void updateBlog(int id,String blogmodelstring){
		for (BlogModel b:blogs){
			if(id==b.getBlogid())
			{
				blogs.remove(b);
				blogs.add(Jsonutil.jsontojava(blogmodelstring, BlogModel.class));
			}
		}
	}
}
