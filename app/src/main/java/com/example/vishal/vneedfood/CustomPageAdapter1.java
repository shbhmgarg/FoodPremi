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
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by vishal on 2/1/2017.
 */
class CustomPagerAdapter1 extends PagerAdapter {

 /*   int[] mResources = {
            R.drawable.amigos1,
            R.drawable.amigos2,
            R.drawable.amigos3
    };*/

    String[] url1 = {"http://vneedfood.esy.es/amigos1.jpg","http://vneedfood.esy.es/amigos2.jpg","http://vneedfood.esy.es/amigos3.jpg"};
    Context mContext;
    LayoutInflater mLayoutInflater;
    PhotoViewAttacher mphoto2;

    public CustomPagerAdapter1(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return url1.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.amigoswipe, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.amigos);
        /*imageView.setImageResource(mResources[position]);*/
        Picasso.with(mContext).load(url1[position]).fit().into(imageView);
        mphoto2 = new PhotoViewAttacher(imageView);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}