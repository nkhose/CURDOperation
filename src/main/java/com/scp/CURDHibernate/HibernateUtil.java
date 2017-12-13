package com.scp.CURDHibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory sessionfactory = null;

	 static SessionFactory geSessionFactory() {
		// TODO Auto-generated method stub
		if (sessionfactory == null) {
			sessionfactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return sessionfactory;
	}

}
