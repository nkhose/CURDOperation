package com.scp.Inheritance;

import javax.persistence.Column;
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
@Table(name = "PARENT_2")
@Inheritance(strategy = InheritanceType.JOINED)
class Parent1 {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int studId;

	@Column
	private String studName;

	public Parent1(int studId, String studName) {
		super();
		this.studId = studId;
		this.studName = studName;
	}

	public Parent1() {
		super();
		// TODO Auto-generated constructor stub
	}

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
		return "Parent1 [studId=" + studId + ", studName=" + studName + "]";
	}

}

@Entity
@Table(name = "ChildEx1")
class ChildEx1 extends Parent1 {
	@Column
	private String LName;

	@Column
	private String address;

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

	public ChildEx1(int studId, String studName, String lName, String address) {
		super(studId, studName);
		LName = lName;
		this.address = address;
	}

}

@Entity
@Table(name = "ChildEx2")
class ChildEx2 extends Parent1 {

	@Column
	private String city;
	@Column
	private String district;

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

	public ChildEx2(int studId, String studName, String city, String district) {
		super(studId, studName);
		this.city = city;
		this.district = district;
	}

}

public class JoinedExample {
	public static void main(String[] args) {
		Session session = HibernateUtilFile.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		Parent1 p = new Parent1(10, "Nikita");
		ChildEx1 c1 = new ChildEx1(11, "Nikita", "Khose", "Pune");
		ChildEx1 c2 = new ChildEx1(12, "Pritam", "Khose", "Pune");
		ChildEx2 c3 = new ChildEx2(13, "Priyanka", "Pune", "Pune");
		ChildEx2 c4 = new ChildEx2(13, "Varsha", "Pune", "Pune");

		session.save(p);
		session.save(c1);
		session.save(c2);
		session.save(c3);
		session.save(c4);
		trans.commit();
		session.close();
	}
}
