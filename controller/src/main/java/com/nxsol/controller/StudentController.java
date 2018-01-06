package com.nxsol.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.classic.Session;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nxsol.beans.StudentBean;
import com.nxsol.model.Student;
import com.nxsol.services.StudentServiceImpl;
import com.google.gson.Gson;

@Controller
public class StudentController {

	@Autowired
	private StudentServiceImpl service;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(@ModelAttribute("command") StudentBean studentbean) {
		/*System.out.println("this is add++++++++++++++++++++");*/
		return "addForm";
	}

	@RequestMapping(value = "/mainTemplate", method = RequestMethod.GET)
	public String getTemplate() {
		System.out.println("In Template+-----------------------------------------------------------------------");
		return "mainTemp";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody String addStudent(@ModelAttribute("command") @RequestParam("fName") String fName,
			@RequestParam("lName") String lName, @RequestParam("city") String city) {
		System.out.println(fName);
		Student student = new Student();
		student.setSfName(fName);
		student.setSlName(lName);
		student.setsCity(city);
		service.addStudent(student);
		return "redirect:add";

	}

	@RequestMapping(value = "/view", method = RequestMethod.POST)
	public @ResponseBody String getListOfStudent(@RequestParam("page") int pageId, @RequestParam("max") int total) {

		Gson gson = new Gson();
		List<Student> student = service.listOfStudent(pageId - 1, total);

		List<StudentBean> studentbean = new ArrayList<StudentBean>();
		studentbean = prepareBeanList(service.listOfStudent(pageId - 1, total));
		String jsonInString = gson.toJson(studentbean);
		return jsonInString;

	}

	@RequestMapping(value = "/viewPagination", method = RequestMethod.GET)
	public @ResponseBody String getListOfPage() {
		int pageid;
		Gson gson = new Gson();
		List<Student> student = service.getAllStudent();
		pageid = student.size();
		if (pageid % 5 == 0) {
			int page = pageid / 5;
			String jsonpageid = gson.toJson(page);
			return jsonpageid;
		} else {
			int page = (pageid / 5) + 1;
			String jsonpageid = gson.toJson(page);
			return jsonpageid;
		}
		/*
		 * List<StudentBean> studentbean = new ArrayList<StudentBean>();
		 * studentbean = prepareBeanList(student);
		 */

	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public @ResponseBody String editEmployee(@ModelAttribute("command") @RequestParam("") int id) {
		Gson gson = new Gson();
		System.out.println("ajax++++++++++++++++++++++++++++++" + id);
		// System.out.println(service.getById(id));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("student", prepateStudentBean(service.getById(id)));
		model.put("students", prepareBeanList(service.getAllStudent()));
		// model.addObject("editStudent", service.getById(id));
		// return new ModelAndView("addForm",model);
		StudentBean bean = new StudentBean();
		Student student = service.getById(id);
		bean.setId(student.getsId());
		bean.setfName(student.getSfName());
		bean.setlName(student.getSlName());
		bean.setCity(student.getsCity());
		String jsonInString = gson.toJson(bean);
		return jsonInString;
	}

	@RequestMapping(value = "/save-edit", method = RequestMethod.POST)
	public @ResponseBody String saveEdit(@RequestParam("fName") String fName, @RequestParam("lName") String lName,
			@RequestParam("city") String city, @RequestParam("id") int id) {
		System.out.println(fName);
		Student student = new Student();
		student.setsId(id);
		student.setSfName(fName);
		student.setSlName(lName);
		student.setsCity(city);
		service.updateStudent(student, id);
		// return new ModelAndView("redierct:/view");
		return "redirect:add";

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody String deletestudent(@RequestParam int id) {
		service.deleteStudent(id);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", null);
		/*
		 * model.put("employees",
		 * prepareListofBean(employeeService.listEmployeess()));
		 */
		return "redirect:add";
	}

	public List<StudentBean> prepareBeanList(List<Student> students) {
		StudentBean student = null;
		List<StudentBean> beans = new ArrayList<StudentBean>();
		for (Student std : students) {
			student = new StudentBean();
			System.out.println(std.getsId());
			student.setId(std.getsId());
			student.setfName(std.getSfName());
			student.setlName(std.getSlName());
			student.setCity(std.getsCity());

			beans.add(student);
		}
		return beans;
	}

	public StudentBean prepateStudentBean(Student student) {
		StudentBean st = new StudentBean();
		st.setfName(student.getSfName());
		st.setlName(student.getSlName());
		st.setCity(student.getsCity());
		return st;
	}

	private Student prepareModel(StudentBean studentbean) {
		Student student = new Student();
		student.setSfName(studentbean.getfName());
		student.setSlName(studentbean.getlName());
		student.setsCity(studentbean.getCity());
		return student;
	}
}
