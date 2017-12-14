package com.scp.CURDHibernate;

public class TestEmployee {

	public static void main(String[] args) throws MyException {
		// TODO Auto-generated method stub
		EmployeeInfo emp = new EmployeeInfo(1, "Nikita", "pune", 120000);
		EmployeeImplementation e1 = new EmployeeImplementation();

		// System.out.println("Data is:=" +e1.addEmployee(emp));

		System.out.println("Get Data:=" + e1.getEmployee(6));

		// System.out.println("Delete:="+e1.deleteEmployee(5));

		System.out.println("Update:=" + e1.updateEmployee(emp));

		System.out.println("List:=" + e1.getAllEmployee());

		System.out.println("Criteria:=" + e1.searchEmployeeWithSomeCriteria(emp));

		System.out.println("Search Criteria on Employee ID:= " + e1.searchEmployeeWithSomeCriteria(
				new EmployeeInfo(6, "Nikita", "Pune", 120000), TestEmployee.SearchParam.EMPLOYEEID));

		System.out.println("Search Criteria on Employee Name:= " + e1.searchEmployeeWithSomeCriteria(
				new EmployeeInfo(6, "Rajshri", "Pune", 120000), TestEmployee.SearchParam.EMPLOYEENAME));

		System.out.println("Search Criteria on Employee Address:= " + e1.searchEmployeeWithSomeCriteria(
				new EmployeeInfo(6, "Nik", "Pune", 120000), TestEmployee.SearchParam.EMPLOYEEADDRESS));

		System.out.println("Search Criteria for Ascending Order:= " + e1.searchEmployeeWithSomeCriteria(
				new EmployeeInfo(6, "Nikita", "Pune", 120000), TestEmployee.SearchParam.AES_ORDER));

		System.out.println("Search Criteria for Desending Order:= " + e1.searchEmployeeWithSomeCriteria(
				new EmployeeInfo(6, "Nikita", "Pune", 120000), TestEmployee.SearchParam.DES_ORDER));
	}

	enum SearchParam {
		EMPLOYEEID, 
		EMPLOYEENAME, 
		EMPLOYEEADDRESS, 
		AES_ORDER, 
		DES_ORDER, 
		ALL;

	}
}
