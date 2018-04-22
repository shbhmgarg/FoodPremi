package com.example.vishal.vneedfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class description extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        TextView view1=(TextView) findViewById(R.id.description);
        TextView view2=(TextView) findViewById(R.id.description1);
        Button bContinue=(Button) findViewById(R.id.bContinue);

        bContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(description.this, CoverActivity.class);
                description.this.startActivity(registerIntent);
            }
        });
    }
}
