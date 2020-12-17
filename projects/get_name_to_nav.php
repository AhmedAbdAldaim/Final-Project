<?php
 include "conn.php";
    $id = $_GET["user_id"];
    $sel = "SELECT users.id as user_id ,name,email,
     password,pichants.image,pichants.id as pic_id ,pichants.user_id as pichant_id FROM pichants
        INNER JOIN users ON pichants.user_id = users.id WHERE users.id LIKE '$id'";
    $se = mysqli_query($cont,$sel);
    $d = array();

    while($r = mysqli_fetch_assoc($se))
    {
            $d[]=$r;
    }
    print "{all:".json_encode($d,JSON_UNESCAPED_UNICODE)."}";
?>