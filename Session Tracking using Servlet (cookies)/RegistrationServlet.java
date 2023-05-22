//RegistrationServlet.java

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.http.Cookie;
public class RegistrationServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    Cookie userCookie = new Cookie("user", name + "|" + email + "|" + password);
    userCookie.setMaxAge(60 * 60 * 24 * 365); 
    response.addCookie(userCookie);
    response.sendRedirect("ahamed.jsp");
  }
}
