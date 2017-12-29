package com.nxsol.dao;

import java.util.List;

import com.nxsol.model.Student;

public interface StudentDao {

	public void addStudent(Student student);

	public List<Student> getAllStudent();

	public Student getById(int sId);

	public void deleteStudent(Student student);
	
	public void deleteStudent(int sId);
	
	public void updateStudent(Student st,int sId);
	
	public List<Student> listOfStudent(int firstresult,int maxresult);
}
