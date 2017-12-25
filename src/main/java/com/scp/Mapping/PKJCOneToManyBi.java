package com.scp.Mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name = "College4")
class College4 {
	@Id
	// @GeneratedValue(strategy=GenerationType.AUTO)
	private int collegeId;
	private String collegeName;

	@OneToMany(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private List<Student10> students;

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public List<Student10> getStudents() {
		return students;
	}

	public void setStudents(List<Student10> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "College4 [collegeId=" + collegeId + ", collegeName=" + collegeName + ", students=" + students + "]";
	}

	public College4(int collegeId, String collegeName, List<Student10> students) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.students = students;
	}

	public College4() {
		super();
		// TODO Auto-generated constructor stub
	}

}

@Entity
@Table(name = "Student10")
class Student10 {
	@Id
	// @GeneratedValue
	private int studentId;
	private String studentName;

	@ManyToOne
	private College4 college;

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

	public College4 getCollege() {
		return college;
	}

	public void setCollege(College4 college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "Student10 [studentId=" + studentId + ", studentName=" + studentName + ", college=" + college + "]";
	}

	public Student10(int studentId, String studentName, College4 college) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.college = college;
	}

	public Student10() {
		super();
		// TODO Auto-generated constructor stub
	}

}

public class PKJCOneToManyBi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();

		Student10 st1 = new Student10(1, "Nikita", null);
		Student10 st2 = new Student10(2, "Varsha", null);

		College4 clg = new College4(10, "Sinhgad College", null);

		List<Student10> slist = new ArrayList<Student10>();

		st1.setCollege(clg);
		st2.setCollege(clg);
		slist.add(st1);
		slist.add(st2);
		clg.setStudents(slist);

		session.save(clg);

		trans.commit();
		session.close();
	}

	}
