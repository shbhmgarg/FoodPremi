package com.example.vishal.vneedfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Indianfood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indianfood);

        String[] hotels={"KATTHI KABAB","HOTEL SR","CHARUNG"," "," "," "," "," "," "," "," "};
        ListAdapter vishalAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,hotels);
        ListView hotelname=(ListView) findViewById(R.id.hotelname1);
        hotelname.setAdapter(vishalAdapter);

        hotelname.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String hotelname=String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(Indianfood.this,hotelname,Toast.LENGTH_LONG).show();

                        if(position==0)
                        {
                            Intent intent=new Intent(Indianfood.this,Katthi.class);
                            startActivity(intent);
                        }

                        if(position==1)
                        {
                            Intent intent=new Intent(Indianfood.this,HotelSR.class);
                            startActivity(intent);
                        }

                        if(position==2)
                        {
                            Intent intent=new Intent(Indianfood.this,Charung.class);
                            startActivity(intent);
                        }

                    }
                }
        );




    }
}
