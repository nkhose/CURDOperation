package com.scp.Mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name = "Student_ManyToMany_PKJC_Bi")
class StudentManyToManyPKJCBi {
	@Id
	@GeneratedValue
	private int studentId;
	private String firstName;
	private String lastName;

	@ManyToMany(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private List<SubjectManyToManyPKJCBi> subjects = new ArrayList<SubjectManyToManyPKJCBi>();

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

	public List<SubjectManyToManyPKJCBi> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<SubjectManyToManyPKJCBi> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "StudentManyToManyPKJCBi [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", subjects=" + subjects + "]";
	}

	public StudentManyToManyPKJCBi(int studentId, String firstName, String lastName) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.subjects = subjects;
	}

	public StudentManyToManyPKJCBi() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}

@Entity
@Table(name = "Subject_ManyToMany_PKJC_Bi")
class SubjectManyToManyPKJCBi{
	@Id
	//@GeneratedValue
	private long subjectId;
	private String SubjectName;
	
	 @ManyToMany(mappedBy="subjects")
	    private List<StudentManyToManyPKJCBi> students = new ArrayList<StudentManyToManyPKJCBi>();

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

	public List<StudentManyToManyPKJCBi> getStudents() {
		return students;
	}

	public void setStudents(List<StudentManyToManyPKJCBi> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "SubjectManyToManyPKJCBi [subjectId=" + subjectId + ", SubjectName=" + SubjectName + ", students="
				+ students + "]";
	}

	public SubjectManyToManyPKJCBi(long subjectId, String subjectName) {
		super();
		this.subjectId = subjectId;
		SubjectName = subjectName;
		this.students = students;
	}

	public SubjectManyToManyPKJCBi() {
		super();
		// TODO Auto-generated constructor stub
	}

}

public class PKJCManyToManyBi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();

		StudentManyToManyPKJCBi student1 = new StudentManyToManyPKJCBi(100, "Nikita", "Khose");
		StudentManyToManyPKJCBi student2 = new StudentManyToManyPKJCBi(101, "Pritam", "Khose");

		SubjectManyToManyPKJCBi subject1 = new SubjectManyToManyPKJCBi(10, "Java");
		SubjectManyToManyPKJCBi subject2 = new SubjectManyToManyPKJCBi(11, "Hibernate");
		SubjectManyToManyPKJCBi subject3 = new SubjectManyToManyPKJCBi(12, "Spring");

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
