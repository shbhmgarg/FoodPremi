package com.example.vishal.vneedfood;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.StringSignature;
import com.squareup.picasso.MemoryPolicy;

import uk.co.senab.photoview.PhotoViewAttacher;

public class Messfood extends AppCompatActivity {

    Intent intent;
    private static final int REQUEST_CALL=1;
    PhotoViewAttacher mphoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messfood);

        ImageView mess1 = (ImageView) findViewById(R.id.imageView3);
        Button button1 = (Button) findViewById(R.id.button1);
        TextView tv=(TextView) findViewById(R.id.tv);

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress6);

        Glide.with(Messfood.this)
                .load("http://vneedfood.esy.es/punjabi.png")
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .signature(new StringSignature(String.valueOf(System.currentTimeMillis())))
                .into(mess1);
        mphoto = new PhotoViewAttacher(mess1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9960134452"));
                if (ContextCompat.checkSelfPermission(Messfood.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Messfood.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
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
