package com.example.vishal.vneedfood;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Amigos extends AppCompatActivity {
    Intent intent;
    private static final int REQUEST_CALL=1;
    CustomPagerAdapter1 mCustomPagerAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amigos);
        mCustomPagerAdapter = new CustomPagerAdapter1(this);

        mViewPager = (ViewPager) findViewById(R.id.view_pager1);
        mViewPager.setAdapter(mCustomPagerAdapter);

        Button button = (Button) findViewById(R.id.button3);
        TextView txt=(TextView) findViewById(R.id.textView7);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9960134452"));
                if (ContextCompat.checkSelfPermission(Amigos.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                   ActivityCompat.requestPermissions(Amigos.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
                }
                startActivity(intent);
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CALL:
            {
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    startActivity(intent);
                }
                else
                {
                    ////
                }
            }
        }
    }
}
