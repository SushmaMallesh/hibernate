package com.workz.mobile;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.workz.mobile.entity.MobileEntity;

public class MobileTester {
public static void main(String[] args) {
	Configuration configure = new Configuration();
	configure.addAnnotatedClass(MobileEntity.class);
	
	
	configure.configure("hibernate.cfg.xml");
	
	SessionFactory sf=configure.buildSessionFactory();
	
	Session session=sf.openSession();
	session.beginTransaction();
	
	MobileEntity mobileEntity=new MobileEntity(1, "mi", 25000.00, "25gb", "black", 45, true, "andorid");
	session.save(mobileEntity);
	session.getTransaction().commit();
	
	session.close();
	
	sf.close();
}
}
