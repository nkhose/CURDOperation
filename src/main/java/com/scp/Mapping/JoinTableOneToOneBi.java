package com.scp.Mapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name = "STUDENT6")
class Student6{
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	private String studentName;

	@OneToOne
	@JoinTable(name="StudentAddressBi")
	private Address6 address;

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

	public Address6 getAddress() {
		return address;
	}

	public void setAddress(Address6 address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student6 [studentId=" + studentId + ", studentName=" + studentName + ", address=" + address + "]";
	}

	public Student6(int studentId, String studentName, Address6 address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.address = address;
	}

	public Student6() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

@Entity
@Table(name = "ADDRESS6")
class Address6{
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private int addressId;
	private String city;
	private String state;

	@OneToOne(mappedBy = "address")
	private Student6 student;

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

	public Student6 getStudent() {
		return student;
	}

	public void setStudent(Student6 student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Address6 [addressId=" + addressId + ", city=" + city + ", state=" + state + ", student=" + student
				+ "]";
	}

	public Address6(int addressId, String city, String state, Student6 student) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.state = state;
		this.student = student;
	}

	public Address6() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
public class JoinTableOneToOneBi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();

		Address6 ad1 = new Address6(1, "Pune", "Maharashtra", null);
		Address6 ad2 = new Address6(2, "A.nagar", "Maharashtra", null);
		Student6 st1 = new Student6(10, "Nikita", ad1);
		Student6 st2 = new Student6(11, "Pritam", ad2);

		session.save(ad1);
		session.save(ad2);
		session.save(st1);
		session.save(st2);
		
		trans.commit();
		session.close();
	}

}
