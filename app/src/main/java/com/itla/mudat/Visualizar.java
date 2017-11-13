package com.itla.mudat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Visualizar extends AppCompatActivity {

    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);
        this.name = findViewById(R.id.txtNombre1);

        Bundle parametros = new Bundle();
        parametros = getIntent().getExtras();
        String nam = parametros.getString("name");
        this.name.setText(nam);
        //                Toast message = Toast.makeText(MainActivity.this, "Hola " + MainActivity.this.name.getText(), Toast.LENGTH_LONG);
//                message.show();
//        getIntent().get
    }
}
