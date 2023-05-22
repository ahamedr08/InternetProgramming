//authentication.php

<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "Registration_db";

$conn = new mysqli($servername, $username, $password, $dbname);
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
$email = $_POST["email"];
$password = $_POST["password"];
echo "Entered Email : " .$email."<br>";
echo "Entered Password : ".$password."<br><br>";

if (!preg_match("/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/", $email)) {
    die("Invalid email format");
}

if (!preg_match("/.{6,}/", $password)) {
    die("Invalid password format (must be atleast 6 characters long)");
}

$stmt = $conn->prepare("SELECT * FROM users WHERE EMAIL = ? AND PASSWORD = ?");
$stmt->bind_param("ss", $email, $password);
$stmt->execute();
$result = $stmt->get_result();
if ($result->num_rows == 1) {
    header("Location:homepage.html");
    exit;
} else {
    echo "Your entered data is not in the Database table !!";
}
$stmt->close();
$conn->close();
?>


