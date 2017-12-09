package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.itla.mudat.Adapters.UserList;
import com.itla.mudat.dao.UsuarioDbo;
import com.itla.mudat.entity.Usuario;
import com.itla.mudat.view.RegUserActivity;

import java.util.List;

public class UserListActivity extends AppCompatActivity {
    private Button btnAddUser;
    private ListView userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        this.btnAddUser = findViewById(R.id.btnAddUser);
        this.userList = findViewById(R.id.userViewList);

        UsuarioDbo usuarioDbo = new UsuarioDbo(this);
        List<Usuario> usuarioList = usuarioDbo.buscar();
        Log.i("Usuario:", usuarioList.toString());
        userList.setAdapter(new UserList(usuarioList, this));

        this.btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewRegisterUser = new Intent(UserListActivity.this, RegUserActivity.class);
                startActivity(viewRegisterUser);
            }
        });

        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent viewer = new Intent(UserListActivity.this, RegUserActivity.class);
                Usuario usuario = (Usuario) userList.getItemAtPosition(i);
                Bundle bundle = new Bundle();
                bundle.putSerializable("user", usuario);
                viewer.putExtras(bundle);
                startActivity(viewer);
            }
        });

    }

}
