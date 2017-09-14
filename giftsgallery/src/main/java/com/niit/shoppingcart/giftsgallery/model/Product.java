package com.niit.shoppingcart.giftsgallery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table (name="product")
public class Product
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int prod_id;
	private String prod_name;
	@Min(1)
	private int prod_price;
	@Min(1)
	private int quantity;
	@Transient
	private MultipartFile image;
	
	@ManyToOne
	@JoinColumn(name = "cat_Id", insertable = false, updatable = false)

	private Category category;
	private int cat_Id;
	
	@ManyToOne
	@JoinColumn(name = "supp_Id", insertable = false, updatable = false)
	private Supplier supplier;

	private int supp_Id;
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	public int getCat_Id() {
		return cat_Id;
	}
	public void setCat_Id(int cat_Id) {
		this.cat_Id = cat_Id;
	}
	public int getSupp_Id() {
		return supp_Id;
	}
	public void setSupp_Id(int supp_Id) {
		this.supp_Id = supp_Id;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
