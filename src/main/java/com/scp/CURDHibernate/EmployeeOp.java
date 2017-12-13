package com.scp.CURDHibernate;

import java.util.List;

public interface EmployeeOp {
	
	public boolean addEmployee(EmployeeInfo name);
	public EmployeeInfo getEmployee(int id);
	
	public boolean deleteEmployee(int id);
	public EmployeeInfo updateEmployee(EmployeeInfo emp );
	
	List<EmployeeInfo> getAllEmployee();
	List<EmployeeInfo> searchStudentWithSomeCriteria(EmployeeInfo emp);
}
