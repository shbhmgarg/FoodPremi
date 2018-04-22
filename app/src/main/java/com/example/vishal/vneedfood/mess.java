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

public class mess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mess);

        String[] hotels={"Punjabi Rasoi","Anand","Mumbai Darbar "," "," "," "," "," ", " "," "," "," "," "," "," "," "," "," "," "," "};
        ListAdapter vishalAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,hotels);
        ListView hotelname=(ListView) findViewById(R.id.hotelname);
        hotelname.setAdapter(vishalAdapter);

        hotelname.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String hotelname=String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(mess.this,hotelname,Toast.LENGTH_LONG).show();

                        if(position==0)
                        {
                            Intent intent=new Intent(mess.this,Messfood.class);
                            startActivity(intent);
                        }
                    }
                }
        );

    }
}
