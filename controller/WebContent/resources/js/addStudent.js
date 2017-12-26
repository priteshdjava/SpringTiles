var studentinfo = {
		init : function() {
			// initial level functionality when load ...

		},
		add : function(page,max) {
			// add fetch data from form and set to grid..button add/edit click
			/*debugger;*/
			/*alert(page)*/
			var fname = $("#fName").val();
			var lname = $("#lName").val();
			var city = $("#city").val();
			$.ajax({

				type : "POST",
				url : "save",
				data : "fName=" + fname + "&lName=" + lname + "&city=" + city,
				success : function(data) {
					/* alert(data); */
					/* alert("Record Added Successfully"); */
				}
			});
			studentinfo.set(page,max);
			$("#addForm")[0].reset();
		},
		edit : function(id) {
			// grid edit buttion click event...and set data to form

			$
			.ajax({

				type : "POST",
				url : "edit",
				data : "id=" + id,
				success : function(data) {
					/* alert(data); */
					var obj = JSON.parse(data);
					var button = "";
					/* alert("success"); */
					/* alert(obj.fName); */
					$("#id").val(obj.id);
					$("#fName").val(obj.fName);
					$("#lName").val(obj.lName);
					$("#city").val(obj.city);
					button = "<tr>";
					button += "<td align=justify><input type=button id=button2 value=Edit  onclick=studentinfo.saveEdit()></td>";
					button += "</tr>";
					$("#button").replaceWith(button);

				}
			});

		},

		del : function(id) {
			// delete data from grid ajax call
			$.ajax({

				type : "POST",
				url : "delete",
				data : "id=" + id,
				success : function() {
					/* alert("Record Deleted Successfully"); */
				}
			});
			studentinfo.set();
		},
		set : function(page,max) {
			// set record to grid...
			/*debugger;*/
			/*alert(page);*/
			if(page==1){ pageid=page }
			else{
			var pageid=(page-1)*max+1;
			}
			/*debugger; */
			$.ajax({

				type : "POST",
				url : "view",
				data: "page=" +pageid+ "&max=" +max,
				success : function(data) {
					/*alert(data);*/
					var link="";
					var studentList = "";
					var header = "";
					var obj = JSON.parse(data);
					var length = obj.length;
					var offset;
					/* alert(length); */
					$("#studentlist").empty();
					header = "<tr>";
					header += "<th colspan=4>Student List </th>"
						header += "</tr>";
					header += "<tr>";
					header += "<th> Student FirstName </th>";
					header += "<th> Student LastName </th>";
					header += "<th> Student's City </th>";
					header += "<th colspan=2>Operation</th>";
					$("#studentlist").append(header);
					for (var i = 0; i < obj.length; i++) {
						
						studentList = "<tr>";
						studentList += "<td>" + obj[i].fName + "</td> ";
						studentList += "<td>" + obj[i].lName + "</td> ";
						studentList += "<td>" + obj[i].city + "</td> ";
						studentList += "<td>"
							+ "<a href=javascript:studentinfo.edit("
							+ obj[i].id + ")>Edit</a>" + "</td>";
						studentList += "<td>"
							+ "<a href=javascript:studentinfo.del(" + obj[i].id
							+ ")>Delete</a>" + "</td>";
						studentList += "</tr>";
						$("#studentlist").append(studentList);
					
					}
			
				}
			});
			studentinfo.pagination();
		
		},
		get : function(ele) {
			// get record from grid...[ele means its delete or edit cell..]
		},
		clear : function(ele) { // reset form data

		},

		gather : function() {
			// gathere return object when need
		},
		saveEdit : function() {
			// its show data grid data
			var fname = $("#fName").val();
			var lname = $("#lName").val();
			var city = $("#city").val();
			var id = $("#id").val();
			$
			.ajax({

				type : "POST",
				url : "save-edit",
				data : "id=" + id + "&fName=" + fname + "&lName=" + lname
				+ "&city=" + city,
				success : function(data) {
					/* alert("Record Update Successfully"); */
					var button = "";
					button = "<tr>";
					button += "<td align=justify><input type=button id=button value=Save  onclick=studentinfo.add()></td>";
					button += "</tr>";
					$("#button2").replaceWith(button);
					studentinfo.set();
				},

			});
			$("#addForm")[0].reset();
			studentinfo.set();
			/* set : function(); */
		},
		validate : function() {
			// form validation
		},
		
		pagination:function()
		{
			/*debugger;*/
			
			var total=5;
			
			
			$.ajax({
					
				type:"GET",
				url:"viewPagination",
				success:function(data)		{
					
				var num=parseInt(data);
				alert(num);
				var page="";
				page="<tr>"
				for(var i=1;i<num+1;i++)
					{
							$("#page").empty();
							page+="<td>";
							page+="<a onclick=studentinfo.set("+i+","+total+")>"+i+" </a>"; 
							page+="</td>";
							$("#page").append(page);
						
						
					}
					page+="</tr>";
					$("#page").show();
				
				}
			});
			
		}
}

$(document).ready(function(){
		studentinfo.pagination();
		
});