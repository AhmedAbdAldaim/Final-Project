<?php
 include "conn.php";
    $email = $_GET["email"];
    $sel = "SELECT id FROM users WHERE email LIKE '$email'";
    $se = mysqli_query($cont,$sel);
    $d = array();

    while($r = mysqli_fetch_assoc($se))
    {
            $d[]=$r;
    }
    print "{all:".json_encode($d,JSON_UNESCAPED_UNICODE)."}";
?>