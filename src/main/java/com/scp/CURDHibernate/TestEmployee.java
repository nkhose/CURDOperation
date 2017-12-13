package com.scp.CURDHibernate;

public class TestEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeInfo emp = new EmployeeInfo(1, "Nikita", "pune", 120000);
		EmployeeImplementation e1 = new EmployeeImplementation();
		//System.out.println("Data is:=" +e1.addEmployee(emp));
		System.out.println("Get Data:="+e1.getEmployee(10));
		
		//System.out.println("Delete:="+e1.deleteEmployee(3));
		
		System.out.println("Update:="+e1.updateEmployee(emp));
		System.out.println("List:=" +e1.getAllEmployee());
		
		System.out.println("Criteria:="+e1.searchStudentWithSomeCriteria(emp));
		
		
	}

}
