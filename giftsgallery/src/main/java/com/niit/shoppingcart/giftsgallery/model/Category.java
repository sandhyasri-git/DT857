package com.niit.shoppingcart.giftsgallery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table (name="category")
public class Category
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cat_id;
	@NotNull(message="name should not be empty")
	private String catname;
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	@NotNull(message="enter a valid description")
	private String cat_description;
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	
	public String getCat_description() {
		return cat_description;
	}
	public void setCat_description(String cat_description) {
		this.cat_description = cat_description;
	}
	
	

}
