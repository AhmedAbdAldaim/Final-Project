<?php
    include "conn.php";
    $name = $_GET["docid"];
    $hos =   $_GET["hosid"];
  /*  $sel = "SELECT doctor_hospital.hospital_id as h_id, users.name as user_name, worktimes.from as from_time, worktimes.day as work_day,
                worktimes.to as to_time FROM worktimes
                    INNER JOIN doctor_hospital ON
                        worktimes.doctorhospital_id = doctor_hospital.doctor_id
                            INNER JOIN doctors ON doctor_hospital.doctor_id = doctors.id
                                INNER JOIN users ON doctors.user_id = users.id
                                  WHERE worktimes.doctorhospital_id LIKE '$name'";       */
             $sel ="SELECT doctor_hospital.id as dh_id,worktimes.from,worktimes.to,worktimes.day FROM doctor_hospital INNER JOIN worktimes ON
                        worktimes.doctorhospital_id = doctor_hospital.id
                         WHERE doctor_hospital.doctor_id LIKE '$name' AND doctor_hospital.hospital_id LIKE '$hos'";


    $res = mysqli_query($cont,$sel);
    $d = array();

    while($r = mysqli_fetch_assoc($res))
    {
            $d[]=$r;
    }
    print "{all:".json_encode($d,JSON_UNESCAPED_UNICODE)."}";

?>