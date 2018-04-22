package com.example.vishal.vneedfood;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by vishal on 2/1/2017.
 */
class   CustomPagerAdapter5 extends PagerAdapter {

    /*  int[] mResources = {
              R.drawable.sr3
              R.drawable.sr4,
              R.drawable.sr5
      };*/
    String[] url5={"http://vneedfood.esy.es/ch1.jpg","http://vneedfood.esy.es/ch2.jpg","http://vneedfood.esy.es/ch3.jpg","http://vneedfood.esy.es/ch4.jpg","http://vneedfood.esy.es/ch5.jpg"};

    Context mContext;
    LayoutInflater mLayoutInflater;
    PhotoViewAttacher mphoto6;

    public CustomPagerAdapter5(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return url5.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.chswipe, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.charung);
       /* imageView.setImageResource(mResources[position]);*/
        final ProgressBar progressBar = (ProgressBar) itemView.findViewById(R.id.pg);

        Glide.with(mContext)
                .load(url5[position])
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
                .into(imageView);
        mphoto6 = new PhotoViewAttacher(imageView);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}