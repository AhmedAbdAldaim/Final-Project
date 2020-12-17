<?php
include "conn.php";
$id = $_POST["user_id"];
$pn = $_POST["patriot_number"];
$gn = $_POST["gender"];
$br = $_POST["birthday"];
$ad = $_POST["address"];
$sen = $_POST["sensitivity"];
$ss = $_POST["social_status"];
$gd = $_POST["genetic_diseases"];
$hd = $_POST["bad_habit"];
$blood = $_POST["blood_type"];

if($id<>null)
{
    $sel = "SELECT * FROM pichants";
   $res = mysqli_query($cont,$sel);
    $old = mysqli_num_rows($res);

$in ="INSERT INTO pichants(user_id,patriot_number,gender,birthday,address,blood_type,social_status,sensitivity,genetic_diseases,bad_habit)
    VALUES('$id','$pn','$gn','$br','$ad','$blood','$ss','$sen','$gd','$hd')";
    $ins = mysqli_query($cont,$in);

    $sel2 = "SELECT * FROM pichants";
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