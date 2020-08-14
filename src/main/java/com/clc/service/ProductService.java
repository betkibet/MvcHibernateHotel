package com.clc.service;

import java.util.List;

import com.clc.model.ProductModel;

public interface ProductService {
	public int saveProduct(ProductModel productModel);
	public int updateProduct(ProductModel productModel);
	public List<ProductModel> listProducts();
	public ProductModel getProductById(int id);
	public int deleteProduct(int id);
}
