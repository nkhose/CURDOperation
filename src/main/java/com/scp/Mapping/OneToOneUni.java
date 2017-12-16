package com.scp.Mapping;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;;

@Entity
@Table(name = "EMPTABLE")
class Emp {
	
	private int empId;
	private String empName;

	private Address address;

	@Id
	@GeneratedValue
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "EMP_ADDRESS_ID")
	//@JoinColumn(name="EmpDetail")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + ", address=" + address + "]";
	}

	public Emp(int empId, String empName, Address address) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.address = address;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

}

@Entity
@Table(name = "ADDRESSTABLE")
class Address {

	private int addressId;
	private String city;
	private String state;

	@Id
	@GeneratedValue
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", state=" + state + "]";
	}

	public Address(int addressId, String city, String state) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.state = state;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

}

public class OneToOneUni {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		Address ad1 = new Address(1, "Pune", "MH");
	//	session.save(ad1);
		/*Address ad2 = new Address(2, "A.nagar", "MH");
		session.save(ad2);*/
		
		Emp emp1 = new Emp(10, "Nikita", ad1);
	//	Emp emp2 = new Emp(11, "Nik", ad2);

		session.save(emp1);
	//	session.save(emp2);

		trans.commit();
		session.close();

	}
}
