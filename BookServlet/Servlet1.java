import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet1 extends HttpServlet {
 Connection conn;
 protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
 PrintWriter out = response.getWriter();
 response.setContentType("text/html;charset=UTF-8");
 String bookid = request.getParameter("bookid");
 String booktitle = request.getParameter("booktitle");
 String bookprice = request.getParameter("bookprice");
 String action = request.getParameter("action");
 try {
 Class.forName("org.apache.derby.jdbc.ClientDriver"); 
 conn = DriverManager.getConnection("jdbc:derby://localhost:1527/book_db","ahamed","1234");
 } catch (SQLException e) {
 out.println(e);
 
 }
     switch (action) {
         case "INSERT":
             insertBook(bookid, booktitle, bookprice);
             out.println("<h1>Book inserted successfully!</h1>");
             break;
         case "UPDATE":
             updateBook(bookid, booktitle, bookprice);
             out.println("<h1>Book updated successfully!</h1>");
             break;
         case "DELETE":
             deleteBook(bookid);
             out.println("<h1>Book deleted successfully!</h1>");
             break;
         case "SEARCH":
             searchBook(bookid,response);
             break;
         case "DELETE ALL":
             deleteAll();
             out.println("<h1>All Book records deleted successfully!</h1>");
             break;
         default:
             break;
     }
 }
 
 public void insertBook(String bookid, String booktitle, String bookprice) throws ServletException {
 try {
 String sql = "INSERT INTO BOOK(BOOK_ID, BOOK_TITLE, BOOK_PRICE) VALUES (?,?,?)";
 PreparedStatement statement = conn.prepareStatement(sql);
 statement.setString(1, bookid);
 statement.setString(2, booktitle);
 statement.setString(3, bookprice);
 statement.executeUpdate();
 } catch (SQLException e) {
 throw new ServletException(e);
 }
 }
 
 public void updateBook(String bookid, String booktitle, String bookprice) throws ServletException {
 try {
 String sql = "UPDATE BOOK SET BOOK_TITLE=?, BOOK_PRICE=? WHERE BOOK_ID=?";
 PreparedStatement statement = conn.prepareStatement(sql);
 statement.setString(1, booktitle);
 statement.setString(2, bookprice);
 statement.setString(3, bookid);
 statement.executeUpdate();
 } catch (SQLException e) {
 throw new ServletException(e);
 }
 }
 
 public void deleteBook(String bookid) throws ServletException {
 try {
 String sql = "DELETE FROM BOOK WHERE BOOK_ID=?";
 PreparedStatement statement = conn.prepareStatement(sql);
 statement.setString(1, bookid);
 statement.executeUpdate();
 } catch (SQLException e) {
 throw new ServletException(e);
 }
 }
 
public void searchBook(String bookid, HttpServletResponse response) throws ServletException, IOException {
   try {
      String sql = "SELECT * FROM BOOK WHERE Book_ID=?";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.setString(1, bookid);
      ResultSet result = statement.executeQuery();
      PrintWriter out = response.getWriter();
      out.println("<style>");
      out.println("table,th,td{border:2px solid black;border-collapse:collapse;}");
      out.println("</style>");
      out.println("<h1>Book Details:</h1>");
      out.println("<table>");
      out.println("<tr><th>Book ID</th><th>Book Title</th><th>Book Price</th></tr>");
      while (result.next()) {
         out.println("<tr>");
         out.println("<td>" + result.getString("BOOK_ID") + "</td>");
         out.println("<td>" + result.getString("BOOK_TITLE") + "</td>");
         out.println("<td>" + result.getString("BOOK_PRICE") + "</td>");
         out.println("</tr>");
      }
      out.println("</table>");
   } catch (SQLException e) {
      throw new ServletException(e);
   }
}

public void deleteAll() throws ServletException {
    try {
        String sql = "DELETE FROM BOOK";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.executeUpdate();
    } catch (SQLException e) {
        throw new ServletException(e);
    }
}

 @Override
 public void destroy() {
 try {
 conn.close();
 } catch (SQLException e) {
     e.printStackTrace();
 }
 }