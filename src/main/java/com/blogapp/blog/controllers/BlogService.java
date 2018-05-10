package com.blogapp.blog.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Service;
import com.mysql.jdbc.PreparedStatement;


@Service
public class BlogService {
	private List<BlogModel> blogs=new ArrayList<BlogModel>();
	public List<BlogModel> getAllBlogs() throws SQLException{
		List<BlogModel> blogs1=new ArrayList<BlogModel>();
		Connection con=DbConnect.createConnection();
		PreparedStatement pst=(PreparedStatement)con.prepareStatement("select * from blogs");
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			BlogModel obj=new BlogModel();
			obj.setBlogid(rs.getInt(1));
			obj.setBlogtitle(rs.getString(2));
			obj.setBlogbody(rs.getString(3));
			obj.setBlogdesc(rs.getString(4));
			obj.setBlogcateg(rs.getString(5));
			blogs1.add(obj);
		}
		con.close();
		return blogs1;
	}
	public BlogModel getSingleBlog(int id) throws SQLException{
//		for(BlogModel b:blogs){
//			if(b.getBlogid()==id)
//			{
//				return b;
//			}
//		}
		Connection con=DbConnect.createConnection();
		PreparedStatement pst=(PreparedStatement)con.prepareStatement("select * from blogs where id=?");
		pst.setInt(1, id);
		ResultSet rs=pst.executeQuery();

		BlogModel obj=new BlogModel();
		while(rs.next()) {
		obj.setBlogid(rs.getInt(1));
		obj.setBlogtitle(rs.getString(2));
		obj.setBlogbody(rs.getString(3));
		obj.setBlogdesc(rs.getString(4));
		obj.setBlogcateg(rs.getString(5));
		}
		con.close();
		System.out.println(obj);
		//return blogs.stream().filter(b->b.getBlogid()==id).findFirst().get();
		return obj;
	}
	public BlogModel postBlog(BlogModel blogmodelobj) throws SQLException {
		//blogs.add(Jsonutil.jsontojava(blogmodelstring, BlogModel.class));
		System.out.println(blogmodelobj.toString());
		int id=(int) Math.floor((Math.random()*100));
		blogmodelobj.setBlogid(id);
		//blogs.add(blogmodelobj);
		Connection con=DbConnect.createConnection();
		PreparedStatement pst=(PreparedStatement)con.prepareStatement("insert into blogs values(?,?,?,?,?)");
		pst.setInt(1, blogmodelobj.getBlogid());
		pst.setString(2, blogmodelobj.getBlogtitle());
		pst.setString(3, blogmodelobj.getBlogbody());
		pst.setString(4, blogmodelobj.getBlogdesc());
		pst.setString(5, blogmodelobj.getBlogcateg());
		pst.execute();
		con.close();
		return blogmodelobj;
	}
	public void deleteBlog(int id) throws SQLException {
		System.out.println("in delete blog service");
//		for (BlogModel b:blogs){
//			if(id==b.getBlogid())
//			{
//				blogs.remove(b);
//				break;
//			}
//		}
		Connection con=DbConnect.createConnection();
		PreparedStatement pst=(PreparedStatement)con.prepareStatement("delete from blogs where id=?");
		pst.setInt(1, id);
		pst.executeUpdate();
		con.close();
		
	}
	public void updateBlog(int id,BlogModel blogmodelobj) throws SQLException{
		System.out.println("update blog service");
//		for (BlogModel b:blogs){
//			if(id==b.getBlogid())
//			{
//				System.out.println(blogmodelobj.toString());
//			
//				blogs.remove(b);
//				//blogs.add(Jsonutil.jsontojava(blogmodelobj, BlogModel.class));
//				blogs.add(blogmodelobj);
//			}
//		}
		Connection con=DbConnect.createConnection();
		PreparedStatement pst=(PreparedStatement)con.prepareStatement("delete from blogs where id=?");
		pst.setInt(1, id);
		pst.executeUpdate();
		pst=(PreparedStatement)con.prepareStatement("insert into blogs values(?,?,?,?,?)");
		pst.setInt(1, blogmodelobj.getBlogid());
		pst.setString(2, blogmodelobj.getBlogtitle());
		pst.setString(3, blogmodelobj.getBlogbody());
		pst.setString(4, blogmodelobj.getBlogdesc());
		pst.setString(5, blogmodelobj.getBlogcateg());
		pst.execute();
		con.close();
		
	}
}
