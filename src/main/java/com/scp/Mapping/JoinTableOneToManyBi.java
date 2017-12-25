package com.scp.Mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name = "College_6")
class College_6{
	@Id
	@GeneratedValue
	private int collegeId;
	private String collegeName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="College_Students_OTM_Bi", joinColumns=@JoinColumn(name="collegeId"), 
			inverseJoinColumns = @JoinColumn(name="studentId"))
	private List<Student_12> students;

	
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

	public List<Student_12> getStudents() {
		return students;
	}

	public void setStudents(List<Student_12> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "College_6 [collegeId=" + collegeId + ", collegeName=" + collegeName + ", students=" + students + "]";
	}

	public College_6(int collegeId, String collegeName, List<Student_12> students) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.students = students;
	}

	public College_6() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

@Entity
@Table(name = "Student_12")
class Student_12{
	@Id
	//@GeneratedValue
	private int studentId;
	private String studentName;
	
	@ManyToOne
	private College_6 college;

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

	public College_6 getCollege() {
		return college;
	}

	public void setCollege(College_6 college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "Student_12 [studentId=" + studentId + ", studentName=" + studentName + ", college=" + college + "]";
	}

	public Student_12(int studentId, String studentName, College_6 college) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.college = college;
	}

	public Student_12() {
		super();
		// TODO Auto-generated constructor stub
	}

}
public class JoinTableOneToManyBi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();

		Student_12 st1 = new Student_12(1, "Nikita", null);
		Student_12 st2 = new Student_12(2, "Varsha", null);

		College_6 clg = new College_6(10, "Sinhgad College", null);

		List<Student_12> slist = new ArrayList<Student_12>();

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
