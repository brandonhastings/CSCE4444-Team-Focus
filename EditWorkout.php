<?php

//connect to database
	$host = "mysql3.gear.host";
	$user = "adminworkout";
	$pass = "Password~";
	$db = "workoutwfriends";
	$con = mysqli_connect($host, $user, $pass, $db);

	if(!$con){
		die('Count not connect: ' . mysql_error());
	}
	
//send data to database
	
	//user info variables
	$username = $_POST["username"];
	$name = $_POST["name"];
	$newname = $_POST["newname"];
	$exercise1 = $_POST["exercise1"];
	$exercise2 = $_POST["exercise2"];
	$exercise3 = $_POST["exercise3"];
	$exercise4 = $_POST["exercise4"];
	$exercise5 = $_POST["exercise5"];
	$exercise6 = $_POST["exercise6"];
	
	$creator = $username;
	
	

	$stmt = mysqli_prepare($con, "UPDATE custom_workout SET name=?, exercise1=?, exercise2=?, exercise3=?, exercise4=?, exercise5=?, exercise6=?  WHERE creator=? AND name=?");
	mysqli_stmt_bind_param($stmt, "sssssssss", $newname, $exercise1, $exercise2, $exercise3, $exercise4, $exercise5, $exercise6, $username, $name);
	
	mysqli_stmt_execute($stmt);
	
	//send to app
	$response["success"] = true;
	
	echo json_encode($response);
	
	mysqli_close($con);

?>