package com.itla.mudat.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
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
import com.itla.mudat.UserListActivity;
import com.itla.mudat.dao.UsuarioDbo;
import com.itla.mudat.entity.TipoUsuario;
import com.itla.mudat.entity.Usuario;

import java.util.ArrayList;
import java.util.List;

public class RegUserActivity extends BaseActivity {

    final private String LOG_T = "Registro De Usuario";
    UsuarioDbo u;
    private EditText name;
    private EditText identificacion;
    private EditText email;
    private EditText phone;
    private EditText password;
    private Button btnSaveRegister;
    private Button btnSearchUser;
    private Usuario usuario;
    private Integer id;

    public RegUserActivity() {
        this.id = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle params = getIntent().getExtras();

        this.name = findViewById(R.id.txtName);
        this.identificacion = findViewById(R.id.txtIdentification);
        this.email = findViewById(R.id.txtEmail);
        this.phone = findViewById(R.id.txtPhone);
        this.password = findViewById(R.id.txtPassword);
        this.btnSaveRegister = findViewById(R.id.btnGuardar);
        this.btnSearchUser = findViewById(R.id.btnSearchUser);

        if (params != null && params.containsKey("user")) {
            this.fillFields(params);
        }

        this.u = new UsuarioDbo(this);


        this.btnSaveRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = "The User was Updated";
                Usuario usuario = new Usuario();
                if (RegUserActivity.this.usuario == null) {
                    RegUserActivity.this.usuario = new Usuario();
                    msg = "The user was created";
                } else {
                    usuario.setId(RegUserActivity.this.id);
                }


                usuario.setNombre(RegUserActivity.this.name.getText().toString());
                usuario.setIdentificacion(RegUserActivity.this.identificacion.getText().toString());
                usuario.setEmail(RegUserActivity.this.email.getText().toString());
                usuario.setTelefonos(RegUserActivity.this.phone.getText().toString());
                usuario.setClave(RegUserActivity.this.password.getText().toString());
                usuario.setTipoUsuario(TipoUsuario.CLIENTE);
//                usuario.setEstatus(true);
                System.out.println(usuario.toString());

                RegUserActivity.this.u.crear(usuario);

                Toast message = Toast.makeText(RegUserActivity.this, msg, Toast.LENGTH_SHORT);
                message.show();
//                Log.i("")
//                Toast.makeText(RegUserActivity.this, usuario.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        this.btnSearchUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Usuario u = new Usuario();
//                List<Usuario> usuarios = new ArrayList<>();
//                usuarios = RegUserActivity.this.u.buscar();
//                Log.i("Usuario:", usuarios.toString());

                Intent viewUser = new Intent(RegUserActivity.this, UserListActivity.class);
                startActivity(viewUser);
//                Toast.makeText(RegUserActivity.this, usuario.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    /**
     * @param params
     */
    public void fillFields(Bundle params) {
        this.usuario = (Usuario) params.getSerializable("user");
        this.name.setText(this.usuario.getNombre());
        this.id = this.usuario.getId();
        this.email.setText(this.usuario.getEmail());
        this.phone.setText(this.usuario.getTelefonos());
        this.identificacion.setText(this.usuario.getIdentificacion());
        this.password.setText(this.usuario.getClave());

    }

}
