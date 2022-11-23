package com.example.apptestfirebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText edtSearch;
    private ImageView btn_Search;
    private String txtSearch;
    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;

    private ImageView btnBackHome, btnHome, btnProfile, btnFavorite;

    private FloatingActionButton flbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<MainModel> options =
            new FirebaseRecyclerOptions.Builder<MainModel>()
                    .setQuery(FirebaseDatabase.getInstance().getReference().child("teachers"), MainModel.class)
                    .build();
        mainAdapter = new MainAdapter(options);
        recyclerView.setAdapter(mainAdapter);


        flbtn = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        flbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        btn_Search = (ImageView) findViewById(R.id.btnSearch);
        edtSearch = (TextInputEditText) findViewById(R.id.ipSearch);
        btn_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtSearch = edtSearch.getText().toString();
                SearchName(txtSearch);
            }
        });
            // intent homepage
            btnBackHome = (ImageView) findViewById(R.id.imgBackHome);
            btnBackHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    startActivity(intent);
                }
            });
            // intent Hompage back
            btnHome = (ImageView) findViewById(R.id.imgHomeP);
            btnHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    startActivity(intent);
                }
            });
            // intent profilepage
            btnProfile = (ImageView) findViewById(R.id.img_Profile);
            btnProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, ProfilePage.class);
                    startActivity(intent);
                }
            });
            // intent MyfavoritePage
            btnFavorite = (ImageView) findViewById(R.id.img_Favorite);
            btnFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, MyFavoritePage.class);
                    startActivity(intent);
                }
            });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mainAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapter.stopListening();
    }

    private void SearchName(String txtStr) {
        Toast.makeText(this, "Started Search", Toast.LENGTH_SHORT).show();
        FirebaseRecyclerOptions<MainModel> options =
                new FirebaseRecyclerOptions.Builder<MainModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("teachers").orderByChild("name").startAt(txtStr).endAt(txtStr + "\uf8ff"),MainModel.class )
                        .build();
        mainAdapter = new MainAdapter(options);
        mainAdapter.startListening();
        recyclerView.setAdapter(mainAdapter);
    }


}