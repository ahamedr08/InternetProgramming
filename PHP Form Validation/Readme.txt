PROCEDURE :

(1) Form.html - This file contains a simple HTML form that allows users to enter their email and password. 
On submitting the form, the data is sent to authentication.php using the HTTP POST method.

(2) authentication.php - This file receives the email and password entered by the user, validates the data using regular expressions, and
 checks whether the email and password match with the ones stored in the database.
 If the email and password match, the user is redirected to homepage.html. If not, an error message is displayed.

(3) homepage.html - This file contains a simple welcome message that is displayed when the user is successfully authenticated.
