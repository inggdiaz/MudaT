package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itla.mudat.entity.Anuncio;
import com.itla.mudat.entity.Categoria;
import com.itla.mudat.entity.Fotos;
import com.itla.mudat.entity.Usuario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gerónimo Díaz on 25/11/2017.
 */

public class FotoDbo {
    private DbConnection connection;
    private Context context;

    public FotoDbo(Context context) {
        this.connection = new DbConnection(context);
        this.context = context;
    }

    /**
     * Insert Usuarios
     *
     * @param fotos
     */
    public void crear(Fotos fotos) {
        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("id_anuncio", fotos.getAnuncio().getId());
        cv.put("image", fotos.getImage());
        cv.put("status", fotos.getEstatus());

        db.insert("fotos", null, cv);
        db.close();
    }

    /**
     * @return List
     */
    public List<Fotos> buscar() {
        List<Fotos> fotos = new ArrayList<>();
        SQLiteDatabase db = connection.getReadableDatabase();
        String columnas[] = new String[]{"id", "id_anuncio", "image", "status"};
        Cursor cursor = db.query("fotos", columnas, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Fotos a = new Fotos();

            Anuncio anuncio = new Anuncio();

            Integer idAnuncio = cursor.getInt(cursor.getColumnIndex("id_anuncio"));
            anuncio = (new AnuncioDbo(this.context).buscarId(idAnuncio));

            a.setId(cursor.getInt(cursor.getColumnIndex("id")));
            a.setImage(cursor.getString(cursor.getColumnIndex("image")));
            a.setAnuncio(anuncio);
            a.setEstatus(Boolean.parseBoolean(String.valueOf(cursor.getInt(cursor.getColumnIndex("status")))));


            cursor.moveToNext();
            fotos.add(a);
        }
        cursor.close();
        return fotos;
    }


}
