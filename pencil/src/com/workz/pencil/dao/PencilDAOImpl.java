package com.workz.pencil.dao;

import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.workz.pencil.entity.PencilEntity;

public class PencilDAOImpl implements PencilDAO{

	@Override
	public void savePencilEntity() {
		Configuration configure = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction transaction = null;
		
		try {
			System.out.println("invoked saved");
			configure = new Configuration();
			configure.addAnnotatedClass(PencilEntity.class);

			configure.configure("pencilhibernate.cfg.xml");

			sf = configure.buildSessionFactory();

			session = sf.openSession();
			session.beginTransaction();

			//PencilEntity pencilEntity = new PencilEntity(1, "apsara", 51000.00,"black",47, true, "softeraser");
			PencilEntity pencilEntity1 = new PencilEntity(2, "Staedtler", 250.00,"black", 9, true, "no");
			PencilEntity pencilEntity2 = new PencilEntity(3, "apsara1", 51000.00,"white",47, true, "yes");
			session.save(pencilEntity1);
			session.save(pencilEntity2);
			
			session.getTransaction().commit();
			System.out.println("save is done");

			
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
	public void getPencilEntity() {
		System.out.println("invoked get");
		SessionFactory sf = null;
		Session session = null;

		
		try {
			
			Configuration configure = new Configuration();
			 
			
			configure.configure("pencilhibernate.cfg.xml");

			
			configure.addAnnotatedClass(PencilEntity.class);
			
			
			sf = configure.buildSessionFactory();
			
			
			session = sf.openSession();


			PencilEntity pencilEntity=session.get(PencilEntity.class,1);
			System.out.println(pencilEntity);

			System.out.println("get is done");
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
	public void updatePencilEntity() {
		System.out.println("invoked updated");
		Configuration configure = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction transaction=null;
		try {
			configure = new Configuration();
			configure.addAnnotatedClass(PencilEntity.class);

			configure.configure("pencilhibernate.cfg.xml");

			sf = configure.buildSessionFactory();

			session = sf.openSession();
			

			PencilEntity pencilEntity=session.get(PencilEntity.class,1);
			PencilEntity pencilEntity1=session.get(PencilEntity.class,2);
			System.out.println(pencilEntity);
		
			
			pencilEntity.setPencilBrand("apsara");
			pencilEntity.setPencilColor("black");
			
			
			pencilEntity1.setSofteraser("yes");
			System.out.println(pencilEntity1);
			
			session.beginTransaction();
			session.update(pencilEntity);
			
			
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
	public void deletePencilEntity() {
		System.out.println("invoked deleted");
		Configuration configure = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction transaction=null;
		try {
			configure = new Configuration();
			configure.addAnnotatedClass(PencilEntity.class);

			configure.configure("pencilhibernate.cfg.xml");

			sf = configure.buildSessionFactory();

			session = sf.openSession();
			

			PencilEntity pencilEntity=session.get(PencilEntity.class,1);
			System.out.println(pencilEntity);
			pencilEntity.setPencilColor("silver");
			
			
			session.beginTransaction();
			session.delete(pencilEntity);
			
			
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
