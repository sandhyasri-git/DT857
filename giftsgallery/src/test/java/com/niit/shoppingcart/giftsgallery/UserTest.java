package com.niit.shoppingcart.giftsgallery;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.giftsgallery.dao.UserDAO;
import com.niit.shoppingcart.giftsgallery.model.UserInfo;


public class UserTest {

	static AnnotationConfigApplicationContext context;
	
	public static void main(String[] args)
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		/*UserDAO userDAO=(UserDAO)context.getBean("userDAO");
		UserInfo user=(UserInfo) context.getBean("userinfo");
		user.setId(1);
		user.setName("bhu");
		user.setAddress("niit");
		user.setPassword("1234");
		user.setEmail("bhumi12@gmail.com");
		user.setPhno("1234567");
		user.setEnabled("true");
        userDAO.saveOrUpdate(user);
*/
}
}
