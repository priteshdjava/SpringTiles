
<%@page import="java.util.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nxsol.beans.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"
	type="text/javascript" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/addStudent.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.1.47/jquery.form-validator.min.js""></script>
</head>
<body>

	<h1>Add Student Form</h1>
	<!-- <table>
		<tr>
		<td>Student FirstName: </td>
		<td><input type="text" id="fName"></td>
		</tr>
		<tr>
		<td>Student LastName: </td>
		<td><input type="text" id="lName"></td>
		</tr>
		<tr>
		<td>Student City:</td>
		<td><input type="text" id="city"></td>
		</tr>
		<tr><td align="center"><input type="button" value="save" onclick="studentinfo.add()"></td></tr>
			<tr><td><button onclick="doAjax()">demko</button></td></tr>
</table> -->
	<%    int i=1;  int total=3; %>
	<form:form id="addForm">
		<table>
			<tr>
				<td><form:label path="id" ></form:label></td>
				<td><form:input path="id" readonly="true" type="hidden" /></td>
			</tr>
			<tr>
				<td><form:label path="fName">Student FirstName:</form:label></td>
				<td><form:input path="fName" value="${student.fName}" /></td>
			</tr>
			<tr>
				<td><form:label path="lName">Student LastName:</form:label></td>
				<td><form:input path="lName" value="${student.lName}" /></td>
			</tr>
			<tr>
				<td><form:label path="city">Student's City:</form:label></td>
				<td><form:input path="city" value="${student.city}" /></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="button" id="button"
					value="save" onclick="studentinfo.add(<%=i %>,<%=total %>)"></td>
			</tr>
		</table>
	</form:form>

	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;


	<table border="1">
		<tbody id="studentlist"></tbody>
		<tbody id="studentlist1"></tbody>
		<!-- <tbody id="page"></tbody> -->
	</table>
	<table>
		<tbody id="page"></tbody>
	</table>


	<!-- href="add?page=2" -->
	<!-- <a href="add?page=2" >2</a> -->
	<%-- <a  onclick="studentinfo.set(<%=pageid%>,<%=total%>)" >2</a>
	<a href="add?page=3" onclick="studentinfo.set(<%=pageid%>,<%=total%>)">3</a> --%>
</body>
</html>