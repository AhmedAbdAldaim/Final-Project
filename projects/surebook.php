<?php
include "conn.php";
$iddoc = $_POST["hhhhh"];


 if($iddoc<>null)
{
    $sel = "SELECT * FROM interviews";
   $res = mysqli_query($cont,$sel);
    $old = mysqli_num_rows($res);

$in ="INSERT INTO interviews(doctor_id)
	VALUES('$iddoc')";
    $ins = mysqli_query($cont,$in);

         $sel2 = "SELECT * FROM interviews";
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