package com.workz.mobile.dao;

import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.workz.mobile.entity.MobileEntity;

public class MobileDAOImpl implements MobileDAO {

	@Override
	public void saveMobileEntity() {
		Configuration configure = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction transaction = null;
		try {
			configure = new Configuration();
			configure.addAnnotatedClass(MobileEntity.class);

			configure.configure("hibernate.cfg.xml");

			sf = configure.buildSessionFactory();

			session = sf.openSession();
			session.beginTransaction();

			MobileEntity mobileEntity = new MobileEntity(2, "apple", 50000.00, "25gb", "white", 47, true, "apple");
			session.save(mobileEntity);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("inside catch");

		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
			if (sf != null) {
				sf.close();
				System.out.println("sf is closed");

			}else {
				System.out.println("sf is not closed");
			}
		}
	}

	@Override
	public void getMobileEntity() {
		Configuration configure = null;
		SessionFactory sf = null;
		Session session = null;
		
	
		try {
			configure = new Configuration();
			configure.addAnnotatedClass(MobileEntity.class);

			configure.configure("hibernate.cfg.xml");

			sf = configure.buildSessionFactory();

			session = sf.openSession();
			

			MobileEntity mobileEntity=session.get(MobileEntity.class, 2);
			System.out.println(mobileEntity);

			
		} catch (HibernateException e) {
			System.out.println("inside catch");

		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
				
			}
			if (sf != null) {
				sf.close();
				System.out.println("sf is closed");

			}else {
				System.out.println("sf is not closed");
			}
		}
	}

}