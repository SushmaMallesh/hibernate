package com.workz.pencil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.workz.pencil.entity.PencilEntity;
import com.workz.pencil.entity.PencilEntity;

public class PencilTester {
	public static void main(String[] args) {
		Configuration configure = new Configuration();
		configure.addAnnotatedClass(PencilEntity.class);
		
		
		configure.configure("hibernate.cfg.xml");
		
		SessionFactory sf=configure.buildSessionFactory();
		
		Session session=sf.openSession();
		session.beginTransaction();
		
		PencilEntity mobileEntity=new PencilEntity(1, "Staedtler", 250.00,"black", 9, true, "no");
		session.save(mobileEntity);
		session.getTransaction().commit();
		
		session.close();
		
		sf.close();
}
}
