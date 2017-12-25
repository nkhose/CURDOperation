package com.scp.Mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name = "Student_ManyToMany_PKJC_Uni")
class StudentManyToManyPKJCUni {
	@Id
	@GeneratedValue
	private int studentId;
	private String firstName;
	private String lastName;

	@ManyToMany(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private List<SubjectManyToManyPKJCUni> subjects = new ArrayList<SubjectManyToManyPKJCUni>();

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

	public List<SubjectManyToManyPKJCUni> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<SubjectManyToManyPKJCUni> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "StudentManyToManyPKJCUni [studentId=" + studentId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", subjects=" + subjects + "]";
	}

	public StudentManyToManyPKJCUni(int studentId, String firstName, String lastName
			) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.subjects = subjects;
	}

	public StudentManyToManyPKJCUni() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}

@Entity
@Table(name = "Subject_ManyToMany_PKJC_Uni")
class SubjectManyToManyPKJCUni{
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
		return "SubjectManyToManyPKJCUni [subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}
	public SubjectManyToManyPKJCUni(long subjectId, String subjectName) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
	}
	public SubjectManyToManyPKJCUni() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
public class PKJCManyToManyUni {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();

		StudentManyToManyPKJCUni student1 = new StudentManyToManyPKJCUni(100, "Nikita", "Khose");
		StudentManyToManyPKJCUni student2 = new StudentManyToManyPKJCUni(101, "Pritam", "Khose");

		SubjectManyToManyPKJCUni subject1 = new SubjectManyToManyPKJCUni(10, "Java");
		SubjectManyToManyPKJCUni subject2 = new SubjectManyToManyPKJCUni(11, "Hibernate");
		SubjectManyToManyPKJCUni subject3 = new SubjectManyToManyPKJCUni(12, "Spring");

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
