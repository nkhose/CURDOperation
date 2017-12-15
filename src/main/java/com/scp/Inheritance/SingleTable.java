package com.scp.Inheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name = "PARENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("P")
class Parent {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int studId;

	@Column
	private String studName;

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	@Override
	public String toString() {
		return "Parent [studId=" + studId + ", studName=" + studName + "]";
	}

	public Parent(int studId, String studName) {
		super();
		this.studId = studId;
		this.studName = studName;
	}

	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}

}

@Entity
// @Table
@DiscriminatorValue("C1")
class Child1 extends Parent {

	@Column
	private String LName;

	@Column
	private String address;

	public Child1(int studId, String studName, String lName, String address) {
		super(studId, studName);
		LName = lName;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Child [LName=" + LName + ", address=" + address + "]";
	}

	public String getLName() {
		return LName;
	}

	public void setLName(String lName) {
		LName = lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

@Entity
@DiscriminatorValue("C2")
class Child2 extends Parent {
	@Column
	private String city;
	@Column
	private String district;

	public Child2(int studId, String studName, String city, String district) {
		super(studId, studName);
		this.city = city;
		this.district = district;
	}

	@Override
	public String toString() {
		return "Child2 [city=" + city + ", district=" + district + "]";
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

}

public class SingleTable {
	public static void main(String[] args) {

		Session session = HibernateUtilFile.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		Parent p = new Parent(10, "Nikita");
		Child1 c1 = new Child1(11, "Nikita", "Khose", "Pune");
		Child1 c2 = new Child1(12, "Pritam", "Khose", "Pune");
		Child2 c3 = new Child2(13, "Priyanka", "Pune", "Pune");
		Child2 c4 = new Child2(13, "Varsha", "Pune", "Pune");

		session.save(p);
		session.save(c1);
		session.save(c2);
		session.save(c3);
		session.save(c4);
		trans.commit();
		session.close();

	}
}
