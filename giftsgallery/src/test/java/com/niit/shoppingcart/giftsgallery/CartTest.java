package com.niit.shoppingcart.giftsgallery;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CartTest {

	static AnnotationConfigApplicationContext context;
	public static void main(String[] args) {
		
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		System.out.println("cart");
	}

}
