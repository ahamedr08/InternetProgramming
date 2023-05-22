//Servlet1.java

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class Servlet1 extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8"); 
PrintWriter out = response.getWriter(); 
try {
String str1=request.getParameter("name");
String str2=request.getParameter("pass"); 
String msg="Hi  "+str1;
if(str1.equals("Ahamed")&& str2.equals("1234"))
{
out.println("<h1>"+msg+"</h1>");
out.println("<h2>You are Logged In Successfully</h2>");
}
else
{
out.println("<h2>Oops! Incorrect Login..Please Try Again</h2>"); 
out.println("<form action = \"Servlet1\" method=\"get\">"); 
out.println("NAME : <input type=\"text\" name=\"name\"><br><br>");
out.println ("PASSWORD : <input type=\"password\" name=\"pass\"><br><br>");
out.println ("<input type =\"submit\" value=\"Validate\">");
}
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");	
out.println("<title>Servlet1</title>");
out.println("</head>"); 
out.println("<body>");
out.println("</body>");
out.println("</html>");
} 
finally { out.close();
}
}
}


