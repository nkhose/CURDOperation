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
@Table(name = "CollegeInfo")
class CollegeInfo{
	@Id
	@GeneratedValue
	@Column
	private int collegeId;
	private String collegeName;
	@OneToMany(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private List<Student7> students;
	
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
	public List<Student7> getStudents() {
		return students;
	}
	public void setStudents(List<Student7> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "CollegeInfo [collegeId=" + collegeId + ", collegeName=" + collegeName + ", students=" + students + "]";
	}
	public CollegeInfo(int collegeId, String collegeName, List<Student7> students) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.students = students;
	}
	public CollegeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

@Entity
@Table(name = "Student7")
class Student7{
	@Id
	//@GeneratedValue
	@Column
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
		return "Student7 [studentId=" + studentId + ", studentName=" + studentName + "]";
	}
	public Student7(int studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}
	public Student7() {
		super();
		// TODO Auto-generated constructor stub
	}

}

public class PKJCOneToManyUni {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		
		Student7 st1 = new Student7(1, "Nikita");
		Student7 st2 = new Student7(2, "Pritam");
		Student7 st3 = new Student7(3, "Varsha");
				
		List<Student7> slist1 = new ArrayList<Student7>();
		slist1.add(st1);
		slist1.add(st2);
		
		List<Student7> slist2 = new ArrayList<Student7>();
		slist2.add(st3);
		
		CollegeInfo clg1 = new CollegeInfo(100, "Sinhgad College", slist1);
		CollegeInfo clg2 = new CollegeInfo(101, "Raisoni College", slist2);
		
		session.save(clg1);
		session.save(clg2);
		trans.commit();
		session.close();
	
	}

}
