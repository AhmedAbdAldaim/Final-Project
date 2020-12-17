package com.example.soso.doctors;

import android.graphics.Bitmap;

/**
 * Created by SoSo on 2/23/2020.
 */

public class lsst {
        public String name;
        public String fromm;
        public String too;
        public String hos;
    public String loc;
    public String dept;
    public String doc;
    public String pic;
    public String id_pic;
    public String id_doc;
    public String namee;
//    public String bitmap;


    public lsst(String name,String namee, String fromm, String too, String hos, String loc, String dept, String doc, String pic, String id_pic, String id_doc) {
        this.name = name;
        this.namee = namee;
        this.fromm = fromm;
        this.too = too;
        this.hos = hos;
        this.loc=loc;
        this.dept=dept;
        this.doc=doc;
        this.pic=pic;
         this.id_pic = id_pic;
        this.id_doc = id_doc;
       // this.bitmap = bitmap;
    }

    public String getNamee() {
        return namee;
    }

    public void setNamee(String namee) {
        this.namee = namee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getFrom() {
        return fromm;
    }

    public void setFrom(String fromm) {
        this.fromm = fromm;
    }

    public String getTo() {
        return too;
    }

    public void setTo(String too) {
        this.too = too;
    }


    public String getHos() {
        return hos;
    }

    public void setHos(String hos) {
        this.hos = hos;
    }

    public String getId_pic() {
        return id_pic;
    }

    public String getId_doc() {
        return id_doc;
    }

//    public String getBitmap() {
//        return bitmap;
//    }
//
//    public void setBitmap(String bitmap) {
//        this.bitmap = bitmap;
//    }

    public void setId_pic(String id_pic) {
        this.id_pic = id_pic;
    }

    public void setId_doc(String id_doc) {
        this.id_doc = id_doc;
    }

    public String getLoc() {
        return loc;
    }

    public String getDept() {
        return dept;
    }

    public String getDoc() {
        return doc;
    }

    public String getPic() {
        return pic;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

}


