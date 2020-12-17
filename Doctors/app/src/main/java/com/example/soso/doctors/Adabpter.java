package com.example.soso.doctors;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by SoSo on 2/24/2020.
 */

public class Adabpter extends RecyclerView.Adapter<Adabpter.ViewHolder> {

    Context mcontext;
    TextView name,frommn,too,hos,loc,dep,doc,pic,id_pic,id_doc,name2;
    ImageView image;
    TextView formmn;
    String days2[]=new String[30],days3[]=new String[30];
    String day_accepet[]=new String[30];
    Button button;
    ArrayList<lsst> arrayList = new ArrayList<lsst>();

    public Adabpter(ArrayList<lsst> arrayList, Context mcontext) {
        this.arrayList = arrayList;
        this.mcontext = mcontext;


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(mcontext);
        View view = layoutInflater.inflate(R.layout.lsst, parent,false);

         name =(TextView)view.findViewById(R.id.name);
        name2 =(TextView)view.findViewById(R.id.name2);
         frommn =(TextView)view.findViewById(R.id.ffrom);
       too =(TextView)view.findViewById(R.id.too);
        hos =(TextView)view.findViewById(R.id.hos);
        loc =(TextView)view.findViewById(R.id.loc);
        dep =(TextView)view.findViewById(R.id.dep);
        doc =(TextView)view.findViewById(R.id.doc);
        pic =(TextView)view.findViewById(R.id.pic);
        id_pic =(TextView)view.findViewById(R.id.id_pic);
        id_doc =(TextView)view.findViewById(R.id.id_doc);
//        image =(ImageView)view.findViewById(R.id.img);
        button =(Button)view.findViewById(R.id.btndate);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        lsst arrany = arrayList.get(position);
        holder.name.setText(arrany.getName());
        holder.name2.setText(arrany.getNamee());
        holder.frommn.setText(arrany.getFrom());
        holder.too.setText(arrany.getTo());
        holder.hos.setText(arrany.getHos());
        holder.loc.setText(arrany.getLoc());
        holder.dep.setText(arrany.getDept());
        holder.doc.setText(arrany.getDoc());
        holder.pic.setText(arrany.getPic());
        holder.id_pic.setText(arrany.getId_pic());
        holder.id_doc.setText(arrany.getId_doc());
       //holder.image.setText(arrany.getBitmap());
      //  Picasso.with(mcontext).load("http://192.168.43.176/projects/pic/"+arrany.getBitmap()).into(image);





        SimpleDateFormat m = new SimpleDateFormat("EE dd-MMM-yyyy");
        SimpleDateFormat m2 = new SimpleDateFormat("yyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat(" dd-MMM-yyyy");
        String a = format2.format(Calendar.getInstance().getTime());
        final Calendar dat = Calendar.getInstance();

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(4000);
                    dat.set(Calendar.DAY_OF_MONTH, Calendar.DAY_OF_WEEK);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };thread.start();


        final String day = dat.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG, Locale.getDefault());
       //   String da = name.getText().toString();



        for(int i=0; i<30 ;i++)
        {
            // calendar1.add(Calendar.DATE,i);
            //  calendar1.get(Calendar.DATE);

            //Calendar[i]=sdf.format(date.getTime());
            days2[i]= m.format(dat.getTime());
            days3[i]= m2.format(dat.getTime());

            dat.add(Calendar.DATE,1);


        }
        if (arrayList.get(position).name.contains("Sat")) {

            for (int j = 0; j < 30; j++)
            {

//                if(arrayList.get(position).name.equals(day))
//                {
//                    name.setText("اليوم " + a);
//
//                }
               {
                    if (days2[j].contains("Sat")) {
                        day_accepet[j] = days3[j];
                        name2.setText(days3[j]);
                        day_accepet[j] = days2[j];
                        name.setText(days2[j]);
                        final String c = name2.getText().toString();
                        final String hoss = hos.getText().toString();
                        final String locc = loc.getText().toString();
                        final String depp = dep.getText().toString();
                        final String docc = doc.getText().toString();
                        final String picc = pic.getText().toString();
                        final String id_docc = id_doc.getText().toString();
                        final String id_picc = id_pic.getText().toString();
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(mcontext, Datee.class);
                                intent.putExtra("date", c);
                                intent.putExtra("hos",hoss);
                                intent.putExtra("loc",locc);
                                intent.putExtra("dep",depp);
                                intent.putExtra("doc",docc);
                                intent.putExtra("pic",picc);
                                intent.putExtra("id_pic",id_picc);
                                intent.putExtra("id_doc",id_docc);
                                mcontext.startActivity(intent);
                            }
                        });
                        break;
                    }
                }

            }
        }
        else if (arrayList.get(position).name.contains("Sun")) {

            for (int j = 0; j < 30; j++)
            {

//                if(arrayList.get(position).name.equals(day))
//                {
//                    name.setText("اليوم " + a);
//                }
                 if (days2[j].contains("Sun"))
                {
                    day_accepet[j] = days3[j];
                    name2.setText(days3[j]);
                    day_accepet[j] = days2[j];
                    name.setText(days2[j]);
                    final String c = name2.getText().toString();
                    final String hoss = hos.getText().toString();
                    final String locc = loc.getText().toString();
                    final String depp = dep.getText().toString();
                    final String docc = doc.getText().toString();
                    final String picc = pic.getText().toString();
                    final String id_docc = id_doc.getText().toString();
                    final String id_picc = id_pic.getText().toString();
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(mcontext, Datee.class);
                            intent.putExtra("date", c);
                            intent.putExtra("hos",hoss);
                            intent.putExtra("loc",locc);
                            intent.putExtra("dep",depp);
                            intent.putExtra("doc",docc);
                            intent.putExtra("pic",picc);
                            intent.putExtra("id_pic",id_picc);
                            intent.putExtra("id_doc",id_docc);
                            mcontext.startActivity(intent);
                        }
                    });

                    break;

                }


            }
        }
        else if (arrayList.get(position).name.contains("Mon")) {

            for (int j = 0; j < 30; j++)
            {


                if (days2[j].contains("Mon"))
                {
                    day_accepet[j] = days3[j];
                    name2.setText(days3[j]);
                    day_accepet[j] = days2[j];
                    name.setText(days2[j]);
                    final String c = name2.getText().toString();
                    final String hoss = hos.getText().toString();
                    final String locc = loc.getText().toString();
                    final String depp = dep.getText().toString();
                    final String docc = doc.getText().toString();
                    final String picc = pic.getText().toString();
                    final String id_docc = id_doc.getText().toString();
                    final String id_picc = id_pic.getText().toString();
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(mcontext, Datee.class);
                            intent.putExtra("date", c);
                            intent.putExtra("hos",hoss);
                            intent.putExtra("loc",locc);
                            intent.putExtra("dep",depp);
                            intent.putExtra("doc",docc);
                            intent.putExtra("pic",picc);
                            intent.putExtra("id_pic",id_picc);
                            intent.putExtra("id_doc",id_docc);
                            mcontext.startActivity(intent);
                        }
                    });
                    break;
                }


            }
        }
        else if (arrayList.get(position).name.contains("Tue")) {

            for (int j = 0; j < 30; j++)
            {

//                if(arrayList.get(position).name.equals("Tue"))
//                {
//                    name.setText("اليوم ");
//                }
               if (days2[j].contains("Tue"))
                {
                    day_accepet[j] = days3[j];
                    name2.setText(days3[j]);
                    day_accepet[j] = days2[j];
                    name.setText(days2[j]);
                    final String c = name2.getText().toString();
                    final String hoss = hos.getText().toString();
                    final String locc = loc.getText().toString();
                    final String depp = dep.getText().toString();
                    final String docc = doc.getText().toString();
                    final String picc = pic.getText().toString();
                    final String id_docc = id_doc.getText().toString();
                    final String id_picc = id_pic.getText().toString();
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(mcontext, Datee.class);
                            intent.putExtra("date", c);
                            intent.putExtra("hos",hoss);
                            intent.putExtra("loc",locc);
                            intent.putExtra("dep",depp);
                            intent.putExtra("doc",docc);
                            intent.putExtra("pic",picc);
                            intent.putExtra("id_pic",id_picc);
                            intent.putExtra("id_doc",id_docc);
                            mcontext.startActivity(intent);
                        }
                    });
                    break;
                }


            }
        }
        else if (arrayList.get(position).name.contains("Wed"))
        {

            for (int j = 0; j < 30; j++)
            {

//                if(arrayList.get(position).name.equals("Tue"))
//                {
//                    name.setText("اليوم ");
//                }
 if (days2[j].contains("Wed"))
                {
                    day_accepet[j] = days3[j];
                    name2.setText(days3[j]);
                    day_accepet[j] = days2[j];
                    name.setText(days2[j]);
                    final String c = name2.getText().toString();
                    final String hoss = hos.getText().toString();
                    final String locc = loc.getText().toString();
                    final String depp = dep.getText().toString();
                    final String docc = doc.getText().toString();
                    final String picc = pic.getText().toString();
                    final String id_docc = id_doc.getText().toString();
                    final String id_picc = id_pic.getText().toString();
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(mcontext, Datee.class);
                            intent.putExtra("date", c);
                            intent.putExtra("hos",hoss);
                            intent.putExtra("loc",locc);
                            intent.putExtra("dep",depp);
                            intent.putExtra("doc",docc);
                            intent.putExtra("pic",picc);
                            intent.putExtra("id_pic",id_picc);
                            intent.putExtra("id_doc",id_docc);
                            mcontext.startActivity(intent);
                        }
                    });
                    break;
                }


            }
        }
        else if (arrayList.get(position).name.contains("Thu"))
        {

            for (int j = 0; j < 30; j++)
            {

//                if(arrayList.get(position).name.equals(day))
//                {
//                    name.setText("اليوم" + a);
//                }
  if (days2[j].contains("Thu"))
                {
                    day_accepet[j] = days3[j];
                    name2.setText(days3[j]);
                    day_accepet[j] = days2[j];
                    name.setText(days2[j]);
                    final String c = name2.getText().toString();
                    final String hoss = hos.getText().toString();
                    final String locc = loc.getText().toString();
                    final String depp = dep.getText().toString();
                    final String docc = doc.getText().toString();
                    final String picc = pic.getText().toString();
                    final String id_docc = id_doc.getText().toString();
                    final String id_picc = id_pic.getText().toString();
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(mcontext, Datee.class);
                            intent.putExtra("date", c);
                            intent.putExtra("hos",hoss);
                            intent.putExtra("loc",locc);
                            intent.putExtra("dep",depp);
                            intent.putExtra("doc",docc);
                            intent.putExtra("pic",picc);
                            intent.putExtra("id_pic",id_picc);
                            intent.putExtra("id_doc",id_docc);
                            mcontext.startActivity(intent);
                        }
                    });
                    break;
                }

            }
        }
        else if (arrayList.get(position).name.contains("Fri"))
        {

            for (int j = 0; j < 30; j++)
            {

//                if(arrayList.get(position).name.equals(day))
//                {
//                    name.setText("اليوم" + a);
//                }
                if (days2[j].contains("Fri"))
                {
                    day_accepet[j] = days3[j];
                    name2.setText(days3[j]);
                    day_accepet[j] = days2[j];
                    name.setText(days2[j]);
                    final String c = name2.getText().toString();
                    final String hoss = hos.getText().toString();
                    final String locc = loc.getText().toString();
                    final String depp = dep.getText().toString();
                    final String docc = doc.getText().toString();
                    final String picc = pic.getText().toString();
                    final String id_docc = id_doc.getText().toString();
                    final String id_picc = id_pic.getText().toString();
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(mcontext, Datee.class);
                            intent.putExtra("date", c);
                            intent.putExtra("hos",hoss);
                            intent.putExtra("loc",locc);
                            intent.putExtra("dep",depp);
                            intent.putExtra("doc",docc);
                            intent.putExtra("pic",picc);
                            intent.putExtra("id_pic",id_picc);
                            intent.putExtra("id_doc",id_docc);
                            mcontext.startActivity(intent);
                        }
                    });
                    break;
                }

            }
        }




    }



    @Override
    public int getItemCount()
    {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name,name2,frommn,too,hos,loc,dep,doc,pic,id_doc,id_pic;
       // ImageView image;


        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.name);
            name2 = (TextView)itemView.findViewById(R.id.name2);
            frommn =(TextView)itemView.findViewById(R.id.ffrom);
            too =(TextView)itemView.findViewById(R.id.too);
            hos =(TextView)itemView.findViewById(R.id.hos);
            loc =(TextView)itemView.findViewById(R.id.loc);
            dep =(TextView)itemView.findViewById(R.id.dep);
            doc =(TextView)itemView.findViewById(R.id.doc);
            pic =(TextView)itemView.findViewById(R.id.pic);
            id_doc =(TextView)itemView.findViewById(R.id.id_doc);
            id_pic =(TextView)itemView.findViewById(R.id.id_pic);
          //  image =(ImageView) itemView.findViewById(R.id.img);


        }


    }
}
