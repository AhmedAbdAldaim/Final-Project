<?php
include "conn.php";
$fname = $_POST["fname"];
//$lname = $_POST["lname"];
$email = $_POST["email"];
$password = $_POST["password"];

 $sql = "SELECT email FROM users WHERE email LIKE '$email'";
 $re = mysqli_query($cont,$sql);
 $roe = mysqli_fetch_assoc($re);

if($roe>0){
 $check["success"]=false;
}
elseif($fname<>null && $email<>null && $password<>null)
{
    $sel = "SELECT * FROM users";
   $res = mysqli_query($cont,$sel);
    $old = mysqli_num_rows($res);

$in ="INSERT INTO users(name,email,role,password)
	VALUES('$fname','$email','pichant','$password')";
    $ins = mysqli_query($cont,$in);

         $sel2 = "SELECT * FROM users";
   $res2 = mysqli_query($cont,$sel2);
    $new = mysqli_num_rows($res2);


        if($new>$old)
        {
            $check["success"]= true;

        }
        else
        {
            $check["success"] = false;
        }

}   else
{
         $check["success"]=false;
}
echo json_encode($check);


?>