package com.clc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clc.model.ProductModel;
@Repository
public class ProductDoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public int saveProduct(ProductModel productModel) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(productModel);
		session.getTransaction().commit();
		session.close();
		return 1;
	}

	@Override
	public int updateProduct(ProductModel productModel) {
		Session session = this.sessionFactory.openSession();
		session.saveOrUpdate(productModel);
		session.close();
		return 1;
	}

	@Override
	public List<ProductModel> listProducts() {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		List<ProductModel> products = session.createQuery("from com.clc.model.ProductModel").list();
		session.close();
		return products;
	}
	
	@Override
	public ProductModel getProductById(int id) {
		Session session = this.sessionFactory.openSession();
		ProductModel productModel = (ProductModel) session.load(ProductModel.class, id);
		
		session.close();
		return productModel;
	}

	@Override
	public int removeProduct(int id) {
		Session session = this.sessionFactory.openSession();
		ProductModel productModel = (ProductModel) session.load(ProductModel.class, id);
		if(null != productModel) {
			session.delete(productModel);
		}
		return 1;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
