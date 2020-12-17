<?php
    include "conn.php";
   $name = $_GET["hospital_id"];
   $sp = $_GET["sp_id"];
   // $sel = "SELECT doctors.hospital_id, departments.name as dept_name , departments.id as dept_id FROM doctors
     //		INNER JOIN departments ON doctors.department_id = departments.id WHERE doctors.hospital_id LIKE '$name'
       //     GROUP BY doctors.department_id DESC";
       // $sel = "SELECT doctors.speshalty_id , speshalties.name as Sp_Name from doctors
         //   INNER JOIN speshalties ON doctors.speshalty_id = speshalties.id
           //     ";

           $sel = "SELECT doctors.id as do_id, users.name as Do_name ,doctors.carear,doctors.address,doctors.jop_number , doctors.price, doctors.image
                     from doctor_hospital
                        INNER JOIN doctors ON doctor_hospital.doctor_id = doctors.id
                            INNER JOIN users ON doctors.user_id = users.id
                                WHERE doctor_hospital.hospital_id LIKE '$name'
                                    AND doctors.speshalty_id LIKE '$sp' ";
  $s = mysqli_query($cont,$sel);
    $d = array();

    while($r = mysqli_fetch_assoc($s))
    {
            $d[]=$r;

    }


    print "{all:".json_encode($d,JSON_UNESCAPED_UNICODE)."}";

?>