package com.nxsol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.nxsol.dao.StudentDao;
import com.nxsol.model.Student;

@Service("service")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao dao;

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		dao.addStudent(student);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return (List<Student>) dao.getAllStudent();
	}

	@Override
	public Student getById(int sId) {
		// TODO Auto-generated method stub
		return (Student) dao.getById(sId);
	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		dao.deleteStudent(student);
	}
	
	@Override
	public void updateStudent(Student st, int sId) {
		// TODO Auto-generated method stub
		dao.updateStudent(st, sId);
	}

	@Override
	public void deleteStudent(int sId) {
		// TODO Auto-generated method stub
		dao.deleteStudent(sId);
	}

	@Override
	public List<Student> listOfStudent(int firstresult, int maxresult) {
		// TODO Auto-generated method stub
		return dao.listOfStudent(firstresult, maxresult);
	}


}
