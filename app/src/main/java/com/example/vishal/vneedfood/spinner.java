/*package com.example.vishal.vneedfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class spinner extends AppCompatActivity {

    Spinner spinner;
    String[] SPINNERVALUES = {"BVP","SINGHAD","MIT"};
    String SpinnerValue;
    Button GOTO;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);



            spinner =(Spinner)findViewById(R.id.spinner1);

            GOTO = (Button)findViewById(R.id.button1);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(spinner.this,android.R.layout.simple_list_item_1,SPINNERVALUES);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(adapter);

            //Adding setOnItemSelectedListener method on spinner.
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {

                   SpinnerValue = (String)spinner.getSelectedItem();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub

                }
            });

            GOTO.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    switch(SpinnerValue) {

                        case "BVP":
                          intent = new Intent(spinner.this, Chinese.class);
                            startActivity(intent);
                            break;

                        case "SINGHAD":
                            intent = new Intent(spinner.this, blank.class);
                            startActivity(intent);
                            break;

                        case "MIT":
                            intent = new Intent(spinner.this, blank.class);
                            startActivity(intent);
                            break;
                    }
                }
            });

        }
    }


*/
