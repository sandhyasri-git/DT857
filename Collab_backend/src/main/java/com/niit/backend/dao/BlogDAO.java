package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.Blog;

public interface BlogDAO {
	
public boolean save(Blog blog); 
	
	public boolean update(Blog blog);
	
	public boolean delete(Blog blog);
	
	public Blog get(String blogID);
	
	public Blog getName(String name);
	
	public List<Blog> list();
	
	public boolean addComment(Blog blogcomment);
	
	public List<Blog> listComment(int id);
	
	public List<Blog> listOfAllComment();
	

}
