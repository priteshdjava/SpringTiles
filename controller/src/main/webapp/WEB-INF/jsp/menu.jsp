<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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

<%int i=1;
		int max=5;
	%>


 <!-- <a href="javascript:studentinfo.viewForm()">Add Student</a></br></br>   -->

<%-- <a href="add" onclick="javascript:studentinfo.set(<%=i %>,<%=max %>)">Add Student</a></br></br>  --%>


 <a href="add">Add Student</a></br></br> 

<a href="">View Student</a>


