<%@page import="com.hcl.entity.Student"%>
<html>
<body>
<h1 style="color:red"><center>Student Info</center></h1>

<%
Student student = (Student)request.getAttribute("student");
%>
</br>
<h3 style="color:blue"><center>Student Roll No: <%out.println(student.getRollNo());%></center></h3>
<h3 style="color:blue"><center>Student Name: <%out.println(student.getStudentName());%></center></h3>
<h3 style="color:blue"><center>Student Address: <%out.println(student.getAddress());%></center></h3>
</body>
</html>
