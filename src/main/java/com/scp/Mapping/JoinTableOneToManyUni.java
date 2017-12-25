package com.scp.Mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name = "College2")
class College2{
	@Id
	@GeneratedValue
	private int collegeId;
	private String collegeName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="College_Students_OTM_Uni", joinColumns=@JoinColumn(name="collegeId"), 
				inverseJoinColumns = @JoinColumn(name="studentId"))
	private List<Student9> students;

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

	public List<Student9> getStudents() {
		return students;
	}

	public void setStudents(List<Student9> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "College2 [collegeId=" + collegeId + ", collegeName=" + collegeName + ", students=" + students + "]";
	}

	public College2(int collegeId, String collegeName, List<Student9> students) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.students = students;
	}

	public College2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

@Entity
@Table(name = "Student9")
class Student9{
	@Id
	@GeneratedValue
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
		return "Student9 [studentId=" + studentId + ", studentName=" + studentName + "]";
	}
	public Student9(int studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}
	public Student9() {
		super();
		// TODO Auto-generated constructor stub
	}

}

public class JoinTableOneToManyUni {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		
		Student9 st1 = new Student9(1, "Nikita");
		Student9 st2 = new Student9(2, "Pritam");
		Student9 st3 = new Student9(3, "Priyanka");
				
		List<Student9> slist1 = new ArrayList<Student9>();
		slist1.add(st1);
		slist1.add(st2);
		slist1.add(st3);
				
		College2 clg1 = new College2(100, "Sinhgad College", slist1);
			
		session.save(clg1);
		
		trans.commit();
		session.close();
	}

}
