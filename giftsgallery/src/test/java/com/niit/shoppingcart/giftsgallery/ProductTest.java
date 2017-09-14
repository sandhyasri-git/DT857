package com.niit.shoppingcart.giftsgallery;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.giftsgallery.dao.CategoryDAO;
import com.niit.shoppingcart.giftsgallery.dao.ProductDAO;
import com.niit.shoppingcart.giftsgallery.model.Category;
import com.niit.shoppingcart.giftsgallery.model.Product;
import com.niit.shoppingcart.giftsgallery.model.Supplier;

public class ProductTest {

	static AnnotationConfigApplicationContext context;
	
	public static void main(String[] args)
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		Product product=(Product) context.getBean("product");
		Category cat=new Category();
		cat.setCat_description("Mobiles");
		cat.setCat_id(1);
		Supplier sup=new Supplier();
		sup.setSup_id(1);
		cat.setCatname("Mobiles");
		//product.setCategory(cat);
		//product.setProd_id(1);
		product.setProd_name("Phones");
		product.setProd_price(1);
		product.setQuantity(1);
		//product.setSupp_Id(1);
		product.setCat_Id(1);;
		//product.setSupplier(sup);
		ProductDAO productDAO=(ProductDAO)context.getBean("productDAO");
		productDAO.saveOrUpdate(product);
		System.out.println("product created test");

	}

}
