package com.itla.mudat.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itla.mudat.R;
import com.itla.mudat.entity.TipoUsuario;
import com.itla.mudat.entity.Usuario;

public class RegUserActivity extends AppCompatActivity {

    private EditText name;
    private EditText identificacion;
    private EditText email;
    private EditText phone;
    private EditText password;
    private Button btnSaveRegister;

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
        this.btnSaveRegister = findViewById(R.id.btnGuardar);



        this.btnSaveRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario = new Usuario();
                usuario.setNombre(RegUserActivity.this.name.getText().toString());
                usuario.setIdentificacion(RegUserActivity.this.identificacion.getText().toString());
                usuario.setEmail(RegUserActivity.this.email.getText().toString());
                usuario.setTelefonos(RegUserActivity.this.phone.getText().toString());
                usuario.setClave(RegUserActivity.this.password.getText().toString());
                usuario.setTipoUsuario(TipoUsuario.CLIENTE);
//                Log.i("")
                Toast.makeText(RegUserActivity.this, usuario.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
