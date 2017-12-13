package com.scp.CURDHibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class EmployeeImplementation implements EmployeeOp {
	
	public boolean addEmployee(EmployeeInfo emp) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.geSessionFactory().openSession();	
		Transaction trans =session.beginTransaction();
		session.save(emp);
		trans.commit();
		session.close();
		return true;
	
	}

	public EmployeeInfo getEmployee(int id) {
			// TODO Auto-generated method stub
		Session session = HibernateUtil.geSessionFactory().openSession();
		EmployeeInfo e = (EmployeeInfo) session.get(EmployeeInfo.class, id);
		session.close();
		return (e) ;
		//return null;
		
	}

		public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
			Session session = HibernateUtil.geSessionFactory().openSession();
			Transaction trans =session.beginTransaction();

		EmployeeInfo empp= (EmployeeInfo) session.get(EmployeeInfo.class, id);
		session.delete(empp);
		trans.commit();
		session.close();
		return true;
		
	}

	public EmployeeInfo updateEmployee(EmployeeInfo emp) {
		Session session = HibernateUtil.geSessionFactory().openSession();
		Transaction trans =session.beginTransaction();
		// TODO Auto-generated method stub
		EmployeeInfo e2=(EmployeeInfo) session.get(EmployeeInfo.class, emp.getId());
		e2.setEmpName("Varsha");
		session.update(e2);
		trans.commit();
		session.close();
		return e2;
		
	}

	public List<EmployeeInfo> getAllEmployee() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.geSessionFactory().openSession();
		Transaction trans =session.beginTransaction();
		Query query =session.createQuery("from EmployeeInfo ");
		List queryList = query.list();
		trans.commit();
		session.close();
		return (List<EmployeeInfo>) queryList;
	}

	public List<EmployeeInfo> searchStudentWithSomeCriteria(EmployeeInfo emp) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.geSessionFactory().openSession();
		Transaction trans =session.beginTransaction();
		Criteria criteria1 = session.createCriteria(EmployeeInfo.class);
		criteria1.add(Restrictions.eq("empName", "Nikita"));
		List queryList = criteria1.list();
		trans.commit();
		session.close();
		return queryList;
 	}
}
