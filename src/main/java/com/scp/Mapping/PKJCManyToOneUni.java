package com.scp.Mapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table
class Students3{
	@Id
	//@GeneratedValue(strategy=GenerationType.TABLE)
	int studentId;
	String StudentName;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="College_Students_MTM_PKJC_Uni")
	College_3 college;

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

	public College_3 getCollege() {
		return college;
	}

	public void setCollege(College_3 college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "Students3 [studentId=" + studentId + ", StudentName=" + StudentName + ", college=" + college + "]";
	}

	public Students3(int studentId, String studentName, College_3 college) {
		super();
		this.studentId = studentId;
		StudentName = studentName;
		this.college = college;
	}

	public Students3() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

@Entity
@Table
class College_3{
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
		return "College_3 [collegeId=" + collegeId + ", CollegeName=" + CollegeName + "]";
	}
	public College_3(int collegeId, String collegeName) {
		super();
		this.collegeId = collegeId;
		CollegeName = collegeName;
	}
	public College_3() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

public class PKJCManyToOneUni {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		
		College_3 clg=new College_3(1, "SKNCOE");

		Students3 st1=new Students3(10, "Nikita", clg);
		Students3 st2=new Students3(11, "Pritam", clg);
		    
		session.save(st1);
		session.save(st2);
		trans.commit();
	
	}

}
