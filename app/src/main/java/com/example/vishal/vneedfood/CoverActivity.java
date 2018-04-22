package com.example.vishal.vneedfood;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.squareup.picasso.Picasso;

public class CoverActivity extends AppCompatActivity {
    Intent intent;
    String SpinnerValue;
    public String chi,ind,mes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);

        chi= "http://vneedfood.esy.es/chinese.jpg";
        ind = "http://vneedfood.esy.es/indian2.jpg";
        mes = "http://vneedfood.esy.es/mess1.jpg";


        ImageButton chinese=(ImageButton) findViewById(R.id.image1);
        ImageButton indian=(ImageButton) findViewById(R.id.image2);
        ImageButton mess=(ImageButton) findViewById(R.id.image3);
        Picasso.with(this).load(chi).fit().into(chinese);
        Picasso.with(this).load(ind).fit().into(indian);
        Picasso.with(this).load(mes).fit().into(mess);
        chinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(CoverActivity.this);
                View mView= getLayoutInflater().inflate(R.layout.chi_spinner,null);
                dialog.setTitle("SELECT YOUR COLLEGE");
                final Spinner spinner1=(Spinner) mView.findViewById(R.id.spinner1);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(CoverActivity.this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.Colleges));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(adapter);

                //Adding setOnItemSelectedListener method on spinner.
                spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {

                        SpinnerValue = (String)spinner1.getSelectedItem();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // TODO Auto-generated method stub

                    }
                });

                dialog.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch(SpinnerValue) {

                            case "BVP":
                                intent = new Intent(CoverActivity.this, Chinese.class);
                                startActivity(intent);
                                break;

                            case "SINGHAD":
                                intent = new Intent(CoverActivity.this, blank.class);
                                startActivity(intent);
                                break;

                            case "MIT":
                                intent = new Intent(CoverActivity.this, blank.class);
                                startActivity(intent);
                                break;
                        }
                    }
                });

                dialog.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                dialog.setView(mView);
                AlertDialog dialog1=dialog.create();
                dialog1.show();
            }
        });

        indian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(CoverActivity.this);
                View mView= getLayoutInflater().inflate(R.layout.ind_spinner,null);
                dialog.setTitle("SELECT YOUR COLLEGE");
                final Spinner spinner1=(Spinner) mView.findViewById(R.id.spinner2);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(CoverActivity.this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.Colleges));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(adapter);

                //Adding setOnItemSelectedListener method on spinner.
                spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {

                        SpinnerValue = (String)spinner1.getSelectedItem();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // TODO Auto-generated method stub

                    }
                });

                dialog.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch(SpinnerValue) {

                            case "BVP":
                                intent = new Intent(CoverActivity.this, Indianfood.class);
                                startActivity(intent);
                                break;

                            case "SINGHAD":
                                intent = new Intent(CoverActivity.this, blank.class);
                                startActivity(intent);
                                break;

                            case "MIT":
                                intent = new Intent(CoverActivity.this, blank.class);
                                startActivity(intent);
                                break;
                        }
                    }
                });

                dialog.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                dialog.setView(mView);
                AlertDialog dialog1=dialog.create();
                dialog1.show();
            }
        });


        mess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(CoverActivity.this);
                View mView= getLayoutInflater().inflate(R.layout.mess_spinner,null);
                dialog.setTitle("SELECT YOUR COLLEGE");
                final Spinner spinner1=(Spinner) mView.findViewById(R.id.spinner3);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(CoverActivity.this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.Colleges));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(adapter);

                //Adding setOnItemSelectedListener method on spinner.
                spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {

                        SpinnerValue = (String)spinner1.getSelectedItem();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // TODO Auto-generated method stub

                    }
                });

                dialog.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch(SpinnerValue) {

                            case "BVP":
                                intent = new Intent(CoverActivity.this, mess.class);
                                startActivity(intent);
                                break;

                            case "SINGHAD":
                                intent = new Intent(CoverActivity.this, blank.class);
                                startActivity(intent);
                                break;

                            case "MIT":
                                intent = new Intent(CoverActivity.this, blank.class);
                                startActivity(intent);
                                break;
                        }
                    }
                });

                dialog.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                dialog.setView(mView);
                AlertDialog dialog1=dialog.create();
                dialog1.show();
            }
        });
    }
}
