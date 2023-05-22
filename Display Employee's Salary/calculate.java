import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculate extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the form data
        String name = request.getParameter("name");
        String empid = request.getParameter("empid");
        String designation = request.getParameter("designation");
        String basicpa1y=request.getParameter("basicpay");
        
        double basicPay = Double.parseDouble("basicPaly");
        // Calculate the net salary
        double da = 0.1 * basicPay; // DA is 10% of basic pay
        double hra = 0.03 * basicPay; // HRA is 3% of basic pay
        double netSalary = basicPay + da + hra;
        
        // Set the response content type
        response.setContentType("text/html");
        
        // Write the employee details to the response
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Employee Salary Details</title></head><body>");
        out.println("<h2>Employee Details:</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Employee ID: " + empid + "</p>");
        out.println("<p>Designation: " + designation + "</p>");
        out.println("<p>Basic Pay: $" + basicPay + "</p>");
        out.println("<p>DA: $" + da + "</p>");
        out.println("<p>HRA: $" + hra + "</p>");
        out.println("<p>Net Salary: $" + netSalary + "</p>");
        out.println("</body></html>");
    }
}

