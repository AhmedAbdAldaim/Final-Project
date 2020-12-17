<?php
include "conn.php";
$iddoc = $_POST["iddoc"];
$idpic = $_POST["idpic"];
$date = $_POST["date"];


 if($iddoc<>null)
{

    $sel = "SELECT * FROM interviews";
   $res = mysqli_query($cont,$sel);
    $old = mysqli_num_rows($res);

$in ="INSERT INTO interviews(doctor_id,pichant_id,state,date)
    VALUES('$iddoc','$idpic','notstarted','$date')";
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