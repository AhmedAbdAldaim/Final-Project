<?php
 include "conn.php";
    $email = $_GET["user_id"];
    $sel = "SELECT image,id FROM pichants WHERE user_id LIKE '$email'";
    $se = mysqli_query($cont,$sel);
    $d = array();

    while($r = mysqli_fetch_assoc($se))
    {
            $d[]=$r;
    }
    print "{all:".json_encode($d,JSON_UNESCAPED_UNICODE)."}";
?>