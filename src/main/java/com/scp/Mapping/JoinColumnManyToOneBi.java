package com.scp.Mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table
class Students4 {
	@Id
	// @GeneratedValue(strategy=GenerationType.TABLE)
	int studentId;
	String StudentName;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "College_Students_MTM_JC_Bi")
	College_4 college;

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

	public College_4 getCollege() {
		return college;
	}

	public void setCollege(College_4 college) {
		this.college = college;
	}

	public Students4(int studentId, String studentName, College_4 college) {
		super();
		this.studentId = studentId;
		StudentName = studentName;
		this.college = college;
	}

	public Students4() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Students4 [studentId=" + studentId + ", StudentName=" + StudentName + ", college=" + college + "]";
	}

}

@Entity
@Table
class College_4 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int collegeId;
	String CollegeName;

	@OneToMany(mappedBy = "college")
	List<Students4> students;

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

	public List<Students4> getStudents() {
		return students;
	}

	public void setStudents(List<Students4> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "College_4 [collegeId=" + collegeId + ", CollegeName=" + CollegeName + ", students=" + students + "]";
	}

	public College_4(int collegeId, String collegeName, List<Students4> students) {
		super();
		this.collegeId = collegeId;
		CollegeName = collegeName;
		this.students = students;
	}

	public College_4() {
		super();
		// TODO Auto-generated constructor stub
	}

}

public class JoinColumnManyToOneBi {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();

		Students4 st1 = new Students4(1, "Nikita", null);
		Students4 st2 = new Students4(2, "Pritam", null);

		College_4 college = new College_4(10, "SKNCOE", null);

		List<Students4> list = new ArrayList<Students4>();

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
