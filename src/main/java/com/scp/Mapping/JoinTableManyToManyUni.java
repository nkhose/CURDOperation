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
@Table(name = "Student_ManyToMany_JT_Uni")
class StudentManyToManyJTUni {
	@Id
	@GeneratedValue
	private int studentId;
	private String firstName;
	private String lastName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Student_Subject_Uni", joinColumns = { @JoinColumn(name = "studentId") }, inverseJoinColumns = {
			@JoinColumn(name = "subjectId") })
	private List<SubjectManyToManyJTUni> subjects = new ArrayList<SubjectManyToManyJTUni>();

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

	public List<SubjectManyToManyJTUni> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<SubjectManyToManyJTUni> subjects) {
		this.subjects = subjects;
	}

	public StudentManyToManyJTUni(int studentId, String firstName, String lastName) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.subjects = subjects;
	}

	public StudentManyToManyJTUni() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StudentManyToManyJTUni [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", subjects=" + subjects + "]";
	}

}

@Entity
@Table(name = "SUBJECT_ManyToMany_JT_Uni")
class SubjectManyToManyJTUni {

	@Id
	// @GeneratedValue
	private long subjectId;
	private String name;

	public SubjectManyToManyJTUni(long subjectId, String name) {
		super();
		this.subjectId = subjectId;
		this.name = name;
	}

	@Override
	public String toString() {
		return "SubjectManyToManyJTUni [subjectId=" + subjectId + ", name=" + name + "]";
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SubjectManyToManyJTUni() {
		super();
		// TODO Auto-generated constructor stub
	}

}

public class JoinTableManyToManyUni {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();

		StudentManyToManyJTUni student1 = new StudentManyToManyJTUni(100, "Nikita", "Khose");
		StudentManyToManyJTUni student2 = new StudentManyToManyJTUni(101, "Pritam", "Khose");

		SubjectManyToManyJTUni subject1 = new SubjectManyToManyJTUni(10, "Java");
		SubjectManyToManyJTUni subject2 = new SubjectManyToManyJTUni(11, "Hibernate");
		SubjectManyToManyJTUni subject3 = new SubjectManyToManyJTUni(12, "Spring");

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
