/*
To assume a list of student objects, each with the following properties: name, grade, and email. 
Using JSTL core and formatting tags, create a table that displays the student information sort by name in the table format
Name	        Grade	Email
John Doe	90	john.doe@example.com

Jane Smith	85	jane.smith@example.com

Bob Johnson	95	bob.johnson@example.com
*/

<%@page import="java.util.Comparator"%> 
<%@page import="java.util.Arrays"%> 
<%@page import="java.util.Collection"%> 
<%@page import="java.util.ArrayList"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>JSP Page</title> 
</head> 
<body> <% 
class stu implements Comparable<stu> 
{ 
String name; 
String mark; String 
email; 
stu(String n,String m,String e) {
name=n; 
mark=m; 
email=e; } 
public String toString() 
{ 
return name + " " + mark+ " " + email ; 
} 
public int compareTo(stu o) 
{ return toString().compareTo(o.toString()); 
} 
} stu 
s[]={ 
new stu (“John Doe “,”90”,” john.doe@example.com”), new 
stu("Jane Smith “,”85”,” jane.smith@example.com"), 
new stu("Bob Johnson “,”95”,” bob.johnson@example.com") 
}; out.println("<br>"); 
pageContext.setAttribute("obj",s); 
%> 
<table border="2"> 
<th>name grade email</th> 
<c:forEach var="i" items="${pageScope.obj}" begin="0" end="2"> 
<tr><td>${i}</td></tr> 
</c:forEach> 
</table> 
<% 
Arrays.sort(s, new Comparator<stu>() { public 
int compare(stu o1, stu o2) { 
return o1.name.compareTo(o2.name); 
} 
}); pageContext.setAttribute("obj1",s); 
%> 
<h1>SORT BY NAMES</h1> 
<table border="2"> 
<th>name grade email</th> 
<c:forEach var="i" items="${pageScope.obj1}" begin="0" end="2"> 
<tr><td>${i}</td></tr> 
</c:forEach> 
</table>
</body> 
</html>
