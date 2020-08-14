package com.clc.dao;

import java.util.List;

import com.clc.model.ProductModel;

public interface ProductDao {
	public int saveProduct(ProductModel productModel);
	public int updateProduct(ProductModel productModel);
	public List<ProductModel> listProducts();
	public ProductModel getProductById(int id); 
	public int removeProduct(int id);
	

}
