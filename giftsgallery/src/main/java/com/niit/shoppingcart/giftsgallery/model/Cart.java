package com.niit.shoppingcart.giftsgallery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart {

	/*@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int quantity;
	private int price;
	@ManyToOne
	@JoinColumn(name = "user_Id", insertable = false, updatable = false)
	private UserInfo cartuser;
	
	public UserInfo getCartuser() {
		return cartuser;
	}
	public void setCartuser(UserInfo cartuser) {
		this.cartuser = cartuser;
	}
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public Product getCartproduct() {
		return cartproduct;
	}
	public void setCartproduct(Product cartproduct) {
		this.cartproduct = cartproduct;
	}
	public int getProd_Id() {
		return prod_Id;
	}
	public void setProd_Id(int prod_Id) {
		this.prod_Id = prod_Id;
	}
	private int user_Id;
	
	@ManyToOne
	@JoinColumn(name = "prod_Id", insertable = false, updatable = false)
	private Product cartproduct;
	
	private int prod_Id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
*/
	
	@Id
	@GeneratedValue
	@Column(name = "cartid") 
	private int cartid;
	
	@Column(name = "user")
	private String user;
	
	@Column(name = "prodid")
	private int prodid;
	 
	@Column(name = "prodname")
	private String prodname;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "totalprice")
	private int totalprice;

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	
	
	
}


