package com.scp.Mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;;

@Entity
@Table(name = "STUDENT")
class Student {

	@Id
	@GeneratedValue
	@Column
	private int studentId;
	private String studentName;

	@OneToOne
	@PrimaryKeyJoinColumn(name = "Student_Address")
	private Address address;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int studentId, String studentName, Address studentAddress) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.address = studentAddress;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Address getStudentAddress() {
		return address;
	}

	public void setStudentAddress(Address studentAddress) {
		this.address = studentAddress;
	}

}

@Entity
@Table(name = "ADDRESS")
class Address {

	@Id
	@GeneratedValue
	@Column
	private int addressId;
	private String city;
	private String state;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int addressId, String city, String state) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.state = state;
	}

	@Id
	@GeneratedValue
	@Column
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

}

public class PKJCOneToOneUni {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();

		Address ad1 = new Address(1, "Pune", "Maharashtra");
		Address ad2 = new Address(2, "A.nagar", "Maharashtra");
		
		Student st1 = new Student(10, "Nikita", ad1);
		Student st2 = new Student(11, "Varsha", ad2);

		ad1.setAddressId(st1.getStudentId());
		st1.setStudentAddress(ad1);
		
		ad2.setAddressId(st2.getStudentId());
		st2.setStudentAddress(ad2);
		
		session.save(st1);
		session.save(st2);
		session.save(ad1);
		session.save(ad2);
		
		trans.commit();
		session.close();

	}

}
