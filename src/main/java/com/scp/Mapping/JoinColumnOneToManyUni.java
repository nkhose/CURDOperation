package com.scp.Mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name = "College1")
class College1 {
	@Id
	@GeneratedValue
	private int collegeId;
	private String collegeName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private List<Student8> students;

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

	public List<Student8> getStudents() {
		return students;
	}

	public void setStudents(List<Student8> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "College1 [collegeId=" + collegeId + ", collegeName=" + collegeName + ", students=" + students + "]";
	}

	public College1(int collegeId, String collegeName, List<Student8> students) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.students = students;
	}

	public College1() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}

@Entity
@Table(name = "Student8")
class Student8 {
	@Id
//	@GeneratedValue
	private int studentId;
	private String studentName;
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
	@Override
	public String toString() {
		return "Student8 [studentId=" + studentId + ", studentName=" + studentName + "]";
	}
	public Student8(int studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}
	public Student8() {
		super();
		// TODO Auto-generated constructor stub
	}

}

public class JoinColumnOneToManyUni {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		
		Student8 st1 = new Student8(1, "Nikita");
		Student8 st2 = new Student8(2, "Pritam");
		Student8 st3 = new Student8(3, "Priyanka");
				
		List<Student8> slist1 = new ArrayList<Student8>();
		slist1.add(st1);
		slist1.add(st2);
		slist1.add(st3);
		
		
		College1 clg1 = new College1(100, "Sinhgad College", slist1);
		
		
		session.save(clg1);
		
		trans.commit();
		session.close();
	
	}
}
