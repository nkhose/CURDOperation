package com.scp.Mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table
class Students5 {

	@Id
	// @GeneratedValue(strategy=GenerationType.TABLE)
	int studentId;
	String StudentName;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "College_Students_MTM_JT_Bi")
	College_5 college;

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

	public College_5 getCollege() {
		return college;
	}

	public void setCollege(College_5 college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "Students5 [studentId=" + studentId + ", StudentName=" + StudentName + ", college=" + college + "]";
	}

	public Students5(int studentId, String studentName, College_5 college) {
		super();
		this.studentId = studentId;
		StudentName = studentName;
		this.college = college;
	}

	public Students5() {
		super();
		// TODO Auto-generated constructor stub
	}

}

@Entity
@Table
class College_5 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int collegeId;
	String CollegeName;

	@OneToMany(mappedBy = "college")
	List<Students5> students;

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

	public List<Students5> getStudents() {
		return students;
	}

	public void setStudents(List<Students5> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "College_5 [collegeId=" + collegeId + ", CollegeName=" + CollegeName + ", students=" + students + "]";
	}

	public College_5(int collegeId, String collegeName, List<Students5> students) {
		super();
		this.collegeId = collegeId;
		CollegeName = collegeName;
		this.students = students;
	}

	public College_5() {
		super();
		// TODO Auto-generated constructor stub
	}

}

public class JoinTableManyToOneBi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();

		Students5 st1 = new Students5(1, "Nikita", null);
		Students5 st2 = new Students5(2, "Pritam", null);

		College_5 college = new College_5(10, "SKNCOE", null);

		List<Students5> list = new ArrayList<Students5>();

		st1.setCollege(college);
		st2.setCollege(college);

		list.add(st1);
		list.add(st2);
		college.setStudents(list);

		session.save(college);
		session.save(st1);
		session.save(st2);

		trans.commit();
		session.close();
	}

}
