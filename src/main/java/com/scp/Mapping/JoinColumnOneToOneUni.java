package com.scp.Mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name = "STUDENT2")
class Student2 {
	@Id
	@GeneratedValue
	@Column
	private int studentId;
	private String studentName;

	@OneToOne
	@JoinColumn(name = "Student_Address")
	private Address2 address;

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

	public Address2 getAddress() {
		return address;
	}

	public void setAddress(Address2 address) {
		this.address = address;
	}

	public Student2(int studentId, String studentName, Address2 address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.address = address;
	}

	public Student2() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student2 [studentId=" + studentId + ", studentName=" + studentName + ", address=" + address + "]";
	}

}

@Entity
@Table(name = "ADDRESS2")
class Address2 {

	@Id
	@GeneratedValue
	@Column
	private int addressId;
	private String city;
	private String state;

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

	public Address2(int addressId, String city, String state) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.state = state;
	}

	public Address2() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Address2 [addressId=" + addressId + ", city=" + city + ", state=" + state + "]";
	}

}

public class JoinColumnOneToOneUni {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();

		Address2 ad1 = new Address2(1, "Pune", "Maharashtra");
		Address2 ad2 = new Address2(2, "A.nagar", "Maharashtra");
		
		Student2 st1 = new Student2(10, "Nikita", ad1);
		Student2 st2 = new Student2(10, "Priyanka", ad2);

		session.save(ad1);
		session.save(ad2);
		session.save(st1);
		session.save(st2);
		trans.commit();
		session.close();

	}
}
