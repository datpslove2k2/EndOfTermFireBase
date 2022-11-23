package com.example.apptestfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.badge.BadgeUtils;

public class ProfilePage extends AppCompatActivity {
    private ImageView btnBackHome, btnBackHomeMenu, btnMenu, btnFavorite;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        btnBackHome = (ImageView) findViewById(R.id.img_Back_Home);
        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilePage.this, HomePage.class);
                startActivity(intent);
            }
        });
        btnLogout = (Button) findViewById(R.id.btnBack_login);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilePage.this, LoginPage.class);
                startActivity(intent);
            }
        });
        btnBackHomeMenu = (ImageView) findViewById(R.id.imgHomeP);
        btnBackHomeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilePage.this, HomePage.class);
                startActivity(intent);
            }
        });
        btnMenu = (ImageView) findViewById(R.id.imgMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilePage.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnFavorite = (ImageView) findViewById(R.id.img_Favorite);
        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilePage.this, MyFavoritePage.class);
                startActivity(intent);
            }
        });
    }
}