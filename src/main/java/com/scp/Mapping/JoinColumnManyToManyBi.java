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
@Table(name = "Student_ManyToMany_JC_Bi")
class StudentManyToManyJCBi {
	@Id
	@GeneratedValue
	private int studentId;
	private String firstName;
	private String lastName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private List<SubjectManyToManyJCBi> subjects = new ArrayList<SubjectManyToManyJCBi>();

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

	public List<SubjectManyToManyJCBi> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<SubjectManyToManyJCBi> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "StudentManyToManyJCBi [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", subjects=" + subjects + "]";
	}

	public StudentManyToManyJCBi(int studentId, String firstName, String lastName
			) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.subjects = subjects;
	}

	public StudentManyToManyJCBi() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}

@Entity
@Table(name = "SUBJECT_ManyToMany_JC_Bi")
class SubjectManyToManyJCBi{
	@Id
	//@GeneratedValue
	private long subjectId;
	private String SubjectName;
	
	 @ManyToMany(mappedBy="subjects")
	    private List<StudentManyToManyJCBi> students = new ArrayList<StudentManyToManyJCBi>();

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

	public List<StudentManyToManyJCBi> getStudents() {
		return students;
	}

	public void setStudents(List<StudentManyToManyJCBi> students) {
		this.students = students;
	}

	public SubjectManyToManyJCBi(long subjectId, String subjectName) {
		super();
		this.subjectId = subjectId;
		SubjectName = subjectName;
		this.students = students;
	}

	@Override
	public String toString() {
		return "SubjectManyToManyJCBi [subjectId=" + subjectId + ", SubjectName=" + SubjectName + ", students="
				+ students + "]";
	}

	public SubjectManyToManyJCBi() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
}

public class JoinColumnManyToManyBi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();

		StudentManyToManyJCBi student1 = new StudentManyToManyJCBi(100, "Nikita", "Khose");
		StudentManyToManyJCBi student2 = new StudentManyToManyJCBi(101, "Pritam", "Khose");

		SubjectManyToManyJCBi subject1 = new SubjectManyToManyJCBi(10, "Java");
		SubjectManyToManyJCBi subject2 = new SubjectManyToManyJCBi(11, "Hibernate");
		SubjectManyToManyJCBi subject3 = new SubjectManyToManyJCBi(12, "Spring");

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
