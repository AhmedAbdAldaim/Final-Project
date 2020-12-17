<?php
if($_SERVER["REQUEST_METHOD"]=='POST')
{
 include "conn.php";

  $id = $_POST["id"];
  $fname = $_POST["fname"];
//  $lname = $_POST["lname"];
 $email = $_POST["email"];
 $pass = $_POST["password"];
 $img = $_POST["image"];
 $dtt = date("Y/m/d");
$tmm = date("h:i:sa");
$dt =date("Ymd");
 $tm =date("his");
 $dd = $dtt." : ".$tmm;
 $rn = rand(0,5000);
 $imgnam ="img_".$dt.$tm.$rn.".jpg";
 $decod =base64_decode("$img");
 file_put_contents("pic/".$imgnam,$decod);

$sel = "UPDATE users SET name='$fname',email='$email',password='$pass' WHERE id='$id'";
$s = mysqli_query($cont,$sel);

  if($s){
   $check["success"]=true;
    echo json_encode($check);
  }
}
  else
  {
      $check["success"]=false;
       echo json_encode($check);
  }

?>