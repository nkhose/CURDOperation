package com.scp.Mapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table
class Students2{
	@Id
	//@GeneratedValue(strategy=GenerationType.TABLE)
	int studentId;
	String StudentName;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinTable(name="College_Students_MTM_JT_Uni")
	College_2 college;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public College_2 getCollege() {
		return college;
	}

	public void setCollege(College_2 college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "Students2 [studentId=" + studentId + ", StudentName=" + StudentName + ", college=" + college + "]";
	}

	public Students2(int studentId, String studentName, College_2 college) {
		super();
		this.studentId = studentId;
		StudentName = studentName;
		this.college = college;
	}

	public Students2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

@Entity
@Table
class College_2{
	@Id
	//@GeneratedValue(strategy=GenerationType.TABLE)
	int collegeId;
	String CollegeName;
	
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return CollegeName;
	}
	public void setCollegeName(String collegeName) {
		CollegeName = collegeName;
	}
	@Override
	public String toString() {
		return "College_2 [collegeId=" + collegeId + ", CollegeName=" + CollegeName + "]";
	}
	public College_2(int collegeId, String collegeName) {
		super();
		this.collegeId = collegeId;
		CollegeName = collegeName;
	}
	public College_2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}


public class JoinTableManyToOneUni {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
			
		College_2 clg=new College_2(1, "SKNCOE");

		Students2 st1=new Students2(10, "Nikita", clg);
		Students2 st2=new Students2(11, "Pritam", clg);
		    
		session.save(st1);
		session.save(st2);
		trans.commit();
	}

}
