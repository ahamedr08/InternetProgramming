//RegisterServlet.java

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class RegisterServlet extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException{
response.setContentType("text/html;charset=UTF-8");
Connection con;
Statement stmt;
ResultSet rs;
PrintWriter out = response.getWriter();
try{
Class.forName("org.apache.derby.jdbc.ClientDriver"); 
con=DriverManager.getConnection("jdbc:derby://localhost:1527/Registration_db","ahamed","123");
stmt=con.createStatement();
String str=request.getParameter("name");
String email=request.getParameter("email");
String pass=request.getParameter("password");
String st="INSERT INTO AHAMED.REG_TABLE VALUES ('"+str+" ','"+pass+"','"+email+"')";
stmt.executeUpdate(st);
rs=stmt.executeQuery("SELECT * FROM AHAMED.REG_TABLE");
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<title>Servlet NewServlet</title>");
out.println("</head>");
out.println("<body>");
out.println("<table border= 1px solid black><tr><th>USERNAME</th><th>PASSWORD</th><th>EMAIL</th></tr>");
while(rs.next())
{
out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td></tr>");
}
out.println("</table>");
out.println("</body>");
out.println("</html>");
con.close();
}
catch(Exception e){out.println(e);}
finally
{
out.close();
}
}
}
