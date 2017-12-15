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
@Table(name = "PARENT_3")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
class Parent2 {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int studId;

	@Column
	private String studName;

	public Parent2(int studId, String studName) {
		super();
		this.studId = studId;
		this.studName = studName;
	}

	public Parent2() {
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
@Table(name = "ChildTest1")
class ChildTest1 extends Parent2 {
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

	public ChildTest1(int studId, String studName, String lName, String address) {
		super(studId, studName);
		LName = lName;
		this.address = address;
	}
}

@Entity
@Table(name = "ChildTest2")
class ChildTest2 extends Parent2 {
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

	public ChildTest2(int studId, String studName, String city, String district) {
		super(studId, studName);
		this.city = city;
		this.district = district;
	}

}

public class ConcreteClassEx {
	public static void main(String[] args) {
		Session session = HibernateUtilFile.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		Parent2 p = new Parent2(10, "Nikita");
		ChildTest1 c1 = new ChildTest1(11, "Nikita", "Khose", "Pune");
		ChildTest1 c2 = new ChildTest1(12, "Pritam", "Khose", "Pune");
		ChildTest2 c3 = new ChildTest2(13, "Priyanka", "Pune", "Pune");
		ChildTest2 c4 = new ChildTest2(13, "Varsha", "Pune", "Pune");

		session.save(p);
		session.save(c1);
		session.save(c2);
		session.save(c3);
		session.save(c4);
		trans.commit();
		session.close();
	}
}
