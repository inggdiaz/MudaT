package com.itla.mudat.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.itla.mudat.R;

public class RegUserActivity extends AppCompatActivity {

    private EditText name;
    private EditText identificacion;
    private EditText email;
    private EditText phone;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.name = findViewById(R.id.txtNombre);
        this.identificacion = findViewById(R.id.txtIdentification);
        this.email = findViewById(R.id.txtEmail);
        this.phone = findViewById(R.id.txtPhone);
        this.password = findViewById(R.id.txtPassword);

    }

}
