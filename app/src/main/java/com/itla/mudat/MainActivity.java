package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itla.mudat.view.RegUserActivity;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private Button save;
    private Button nextRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.name = findViewById(R.id.txtNombre);
        this.save = findViewById(R.id.btnGuardar);
        this.nextRegister = findViewById(R.id.btnRegister);
        this.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast message = Toast.makeText(MainActivity.this, "Hola " + MainActivity.this.name.getText(), Toast.LENGTH_LONG);
//                message.show();
                Intent visualizar = new Intent(MainActivity.this, Visualizar.class);
                Bundle parametros = new Bundle();
                parametros.putString("name", MainActivity.this.name.getText().toString());
                visualizar.putExtras(parametros);
//                parametros
                startActivity(visualizar);
            }
        });

        this.nextRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast message = Toast.makeText(MainActivity.this, "Hola " + MainActivity.this.name.getText(), Toast.LENGTH_LONG);
//                message.show();
                Intent viewRegisterUser = new Intent(MainActivity.this, RegUserActivity.class);


//                parametros
                startActivity(viewRegisterUser);
            }
        });
    }


}
