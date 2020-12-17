<?php
        include "conn.php";
        $user_id = $_GET["user_id"];
        $sel = "SELECT pichants.id as p_id, users.name as user_name FROM pichants
        INNER JOIN users ON users.id = pichants.user_id  WHERE user_id LIKE '$user_id'";
        $s = mysqli_query($cont,$sel) ;
        $d = array();
        while($r = mysqli_fetch_assoc($s))
        {
            $d[]=$r;
        }
        print "{all:".json_encode($d,JSON_UNESCAPED_UNICODE)."}";
?>