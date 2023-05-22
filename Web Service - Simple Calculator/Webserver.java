/* Create a simple calculator web service that takes two numbers and performs addition,
Subtraction, multiplication, or division on them. Use JSP to create a user interface that
allows users to enter the numbers and select the operation they want to perform.*/


//Webserver.java

package calc;
import javax.jws.WebService;
import javax.jws.WebMethod; 
import javax.jws.WebParam;
@WebService(serviceName = "webser")
public class webser {
@WebMethod(operationName = "hello") public String hello(@WebParam(name = "name") String txt) {
return "Hello " + txt + " !";
}
@WebMethod(operationName = "addition") public Integer addition(@WebParam(name = "a") int a, @WebParam(name = "b") int b)
{ 
return a+b;
}
@WebMethod(operationName = "subration") public Integer subration(@WebParam(name = "a") int a, @WebParam(name = "b") int b)
{ 
return a-b;
}
@WebMethod(operationName = "mul") public Integer mul(@WebParam(name = "a") int a, @WebParam(name = "b") int b)
{ 
return a*b;
}
@WebMethod(operationName = "div") public Integer div(@WebParam(name = "a") int a, @WebParam(name = "b") int b)
{ 
return a/b;
} 
}
