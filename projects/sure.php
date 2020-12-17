<?php
    include "conn.php";
    $name = $_GET["hospital_id"];

           $sel = "SELECT * from pichants";
  $s = mysqli_query($cont,$sel);
    $d = array();

    while($r = mysqli_fetch_assoc($s))
    {
            $d[]=$r;

    }


    print "{all:".json_encode($d,JSON_UNESCAPED_UNICODE)."}";

?>