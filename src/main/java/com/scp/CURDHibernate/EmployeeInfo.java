package com.scp.CURDHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeInfo")
public class EmployeeInfo {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name = "EMP_NAME")
	String empName;

	@Column(name = "EMP_ADDRESS")
	String empAddress;

	@Column(name = "EMP_SALARY")
	double salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeInfo [id=" + id + ", empName=" + empName + ", empAddress=" + empAddress + ", salary=" + salary
				+ "]";
	}

	public EmployeeInfo(int id, String empName, String empAddress, double salary) {
		super();
		this.id = id;
		this.empName = empName;
		this.empAddress = empAddress;
		this.salary = salary;
	}

	public EmployeeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
