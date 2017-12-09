package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itla.mudat.view.BannerActivity;
import com.itla.mudat.view.CategoryListActivity;
import com.itla.mudat.view.RegUserActivity;

public class MainActivity extends AppCompatActivity {


    private Button btnUsers;
    private Button btnCategory;
    private Button btnBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnUsers = findViewById(R.id.btnUsers);
        this.btnCategory = findViewById(R.id.btnCategory);
        this.btnBanner = findViewById(R.id.btnBanner);

        this.btnUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewUsers = new Intent(MainActivity.this, UserListActivity.class);
                startActivity(viewUsers);
            }
        });

        this.btnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewCategoryList = new Intent(MainActivity.this, CategoryListActivity.class);
                startActivity(viewCategoryList);
            }
        });

        this.btnBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewBanner = new Intent(MainActivity.this, BannerActivity.class);
                startActivity(viewBanner);
            }
        });

    }


}
