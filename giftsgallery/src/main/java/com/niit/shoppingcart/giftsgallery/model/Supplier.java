package com.niit.shoppingcart.giftsgallery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class Supplier {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int sup_id;
		@NotNull(message="name should not be empty")
		private String sup_name;
		@NotNull(message="enter a valid description")
		private String sup_description;
		public int getSup_id() {
			return sup_id;
		}
		public void setSup_id(int sup_id) {
			this.sup_id = sup_id;
		}
		public String getSup_name() {
			return sup_name;
		}
		public void setSup_name(String sup_name) {
			this.sup_name = sup_name;
		}
		public String getSup_description() {
			return sup_description;
		}
		public void setSup_description(String sup_description) {
			this.sup_description = sup_description;
		}
		
	
	
	
	
	
	

}
