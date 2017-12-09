package com.itla.mudat.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.itla.mudat.R;

public class BannerActivity extends AppCompatActivity {

    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        this.btnAdd = findViewById(R.id.btnAddBanner);

        this.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewReg = new Intent(BannerActivity.this, RegBannerActivity.class);
                startActivity(viewReg);
            }
        });
    }
}
