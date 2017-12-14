package com.scp.CURDHibernate;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.scp.CURDHibernate.TestEmployee.SearchParam;

public class EmployeeImplementation implements EmployeeOp {
	private void resourceCleanupActivity(Session session, Transaction trans) {
		// TODO Auto-generated method stub
		if (null != trans)
			trans.commit();
		if (null != session)
			session.close();
	}

	private void checkForNullFields(EmployeeInfo emp) throws MyException {
		// TODO Auto-generated method stub

		if (null == emp || emp.getId() <= 0 || null == emp.getEmpName() || null == emp.getEmpAddress()
				|| emp.getEmpName().trim().length() <= 1 || emp.getEmpAddress().trim().length() <= 1) {
			throw new MyException("Fields cannot be null");
		}
	}

	public boolean addEmployee(EmployeeInfo emp) throws MyException {
		checkForNullFields(emp);
		// TODO Auto-generated method stub
		Session session = HibernateUtil.geSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		try {
			session.save(emp);
		} catch (Exception e) {
			throw new MyException("Error while adding employee into your database");
		} finally {
			resourceCleanupActivity(session, trans);
		}
		return true;

	}

	public EmployeeInfo getEmployee(int id) throws MyException {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.geSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		if (id <= 0) {
			throw new MyException("Id cannot be zero");
		}
		EmployeeInfo emp = null;
		try {
			emp = (EmployeeInfo) session.get(EmployeeInfo.class, id);
		} catch (Exception e) {
			throw new MyException("Error while getting employee");
		} finally {
			resourceCleanupActivity(session, trans);
		}

		return emp;

	}

	public boolean deleteEmployee(int id) throws MyException {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.geSessionFactory().openSession();
		Transaction trans = session.beginTransaction();

		if (id <= 0 || null == getEmployee(id)) {
			throw new MyException("Can't be zero or doesn't exist in the database");
		}
		try {
			EmployeeInfo empp = (EmployeeInfo) session.get(EmployeeInfo.class, id);
			session.delete(empp);
		} catch (Exception e) {
			throw new MyException("Error while deleting record.. check it");
		} finally {
			resourceCleanupActivity(session, trans);
		}
		return true;

	}

	public EmployeeInfo updateEmployee(EmployeeInfo emp) throws MyException {
		checkForNullFields(emp);
		if (null == getEmployee(emp.getId())) {
			throw new MyException("Employee doesn't exist ");
		}

		Session session = HibernateUtil.geSessionFactory().openSession();
		Transaction trans = session.beginTransaction();

		// TODO Auto-generated method stub
		try {
			session.update(emp);
		} catch (Exception e) {
			throw new MyException("Error while updating the record");
		} finally {
			resourceCleanupActivity(session, trans);
		}
		return emp;

	}

	public List<EmployeeInfo> getAllEmployee() throws MyException {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.geSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		List<EmployeeInfo> emplist = null;
		try {
			emplist = session.createQuery("from EmployeeInfo ").list();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw new MyException("Error while adding all employee into database");
		} finally {
			resourceCleanupActivity(session, trans);
		}
		return (List<EmployeeInfo>) emplist;
	}

	public List<EmployeeInfo> searchEmployeeWithSomeCriteria(EmployeeInfo emp, TestEmployee.SearchParam... searchParam)
			throws MyException {

		checkForNullFields(emp);
		List<EmployeeInfo> empList = new ArrayList<EmployeeInfo>();
		Session session = HibernateUtil.geSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		Criteria criteria = session.createCriteria(EmployeeInfo.class);
		for (TestEmployee.SearchParam param : searchParam) {

			if (param == SearchParam.EMPLOYEEID) {
				empList.add((EmployeeInfo) session.get(EmployeeInfo.class, emp.getId()));
				return empList;
			}

			if (param == SearchParam.EMPLOYEENAME) {
				criteria.add(Restrictions.eq("empName", emp.getEmpName()));
			}
			if (param == SearchParam.EMPLOYEEADDRESS) {
				criteria.add(Restrictions.eq("empAddress", emp.getEmpAddress()));
			}
			if (param == SearchParam.AES_ORDER) {
				criteria.addOrder(Order.asc("empName"));
			}
			if (param == SearchParam.DES_ORDER) {
				criteria.addOrder(Order.desc("empName"));
			}
		}
		empList = criteria.list();
		HibernateUtil.resourceCleanupActivity(session, trans);
		return empList;
	}

	/*
	 * public List<EmployeeInfo> searchStudentWithSomeCriteria(EmployeeInfo emp)
	 * throws MyException { // TODO Auto-generated method stub
	 * checkForNullFields(emp); List<EmployeeInfo> empInfo = new
	 * ArrayList<EmployeeInfo>(); Session session =
	 * HibernateUtil.geSessionFactory().openSession(); Transaction trans =
	 * session.beginTransaction();
	 * 
	 * Criteria criteria1 = session.createCriteria(EmployeeInfo.class);
	 * 
	 * List queryList = criteria1.list();
	 * criteria1.add(Restrictions.eq("empName", "Nikita")); queryList =
	 * criteria1.list();
	 * 
	 * return queryList; }
	 */
}
