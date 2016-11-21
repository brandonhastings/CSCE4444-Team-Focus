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
	$exercise1 = $_POST["exercise1"];
	$exercise2 = $_POST["exercise2"];
	$exercise3 = $_POST["exercise3"];
	$exercise4 = $_POST["exercise4"];
	$exercise5 = $_POST["exercise5"];
	$exercise6 = $_POST["exercise6"];
		
	
	

	$statement = mysqli_prepare($con, "INSERT INTO `custom_workout` (creator, name, exercise1, exercise2, exercise3, exercise4, exercise5, exercise6) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
	mysqli_stmt_bind_param($statement, "ssssssss", $username, $name, $exercise1, $exercise2, $exercise3, $exercise4, $exercise5, $exercise6);
	mysqli_stmt_execute($statement);
	
	mysqli_stmt_store_result($statement);
	
	//send to app
	$response["success"] = true;
	
	echo json_encode($response);
	
	mysqli_close($con);

?>