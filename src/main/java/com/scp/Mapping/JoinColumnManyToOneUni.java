package com.scp.Mapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;


@Entity
@Table
class Students1{
	@Id
	//@GeneratedValue(strategy=GenerationType.TABLE)
	int studentId;
	String StudentName;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="College_Students_MTM_JC_Uni")
	College_1 college;

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

	public College_1 getCollege() {
		return college;
	}

	public void setCollege(College_1 college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "Students1 [studentId=" + studentId + ", StudentName=" + StudentName + ", college=" + college + "]";
	}

	public Students1(int studentId, String studentName, College_1 college) {
		super();
		this.studentId = studentId;
		StudentName = studentName;
		this.college = college;
	}

	public Students1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}


@Entity
@Table
class College_1{
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
		return "College_1 [collegeId=" + collegeId + ", CollegeName=" + CollegeName + "]";
	}
	public College_1(int collegeId, String collegeName) {
		super();
		this.collegeId = collegeId;
		CollegeName = collegeName;
	}
	public College_1() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
}
public class JoinColumnManyToOneUni {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
			
		College_1 clg=new College_1(1, "SKNCOE");

		Students1 st1=new Students1(10, "Nikita", clg);
		Students1 st2=new Students1(11, "Pritam", clg);
		    
		session.save(st1);
		session.save(st2);
		trans.commit();
	}

}
