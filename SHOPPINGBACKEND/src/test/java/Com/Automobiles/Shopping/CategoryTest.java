package Com.Automobiles.Shopping;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Com.Automobiles.Shopping.dao.CategoryDAO;
import Com.Automobiles.Shopping.dao.ProductDAO;
import Com.Automobiles.Shopping.dao.SupplierDAO;
import Com.Automobiles.Shopping.dao.UserDetailsDAO;
import Com.Automobiles.Shopping.model.Category;
import Com.Automobiles.Shopping.model.Product;
import Com.Automobiles.Shopping.model.Supplier;
import Com.Automobiles.Shopping.model.UserDetails;


public class CategoryTest {
	
	static AnnotationConfigApplicationContext context;
// whether isertion is working or not-- this is normal testing( not Junit testing..
	public CategoryTest() {
	
		
		context= new AnnotationConfigApplicationContext();
		
		context.scan("Com.Automobiles.*");
		context.refresh();
	}
		
		public static void main(String[] args) {
	
			CategoryTest t= new CategoryTest();
			//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			//context.scan("Com.Automobiles.*");
			//context.refresh();
		
		Category category= (Category) context.getBean("category");
		//Category category=new Category();
		category.setId("cgo28");
		category.setName("cgname34");
		category.setDescription("this is test17");
		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		
		//categoryDAO.save(category);
		categoryDAO.saveOrUpdate(category);
		System.out.println("objectes created successfully");
		/*if (categoryDAO.saveOrUpdate(category)==true)
		{
			System.out.println("category created succes");
		}
		else
		{
			System.out.println("not success");
		}*/
		Product p = new Product();
		p.setId("p003");
		p.setDescription("kka");
		p.setName("bba");
		p.setPrice(301);
		ProductDAO pd=(ProductDAO)context.getBean("productDAO");
		pd.saveOrUpdate(p);
		System.out.println("product page");
		
		UserDetails ud= new UserDetails();
		ud.setId("U001");
		ud.setName("user1");
		ud.setPassword("1234");
		ud.setAddress("hyd");
		ud.setContact("123456");
		ud.setMail("user1@yahoo.com");
		UserDetailsDAO userDetailsDAO=(UserDetailsDAO)context.getBean("userDetailsDAO");
		userDetailsDAO.saveOrUpdate(ud);
		Supplier s= new Supplier();
		s.setId("s001");
		s.setName("sup1");
		s.setAddress("xyz");
		SupplierDAO supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		supplierDAO.saveOrUpdate(s);
		
		
	}
}
