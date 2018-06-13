<?php
require_once 'auth.php';
$resp = array("connection"=>"FAILED", "message"=>"null");	
if(!empty($_POST)){
	$trim = array_map('trim', $_POST);
	$light 	= mysqli_real_escape_string($connection,  $trim['light']);
	// $fan 	= mysqli_real_escape_string($connection,  $trim['fan']);
	if(empty($light)){
		$resp = array("connection"=>"FAILED", "message"=>"missing");
	}
	else{

		// if($light=="1" ) {
			$query = mysqli_query($connection,"UPDATE light set light=$light");
		// }
		// else if($fan=="1") {
		// 	$query = mysqli_query($connection,"UPDATE light set fan=$fan");
		// }
		// else if($light=="0") {
		// 	$query = mysqli_query($connection,"UPDATE light set light=$light");
		// }
		// else if($fan=="0") {
		// 	$query = mysqli_query($connection,"UPDATE light set fan=$fan");
		// }
		// else {
			// $query = mysqli_query($connection,"UPDATE light set fan=0 and set light=0");
		// }

		if($query){
			$resp = array("connection"=>"SUCCESS", "message"=>"true");
		}
		else{
			$resp = array("connection"=>"FAILED", "message"=>"false");
		}
	}
}
else{
	$resp = array("connection"=>"FAILED", "message"=>"missing");
}
echo json_encode($resp, JSON_PRETTY_PRINT);
?>

