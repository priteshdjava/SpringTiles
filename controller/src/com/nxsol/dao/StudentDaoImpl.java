package com.nxsol.dao;

import java.util.List;
import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nxsol.model.Student;

@Repository("dao")
@Transactional
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addStudent(Student student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return (List<Student>) sessionFactory.getCurrentSession().createCriteria(Student.class).list();
		
	}

	@Override
	public Student getById(int sId) {
		// TODO Auto-generated method stub
		return (Student) sessionFactory.getCurrentSession().get(Student.class, sId);
	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession()
				.createQuery("delete from student_detail where sId='" + student.getsId() + "'").executeUpdate();
	}

	@Override
	public void updateStudent(Student st, int sId) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("update Student set sfName='" + st.getSfName() + "',slName='"
				+ st.getSlName() + "',sCity='" + st.getsCity() + "' where sId='" + sId + "'").executeUpdate();
	}

	@Override
	public void deleteStudent(int sId) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("delete from Student where sId='" + sId + "' ").executeUpdate();
	}

	@Override
	public List<Student> listOfStudent(int firstresult, int maxresult) {
		// TODO Auto-generated method stub
		String hql="FROM Student";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(firstresult);
		query.setMaxResults(maxresult);
		List<Student> student=query.list();
		return student;
	}

	
}
