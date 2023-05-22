<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Simple Interest Calculation Result</title>
</head>
<body>
    <h1>Simple Interest Calculation Result</h1>
    <%-- Retrieve the form inputs --%>
    <% String principalStr = request.getParameter("principal");
       String rateStr = request.getParameter("rate");
       String periodsStr = request.getParameter("periods");
       
       double principal = Double.parseDouble(principalStr);
       double rate = Double.parseDouble(rateStr);
       double periods = Double.parseDouble(periodsStr);
       
       double simpleInterest = (principal * rate * periods) / 100;
    %>
    <p>Principal amount: <%= principal %></p>
    <p>Rate of interest: <%= rate %></p>
    <p>Periods (in years): <%= periods %></p>
    <p>Simple Interest: <%= simpleInterest %></p>
</body>
</html>