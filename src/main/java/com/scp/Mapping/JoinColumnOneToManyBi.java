package com.scp.Mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table
class College55 {
	@Id
	@GeneratedValue
	private int collegeId;
	private String collegeName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private List<Student_11> students;

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

	public List<Student_11> getStudents() {
		return students;
	}

	public void setStudents(List<Student_11> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "College55 [collegeId=" + collegeId + ", collegeName=" + collegeName + ", students=" + students + "]";
	}

	public College55(int collegeId, String collegeName, List<Student_11> students) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.students = students;
	}

	public College55() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

@Entity
@Table
class Student_11 {
	@Id
//	@GeneratedValue
	private int studentId;
	private String studentName;
	@ManyToOne
	private College55 college;
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
	public College55 getCollege() {
		return college;
	}
	public void setCollege(College55 college) {
		this.college = college;
	}
	@Override
	public String toString() {
		return "Student_11 [studentId=" + studentId + ", studentName=" + studentName + ", college=" + college + "]";
	}
	public Student_11(int studentId, String studentName, College55 college) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.college = college;
	}
	public Student_11() {
		super();
		// TODO Auto-generated constructor stub
	}	

}

public class JoinColumnOneToManyBi {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		
		Student_11 st1 = new Student_11(1, "Nikita", null);
		Student_11 st2 = new Student_11(2, "Varsha", null);

		College55 clg = new College55(10, "Sinhgad College", null);

		List<Student_11> slist = new ArrayList<Student_11>();

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
