<?php
require_once 'auth.php';
$resp = array("connection"=>"FAILED", "message"=>"null");	

		$query = mysqli_query($connection,"SELECT * from light ");
		if(mysqli_num_rows($query) == 0)$message = null;
		else $message = array();
		while($each_token_row = mysqli_fetch_assoc($query)){
			$message[] = $each_token_row;
		}
			$response = array("connection"=>"SUCCESS", "message"=>$message);

echo json_encode($response, JSON_PRETTY_PRINT);
?>


