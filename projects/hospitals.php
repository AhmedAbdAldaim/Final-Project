<?php
        include "conn.php";
        $sel = "SELECT * FROM hospitals";
        $s = mysqli_query($cont,$sel) ;
        $d = array();
        while($r = mysqli_fetch_assoc($s))
        {
            $d[]=$r;
        }
        print "{all:".json_encode($d,JSON_UNESCAPED_UNICODE)."}";
?>