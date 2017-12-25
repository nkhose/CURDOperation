package com.scp.Mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name = "Student_ManyToMany_JT_Bi")
class StudentManyToManyJTBi {
	@Id
	@GeneratedValue
	private int studentId;
	private String firstName;
	private String lastName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Student_Subject", joinColumns = { @JoinColumn(name = "studentId") }, inverseJoinColumns = {
			@JoinColumn(name = "subjectId") })
	private List<SubjectManyToManyJTBi> subjects = new ArrayList<SubjectManyToManyJTBi>();

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<SubjectManyToManyJTBi> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<SubjectManyToManyJTBi> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "StudentManyToManyJTBi [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", subjects=" + subjects + "]";
	}

	public StudentManyToManyJTBi(int studentId, String firstName, String lastName) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.subjects = subjects;
	}

	public StudentManyToManyJTBi() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

@Entity
@Table(name = "SUBJECT_ManyToMany_JT_Bi")
class SubjectManyToManyJTBi{
	@Id
	//@GeneratedValue
	private long subjectId;
	private String SubjectName;
	
	 @ManyToMany(mappedBy="subjects")
	    private List<StudentManyToManyJTBi> students = new ArrayList<StudentManyToManyJTBi>();

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return SubjectName;
	}

	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}

	public List<StudentManyToManyJTBi> getStudents() {
		return students;
	}

	public void setStudents(List<StudentManyToManyJTBi> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "SubjectManyToManyJTBi [subjectId=" + subjectId + ", SubjectName=" + SubjectName + ", students="
				+ students + "]";
	}

	public SubjectManyToManyJTBi(long subjectId, String subjectName) {
		super();
		this.subjectId = subjectId;
		SubjectName = subjectName;
		this.students = students;
	}

	public SubjectManyToManyJTBi() {
		super();
		// TODO Auto-generated constructor stub
	}

	 
}

public class JoinTableManyToManyBi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();

		StudentManyToManyJTBi student1 = new StudentManyToManyJTBi(100, "Nikita", "Khose");
		StudentManyToManyJTBi student2 = new StudentManyToManyJTBi(101, "Pritam", "Khose");

		SubjectManyToManyJTBi subject1 = new SubjectManyToManyJTBi(10, "Java");
		SubjectManyToManyJTBi subject2 = new SubjectManyToManyJTBi(11, "Hibernate");
		SubjectManyToManyJTBi subject3 = new SubjectManyToManyJTBi(12, "Spring");
		
		
		// student1 have 3 subjects
		student1.getSubjects().add(subject1);
		student1.getSubjects().add(subject2);
		student1.getSubjects().add(subject3);

		// student2 have 2 subjects
		student2.getSubjects().add(subject1);
		student2.getSubjects().add(subject2);

		session.save(student1);
		session.save(student2);

		trans.commit();
		session.close();
		
		/*List<StudentManyToManyJTBi> list1 = new ArrayList<StudentManyToManyJTBi>();
		List<SubjectManyToManyJTBi> list2 = new ArrayList<SubjectManyToManyJTBi>();
		
		
		list1.add(student1);
		list1.add(student2);
		student1.getSubjects();
		
		list2.add(subject1);
		list2.add(subject2);
		list2.add(subject3);
		
		session.save(student1);
		session.save(student2);
		session.save(subject1);
		session.save(subject2);
		session.save(subject3);*/
	}

}
