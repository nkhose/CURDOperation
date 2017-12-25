package com.scp.Mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name = "Student_ManyToMany_JC_Uni")
class StudentManyToManyJCUni {
	@Id
	@GeneratedValue
	private int studentId;
	private String firstName;
	private String lastName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private List<SubjectManyToManyJCUni> subjects = new ArrayList<SubjectManyToManyJCUni>();

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

	public List<SubjectManyToManyJCUni> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<SubjectManyToManyJCUni> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "StudentManyToManyJCUni [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", subjects=" + subjects + "]";
	}

	public StudentManyToManyJCUni(int studentId, String firstName, String lastName) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.subjects = subjects;
	}

	public StudentManyToManyJCUni() {
		super();
		// TODO Auto-generated constructor stub
	}

}

@Entity
@Table(name = "SUBJECT_ManyToMany_JC_Uni")
class SubjectManyToManyJCUni {
	@Id
	// @GeneratedValue
	private long subjectId;
	private String subjectName;

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "SubjectManyToManyJCUni [subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}

	public SubjectManyToManyJCUni(long subjectId, String subjectName) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
	}

	public SubjectManyToManyJCUni() {
		super();
		// TODO Auto-generated constructor stub
	}

}

public class JoinColumnManyToManyUni {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();

		StudentManyToManyJCUni student1 = new StudentManyToManyJCUni(100, "Nikita", "Khose");
		StudentManyToManyJCUni student2 = new StudentManyToManyJCUni(101, "Pritam", "Khose");

		SubjectManyToManyJCUni subject1 = new SubjectManyToManyJCUni(10, "Java");
		SubjectManyToManyJCUni subject2 = new SubjectManyToManyJCUni(11, "Hibernate");
		SubjectManyToManyJCUni subject3 = new SubjectManyToManyJCUni(12, "Spring");

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
	}

}
