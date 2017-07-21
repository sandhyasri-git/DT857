package com.niit.backend.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.niit.backend.dao.BlogDAO;
import com.niit.backend.model.Blog;

@RestController
@EnableWebMvc
public class BlogController {
	
	@Autowired
	private BlogDAO blogDAO;
	
	@Autowired
	private Blog blog;

	// To get All users
	
	@RequestMapping(value="/blog/",method=RequestMethod.POST,headers="Accept=application/json")
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog,HttpSession httpSession){
	
		blog.setCreationdate(new Date(System.currentTimeMillis()));

		
		//user= (User) httpSession.getAttribute("loggedInUserID");
		
		String loggeddInUserId = (String) httpSession.getAttribute("loggedInUserID");
		blog.setUser_id(loggeddInUserId);     //user name ---id
		blog.setStatus('P');  //published
		
		if(blogDAO.save(blog)==true){
			blog.setErrorcode("200");
			blog.setErrormessage("blog posted..successfully");			
		}else{
		System.out.println("blog cannot be posted");
		blog.setErrorcode("400");
		blog.setErrormessage("blog cannot be posted");
		return new ResponseEntity<Blog>(blog,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
			}
	@SuppressWarnings("null")
	@RequestMapping(value="/blog/{id}",method=RequestMethod.GET)
	public List<Blog> getBlogs(@PathVariable("id") String id) {
	System.out.println("get blog method");
	Blog blog=blogDAO.get(id);
		List<Blog> blogs =   blogDAO.list();
		
		if(blogs==null)
			
		{
			blog = new Blog();
			
			blog.setErrorcode("404");
			blog.setErrormessage("No blog s are available");
			blogs.add(blog);
			
		}
		return blogs;
		
		
		
	}


}
