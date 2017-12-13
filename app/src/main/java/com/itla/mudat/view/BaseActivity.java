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

public abstract class BaseActivity extends AppCompatActivity {

    private Button btnHome;

    public BaseActivity() {
        System.out.println("Base LOL");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_footer);
        this.btnHome = findViewById(R.id.btnHome);

        this.btnHome.setOnClickListener(new View.OnClickListener() {
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
