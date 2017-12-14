package com.scp.CURDHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory sessionfactory = null;

	static SessionFactory geSessionFactory() throws MyException {
		// TODO Auto-generated method stub
		try {
			if (sessionfactory == null) {
				sessionfactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			}
		} catch (Exception e) {
			throw new MyException("Check yours hibernate.cfg.xml file");
		}

		return sessionfactory;
	}

	public static void resourceCleanupActivity(Session session, Transaction trans) {
		// TODO Auto-generated method stub
		if (null != trans)
			trans.commit();
		if (null != session)
			session.close();
	}

}
