import java.io.IOException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WeatherServlet extends HttpServlet {

    private String[][] weatherData = {
        {"London", "Cloudy"},
        {"New York", "Sunny"},
        {"Tokyo", "Rainy"}
    };

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String city = request.getParameter("city");
        String weather = getWeather(city);
        response.setContentType("text/html");
        response.getWriter().println("<h1>Weather Report</h1>");
        response.getWriter().println("<p>City: " + city + "</p>");
        response.getWriter().println("<p>Weather: " + weather + "</p>");
    }
    
    private String getWeather(String city) {
        for (String[] data : weatherData) {
            if (data[0].equalsIgnoreCase(city)) {
                return data[1];
            }
        }
        return "Unknown";
    }
}