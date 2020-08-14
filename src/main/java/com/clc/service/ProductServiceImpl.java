package com.clc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.clc.dao.ProductDao;
import com.clc.model.ProductModel;

public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	
	@Override
	public int saveProduct(ProductModel productModel) {
		this.productDao.saveProduct(productModel);
		return 1;
	}

	@Override
	public int updateProduct(ProductModel productModel) {
		this.productDao.updateProduct(productModel);
		return 1;
	}

	@Override
	public List<ProductModel> listProducts() {
		return this.productDao.listProducts();
	}

	@Override
	public ProductModel getProductById(int id) {
		return this.productDao.getProductById(id);
	}

	@Override
	public int deleteProduct(int id) {
		this.productDao.removeProduct(id);
		return 1;
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

}
