package com.scp.CURDHibernate;

import java.util.List;

public interface EmployeeOp {

	public boolean addEmployee(EmployeeInfo name) throws MyException;

	public EmployeeInfo getEmployee(int id) throws MyException;

	public boolean deleteEmployee(int id) throws MyException;

	public EmployeeInfo updateEmployee(EmployeeInfo emp) throws MyException;

	List<EmployeeInfo> getAllEmployee() throws MyException;

	List<EmployeeInfo> searchEmployeeWithSomeCriteria(EmployeeInfo emp, TestEmployee.SearchParam... searhParam)
			throws MyException;
}
