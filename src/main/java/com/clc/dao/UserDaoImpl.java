package com.clc.dao;

import java.util.List;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clc.model.UserModel;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public int addUser(UserModel userModel) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(userModel);
		session.getTransaction().commit();
		session.close();
		
		return 1;
	}
	
	@Override
	public int updateUser(UserModel userModel) {
		Session session = this.sessionFactory.openSession();
		session.update(userModel);
		return 1;
	}
	
	@Override
	public List<UserModel> listUsers() {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		List<UserModel> usersList = session.createQuery("from com.clc.model.UserModel").list();
		for(UserModel u: usersList) {
			System.out.println("Persons List: "+u);
		}
		session.close();
		return usersList;
	}
	
	@Override
	public UserModel getUserById(int id) {
		Session session = this.sessionFactory.openSession();
		UserModel u = (UserModel) session.load(UserModel.class, id);
		System.out.println("User retrieved successfully " + u);
		session.close();
		return u;
	}

	@Override
	public int removeUser(int id) {
		Session session = this.sessionFactory.openSession();
		UserModel u = (UserModel) session.load(UserModel.class, id);
		if(null !=u) {
			session.delete(u);
		}
		session.close();
		return 1;
	}
	
	@Override
	public int loginUser(String username, String password) {
		Session session = this.sessionFactory.openSession();
		String hql = "FROM com.clc.model.UserModel u where u.username =:username AND u.password =:password";
		Transaction tx = session.beginTransaction();
		Query qry = (Query) session.createQuery(hql);
		qry.setParameter("username", username);
		qry.setParameter("password", password);
		
		UserModel u = (UserModel) qry.getSingleResult();
		tx.commit();
//		List<UserModel> list=qry.list();
		session.close();
		/*
		 * if(!list.isEmpty()) { return 1; } else { return 0; }
		 */
		return 1;
		
	}

}
