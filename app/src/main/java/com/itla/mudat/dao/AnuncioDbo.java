package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itla.mudat.entity.Anuncio;
import com.itla.mudat.entity.Categoria;
import com.itla.mudat.entity.TipoUsuario;
import com.itla.mudat.entity.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gerónimo Díaz on 25/11/2017.
 */

public class AnuncioDbo {
    private DbConnection connection;

    public AnuncioDbo(Context context) {
        this.connection = new DbConnection(context);
    }

    /**
     * Insert Usuarios
     *
     * @param usuario
     */
    public void crear(Anuncio anuncio) {
        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("id_categoria", anuncio.getCategoria().getId());
        cv.put("id_usuario", anuncio.getUsuario().getId());
        cv.put("fecha", anuncio.getFecha().toString());
        cv.put("condicion", anuncio.getCondicion());
        cv.put("precio", anuncio.getPrecio());
        cv.put("titulo", anuncio.getTitulo());
        cv.put("ubicacion", anuncio.getUbicacion());
        cv.put("detalle", anuncio.getDetalle());


        db.insert("anuncio", null, cv);
        db.close();
    }

    public List<Anuncio> buscar() {
        List<Anuncio> anuncio = new ArrayList<>();
        SQLiteDatabase db = connection.getReadableDatabase();
        String columnas[] = new String[]{"id", "id_categoria", "id_usuario", "fecha", "condicion", "precio", "titulo", "ubicacion", "detalle"};
        Cursor cursor = db.query("usuario", columnas, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Anuncio a = new Anuncio();
            a.setId(cursor.getInt(cursor.getColumnIndex("id")));
//            a.setCategoria( cursor.getString(cursor.getColumnIndex("id_categoria")));

//            a.setEmail(cursor.getString(cursor.getColumnIndex("email")));
//            a.setTipoUsuario(TipoUsuario.valueOf(cursor.getString(cursor.getColumnIndex("tipo_usuario"))));
            cursor.moveToNext();
            anuncio.add(a);
        }
        cursor.close();
        return anuncio;
    }
}
