package com.scp.Mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table
class Students_6 {
	@Id
	// @GeneratedValue(strategy=GenerationType.TABLE)
	int studentId;
	String StudentName;

	@ManyToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "College_Students_MTM_PKJC_Bi")
	College_66 college;

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

	public College_66 getCollege() {
		return college;
	}

	public void setCollege(College_66 college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "Students_6 [studentId=" + studentId + ", StudentName=" + StudentName + ", college=" + college + "]";
	}

	public Students_6(int studentId, String studentName, College_66 college) {
		super();
		this.studentId = studentId;
		StudentName = studentName;
		this.college = college;
	}

	public Students_6() {
		super();
		// TODO Auto-generated constructor stub
	}

}

@Entity
@Table
class College_66 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int collegeId;
	String CollegeName;

	@OneToMany(mappedBy = "college")
	List<Students_6> students;

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

	public List<Students_6> getStudents() {
		return students;
	}

	public void setStudents(List<Students_6> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "College_66 [collegeId=" + collegeId + ", CollegeName=" + CollegeName + ", students=" + students + "]";
	}

	public College_66(int collegeId, String collegeName, List<Students_6> students) {
		super();
		this.collegeId = collegeId;
		CollegeName = collegeName;
		this.students = students;
	}

	public College_66() {
		super();
		// TODO Auto-generated constructor stub
	}

}

public class PKJCManyToOneBi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();

		Students_6 st1 = new Students_6(1, "Nikita", null);
		Students_6 st2 = new Students_6(2, "Pritam", null);

		College_66 college = new College_66(10, "SKNCOE", null);

		List<Students_6> list = new ArrayList<Students_6>();

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
