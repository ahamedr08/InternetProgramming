//Newjsp.jsp

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> <title>JSP Page</title>
</head>
<body>
<form action="newjsp.jsp" method="get">
Enter a: <input type="number" name="n1" id="a">
Enter b: <input type="number" name="n2" id="b">
<button type="submit" formaction="newjsp.jsp" name="add" value="ADD">
ADD
</button>
<button type="submit" formaction="newjsp.jsp" name="sub" value="SUB">
SUB
</button>
</button>
<button type="submit" formaction="newjsp.jsp" name="mul" value="MUL"> MULTIPLY
</button>
</button>
<button type="submit" formaction="newjsp.jsp" name="div" value="DIV"> DIVIDE
</button>
</form>
<%-- start web service invocation --%><hr/>
<%
try { calc.Webser_Service service = new calc.Webser_Service(); 
calc.Webser port = service.getWebserPort();
int a = Integer.parseInt(request.getParameter("n1"));
 int b = Integer.parseInt(request.getParameter("n2"));
if (request.getParameter("add").equals("ADD"))
{
java.lang.Integer result = port.addition(a, b); 
out.println("Result = "+result);}
}
catch (Exception ex) {
// TODO handle custom exceptions here
}
%>
<%-- end web service invocation --%><hr/>
<%
try { calc.Webser_Service service = new calc.Webser_Service();
 calc.Webser port = service.getWebserPort();
int a = Integer.parseInt(request.getParameter("n1")); 
int b = Integer.parseInt(request.getParameter("n2"));
if (request.getParameter("sub").equals("SUB"))
{
java.lang.Integer result = port.subration(a, b);
out.println("Result = "+result);
}
} catch (Exception ex) {
// TODO handle custom exceptions here
}
%>
<%-- start web service invocation --%><hr/>
<%
try { calc.Webser_Service service = new calc.Webser_Service(); 
calc.Webser port = service.getWebserPort();
int a = Integer.parseInt(request.getParameter("n1"));
 int b = Integer.parseInt(request.getParameter("n2"));
if (request.getParameter("mul").equals("MUL"))
{
java.lang.Integer result = port.mul(a, b);
 out.println("Result = "+result);} } 
catch (Exception ex) {
// TODO handle custom exceptions here
}
%>
<%-- start web service invocation --%><hr/>
<%
try { calc.Webser_Service service = new calc.Webser_Service(); 
calc.Webser port = service.getWebserPort();
int a = Integer.parseInt(request.getParameter("n1"));
 int b = Integer.parseInt(request.getParameter("n2"));
if (request.getParameter("div").equals("DIV"))
{
java.lang.Integer result = port.div(a, b); out.println("Result = "+result);} } catch (Exception ex) {
// TODO handle custom exceptions here
}
%>
<%-- end web service invocation --%><hr/>
</body>
</html>
