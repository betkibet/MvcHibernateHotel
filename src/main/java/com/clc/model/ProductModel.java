package com.clc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="products")
public class ProductModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pid")
	private int pId;
	@Column(name="product_name")
	private String productName;
	@Column(name="product_category")
	private String productCategory;
	@Column(name="quantity")
	private int quantity;
	@Column(name="unit_price")
	private int unitPrice;
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
		
	
}
