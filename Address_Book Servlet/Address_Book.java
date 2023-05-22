import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Address_Book extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name=request.getParameter("fname");
        String design=request.getParameter("designation");
        String add1=request.getParameter("add1");
        String add2=request.getParameter("add2");
        String state=request.getParameter("state");
        String city=request.getParameter("city");
        String email=request.getParameter("email");      
        PrintWriter out = response.getWriter();
        try {
            if (email != null && !email.isEmpty()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Address_book</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>First Name: " + name + "</h3>");
            out.println("<h3>Designation: " + design + "</h3>");
            out.println("<h3>Address 1: " + add1 + "</h3>");
            out.println("<h3>Address 2: " + add2 + "</h1>");
            out.println("<h3>State: " + state + "</h3>");
            out.println("<h3>City: " + city + "</h3>");
            out.println("<h3>E-Mail ID: " + email + "</h3>");
            out.println("</body>");
            out.println("</html>");
        } else {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Address Book</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Address Book</h1>");
            out.println("<p>Oops! No entry found for the given email ID.</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    finally {
        out.close();
    }
}
}

