package com.itla.mudat.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.itla.mudat.MainActivity;
import com.itla.mudat.R;

/**
 * Created by Gerónimo Díaz on 12/12/2017.
 */

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_footer);
        Button btnHome = findViewById(R.id.btnHome);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Base LOL aaas");
                System.out.println("view = [" + view + "]");
                Intent viewHome = new Intent(BaseActivity.this, MainActivity.class);
                startActivity(viewHome);
            }
        });
    }
}
