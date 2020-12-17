<?php
 include "conn.php";
    $us_id = $_GET["user_id"];
    $sel = "SELECT id FROM pichants WHERE user_id LIKE '$us_id'";
    $se = mysqli_query($cont,$sel);
    $d = array();

    while($r = mysqli_fetch_assoc($se))
    {
            $d[]=$r;
    }
    print "{all:".json_encode($d,JSON_UNESCAPED_UNICODE)."}";
?>