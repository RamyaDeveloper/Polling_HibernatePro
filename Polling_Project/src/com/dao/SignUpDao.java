package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.HibernateUtil;
import com.pojo.Customer;
import com.pojo.User;

public class SignUpDao {

	public void saveCustomer(Customer customer) {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// save the student object
			session.save(customer);
			// commit transaction
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	public  List<Customer> findall() {

		Transaction transaction = null;
		List<Customer> survey = null;
		try {
			// start a transaction
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// get an user object
			
			survey = session.createQuery("from Customer").getResultList();
			
			// commit transaction
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return survey;
	}
}
