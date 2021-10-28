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
			
			//transaction by default in hibernate autocommit is false so we use it to begin transaction...
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

		SessionFactory sf = null;
		Session session = null;

		
		try {
			//step 1 starting bootstrap the hibernate framework
			Configuration configure = new Configuration();
			 
			//step 2 to parse hibernate.cfg.xml
			configure.configure("hibernate.cfg.xml");

			//step 3  read metadata from annotations which are associated with entity class
			configure.addAnnotatedClass(MobileEntity.class);
			
			//step 4  configuration use mappings and properties to create sessionFactory like url ,pw,name etc..
			sf = configure.buildSessionFactory();
			
			//step 5 request sessionFactory
			session = sf.openSession();


			MobileEntity mobileEntity=session.get(MobileEntity.class,1);
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

	
	public void updateMobileEntity() {
		System.out.println("invoked updateMobile");
		Configuration configure = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction transaction=null;
		try {
			configure = new Configuration();
			configure.addAnnotatedClass(MobileEntity.class);

			configure.configure("hibernate.cfg.xml");

			sf = configure.buildSessionFactory();

			session = sf.openSession();
			

			MobileEntity mobileEntity=session.get(MobileEntity.class,2);
			System.out.println(mobileEntity);
			mobileEntity.setMobileBrand("mac");
			mobileEntity.setColor("silver");
			
			//session.save(mobileEntity);//save method it will insert query and save the data
			session.beginTransaction();
			session.update(mobileEntity);
			
			//transaction by default in hibernate autocommit is false so we use it to begin transaction...
			session.getTransaction().commit();
			System.out.println("updated");
		} catch (HibernateException e) {
			System.out.println("inside catch");
			session.getTransaction().rollback();
            System.out.println("rollback");
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
	public void deleteMobileEntity() {
		System.out.println("invoked deleteMobile");
		Configuration configure = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction transaction=null;
		try {
			configure = new Configuration();
			configure.addAnnotatedClass(MobileEntity.class);

			configure.configure("hibernate.cfg.xml");

			sf = configure.buildSessionFactory();

			session = sf.openSession();
			

			MobileEntity mobileEntity=session.get(MobileEntity.class,2);
			System.out.println(mobileEntity);
			mobileEntity.setMobileBrand("mac");
			mobileEntity.setColor("silver");
			
			//session.save(mobileEntity);//save method it will insert query and save the data
			session.beginTransaction();
			session.delete(mobileEntity);
			
			//transaction by default in hibernate autocommit is false so we use it to begin transaction...
			session.getTransaction().commit();
			System.out.println("deleted");
		} catch (HibernateException e) {
			System.out.println("inside catch");
			session.getTransaction().rollback();
            System.out.println("rollback");
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

