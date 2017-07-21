package Com.Automobiles.Shopping.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import Com.Automobiles.Shopping.model.Category;

@Repository(value="category")
//@Component
public interface CategoryDAO {
// declare all CURD operations
	
	//public boolean save(Category category);
	//public boolean update(Category category);
	//public boolean delete(Category category);
	
	
	//public Category get(String string);
	//public List<Category> list();
	public List<Category> list();

	public Category get(String id);
	
	public Category getByName(String name);

	public void saveOrUpdate(Category category);

	public void delete(String id);


}
