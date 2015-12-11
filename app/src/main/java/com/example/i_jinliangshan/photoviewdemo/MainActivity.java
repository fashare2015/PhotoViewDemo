package com.example.i_jinliangshan.photoviewdemo;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.bm.library.Info;
import com.bm.library.PhotoView;


public class MainActivity extends Activity {
    private PhotoView imgSmall, imgBig;
    private Info imgSmallInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        imgSmall = (PhotoView) findViewById(R.id.img_small);
        imgBig = (PhotoView) findViewById(R.id.img_full);
        imgSmallInfo = imgSmall.getInfo();

        imgSmall.disenable();
        imgSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImgBig();
            }
        });

        imgBig.enable();
        imgBig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImgSmall();
            }
        });

    }

    @Override
    public void onBackPressed() {
        if(imgBig.getVisibility() == View.VISIBLE)
            showImgSmall();
        else
            super.onBackPressed();
    }

    private void showImgSmall(){
        imgBig.animaTo(imgSmallInfo, new Runnable() {
            @Override
            public void run() {     //Runnable???
                imgBig.setVisibility(View.GONE);
                imgSmall.setVisibility(View.VISIBLE);
            }
        });
    }

    private void showImgBig(){
        imgSmall.setVisibility(View.GONE);
        imgBig.setVisibility(View.VISIBLE);

        imgBig.animaFrom(imgSmallInfo);
    }

}
