package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itla.mudat.entity.TipoUsuario;
import com.itla.mudat.entity.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gerónimo Díaz on 25/11/2017.
 */

public class UsuarioDbo {
    private DbConnection connection;

    public UsuarioDbo(Context context) {
        this.connection = new DbConnection(context);
    }

    /**
     * Insert Usuarios
     *
     * @param usuario
     */
    public void crear(Usuario usuario) {
        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues cv = new ContentValues();
        System.out.println(usuario.toString());
//        cv.put("id", "1");
        cv.put("nombre", usuario.getNombre());
        cv.put("tipo_usuario", usuario.getTipoUsuario().toString());
        cv.put("identificacion", usuario.getIdentificacion());
        cv.put("email", usuario.getEmail());
        cv.put("telefonos", usuario.getTelefonos());
        cv.put("clave", usuario.getClave());
        cv.put("status", 1);

        db.insert("usuario", null, cv);
        db.close();
    }

    public List<Usuario> buscar() {
        List<Usuario> usuarios = new ArrayList<>();
        SQLiteDatabase db = connection.getReadableDatabase();
        String columnas[] = new String[]{"id", "nombre", "email", "tipo_usuario"};
        Cursor cursor = db.query("usuario", columnas, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Usuario u = new Usuario();
            u.setId(cursor.getInt(cursor.getColumnIndex("id")));
            u.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            u.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            u.setTipoUsuario(TipoUsuario.valueOf(cursor.getString(cursor.getColumnIndex("tipo_usuario"))));
            cursor.moveToNext();
            usuarios.add(u);
        }
        cursor.close();
        return usuarios;
    }
}
