package com.niit.shoppingcart.giftsgallery.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Table (name="userinfo")
@Component
public class UserInfo implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
    @NotNull(message="name should not be empty")
	private String name;
	@NotNull(message="enter a valid address")
	private String address;
	@NotNull(message="enter valid number")
	private String phno;
	@NotNull(message="enter a valid mailid ")
	private String emailid;
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	@NotNull(message="password should be 5 to 6 characters")
	private String password;
	@NotNull(message="role should not be empty")
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Transient
	private String confirmpassword;
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	private String enabled;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	
	public String getPassword() { 
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
	
	
	

}
