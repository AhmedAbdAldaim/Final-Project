<?php
  include ("conn.php");

  $email = $_POST["email"];
  $password = $_POST["password"];

  $sel ="SELECT * FROM users WHERE email LIKE '$email' AND password LIKE '$password' ";
  $res = mysqli_query($cont,$sel);


  $ro = mysqli_num_rows($res);

  if($ro>0)
  {
      $check["success"]=true;
  }
  else
  {
      $check["success"]=false;
  }
  echo json_encode($check);


?>