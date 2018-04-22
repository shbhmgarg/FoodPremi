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

public class Chinese extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese);

        String[] hotels={"SKY TOUCH","CHINESE ROOM","AMIGOS","CAFE MOMIEOS","MUMBAI DARBAR"," "," "," "," "," "," "," "," "};
        ListAdapter vishalAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,hotels);
        ListView hotelname=(ListView) findViewById(R.id.hotelname);
        hotelname.setAdapter(vishalAdapter);

        hotelname.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String hotelname=String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(Chinese.this,hotelname,Toast.LENGTH_LONG).show();

                        if(position==0)
                        {
                            Intent intent=new Intent(Chinese.this,menu.class);
                            startActivity(intent);
                        }

                        if(position==1)
                        {
                            Intent intent=new Intent(Chinese.this,Chineseroom.class);
                            startActivity(intent);
                        }

                        if(position==2)
                        {
                            Intent intent=new Intent(Chinese.this,Amigos.class);
                            startActivity(intent);
                        }

                        if(position==3)
                        {
                            Intent intent=new Intent(Chinese.this,Cafemomieos.class);
                            startActivity(intent);
                        }

                        if(position==4)
                        {
                            Intent intent=new Intent(Chinese.this,Mumbaidarbar.class);
                            startActivity(intent);
                        }


                    }
                }
        );

    }
}
