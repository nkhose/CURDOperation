package com.scp.Mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name = "STUDENT4")
class Student4 {

	@Id
	@GeneratedValue
	@Column
	private int studentId;
	private String studentName;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Address4 address;

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

	public Address4 getAddress() {
		return address;
	}

	public void setAddress(Address4 address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student4 [studentId=" + studentId + ", studentName=" + studentName + ", address=" + address + "]";
	}

	public Student4(int studentId, String studentName, Address4 address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.address = address;
	}

	public Student4() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

@Entity
@Table(name = "ADDRESS4")
class Address4{
	@Id
	@GeneratedValue
	@Column
	private int addressId;
	private String city;
	private String state;
	
	@OneToOne(mappedBy = "address")
	private Student4 student;

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

	public Student4 getStudent() {
		return student;
	}

	public void setStudent(Student4 student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Address4 [addressId=" + addressId + ", city=" + city + ", state=" + state + ", student=" + student
				+ "]";
	}

	public Address4(int addressId, String city, String state, Student4 student) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.state = state;
		this.student = student;
	}

	public Address4() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
public class PKJCOneToOneBi {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		
		Address4 ad1 = new Address4(10, "Pune", "Maharashtra",null);
		Address4 ad2 = new Address4(11, "A.nagar", "Maharashtra", null);
		Student4 st1 = new Student4(1, "Nikita", ad1);
		Student4 st2 = new Student4(2, "Pritam", ad2);
		
		ad1.setAddressId(st1.getStudentId());
		ad2.setAddressId(st2.getStudentId());
		st1.setAddress(ad1);
		st2.setAddress(ad2);
		
		session.save(st1);
		session.save(st2);
		session.save(ad1);
		session.save(ad2);
		
		trans.commit();
		session.close();
	}
	
}
