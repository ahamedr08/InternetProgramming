/*Write a servlet program to find the gross salary for an employee.
Test this by a client program to get the form data inputs (name, empid, basicpay, HRA) and 
display the result (name, empid, basic pay, HRA along with calculated DA(50% of Basic pay) and gross pay(basicpay+hra+DA)).*/

//Servlet2.java

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter; 
public class Servlet2 extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
String name=request.getParameter("name");
String empid=request.getParameter("empid"); 
int basicpay=Integer.parseInt(request.getParameter("bpay")); 
int hra=Integer.parseInt(request.getParameter("hra"));
int da=basicpay/2; 
int grosspay=basicpay+hra+da;
PrintWriter out = response.getWriter(); 
try {
out.println("<!DOCTYPE html>");
out.println("<html>"); 
out.println("<head>");
out.println("<title>Servlet2</title>");
out.println("</head>"); 
out.println("<body>");
out.println("<h1>  Employee Details</h1>");
out.println("<h2>  Name : "+name+"</h2>");
out.println("<h2>  Employee ID : "+empid+"</h2>");
out.println("<h2>  Basic Pay : "+basicpay+"</h2>"); 
out.println("<h2>  HRA : "+hra+"</h2>");
out.println("<h2>  DA : "+da+"</h2>");
out.println("<h2>  Gross Pay : "+grosspay+"</h2>"); 
out.println("</body>"); 
out.println("</html>");} finally { out.close();
}}}
