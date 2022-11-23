package com.example.apptestfirebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import me.relex.circleindicator.CircleIndicator;

public class MyFavoritePage extends AppCompatActivity {


    private ImageView btnMenu, btnProfile, btnHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_favorite_page);

        btnHome = (ImageView) findViewById(R.id.imgHomeP);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyFavoritePage.this, HomePage.class);
                startActivity(intent);
            }
        });
        btnMenu = (ImageView) findViewById(R.id.imgMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyFavoritePage.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnProfile = (ImageView) findViewById(R.id.img_Profile);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyFavoritePage.this, ProfilePage.class);
                startActivity(intent);
            }
        });
    }

}