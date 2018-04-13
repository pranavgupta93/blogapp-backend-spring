package com.blogapp.blog.controllers;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
@JsonPropertyOrder(
		value={
				"blogid" ,
				"blogtitle",
				"blogbody"
		}
		)
public class BlogModel implements Serializable
{
	
	private String blogtitle;
	private String blogdesc;
	@JsonIgnore
	private String blogcateg;
	private String blogbody;
	private int blogid;
	public BlogModel(){}
	public BlogModel(int blogid,String blogtitle, String blogdesc, String blogcateg,
			String blogbody) {
		super();
		this.blogid=blogid;
		this.blogtitle = blogtitle;
		this.blogdesc = blogdesc;
		this.blogcateg = blogcateg;
		this.blogbody = blogbody;
	}
	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	public String getBlogtitle() {
		return blogtitle;
	}
	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}
	public String getBlogdesc() {
		return blogdesc;
	}
	public void setBlogdesc(String blogdesc) {
		this.blogdesc = blogdesc;
	}
	public String getBlogcateg() {
		return blogcateg;
	}
	public void setBlogcateg(String blogcateg) {
		this.blogcateg = blogcateg;
	}
	public String getBlogbody() {
		return blogbody;
	}
	public void setBlogbody(String blogbody) {
		this.blogbody = blogbody;
	}
}
