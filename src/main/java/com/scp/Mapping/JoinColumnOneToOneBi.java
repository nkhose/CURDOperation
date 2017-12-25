package com.scp.Mapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name = "STUDENT5")
class Student5 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	private String studentName;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn
	private Address5 address;

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

	public Address5 getAddress() {
		return address;
	}

	public void setAddress(Address5 address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student5 [studentId=" + studentId + ", studentName=" + studentName + ", address=" + address + "]";
	}

	public Student5(int studentId, String studentName, Address5 address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.address = address;
	}

	public Student5() {
		super();
		// TODO Auto-generated constructor stub
	}

}

@Entity
@Table(name = "ADDRESS5")
class Address5 {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int addressId;
	private String city;
	private String state;

	@OneToOne(mappedBy = "address")
	private Student5 student;

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

	public Student5 getStudent() {
		return student;
	}

	public void setStudent(Student5 student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Address5 [addressId=" + addressId + ", city=" + city + ", state=" + state + ", student=" + student
				+ "]";
	}

	public Address5(int addressId, String city, String state, Student5 student) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.state = state;
		this.student = student;
	}

	public Address5() {
		super();
		// TODO Auto-generated constructor stub
	}

}

public class JoinColumnOneToOneBi {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();

		Address5 ad1 = new Address5(1, "Pune", "Maharashtra", null);
		Address5 ad2 = new Address5(2, "A.nagar", "Maharashtra", null);
		Student5 st1 = new Student5(10, "Nikita", ad1);
		Student5 st2 = new Student5(11, "Priyanka", ad2);

		session.save(ad1);
		session.save(ad2);
		session.save(st1);
		session.save(st2);
		
		trans.commit();
		session.close();
	}
}
