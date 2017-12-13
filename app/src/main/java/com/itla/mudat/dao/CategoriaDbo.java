package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itla.mudat.entity.Categoria;
import com.itla.mudat.entity.TipoUsuario;
import com.itla.mudat.entity.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gerónimo Díaz on 25/11/2017.
 */

public class CategoriaDbo {
    private DbConnection connection;

    public CategoriaDbo(Context context) {
        this.connection = new DbConnection(context);
    }

    /**
     * Insert categoria
     *
     * @param categoria
     */
    public void crear(Categoria categoria) {
        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name", categoria.getName());

        if (categoria.getId() != null) {
            db.update("categoria", cv, "id = ?", new String[]{String.valueOf(categoria.getId())});
        } else {
            db.insert("categoria", null, cv);
        }
        db.close();
    }

    public List<Categoria> buscar() {
        List<Categoria> categorias = new ArrayList<>();
        SQLiteDatabase db = connection.getReadableDatabase();
        String columnas[] = new String[]{"id", "name"};
        Cursor cursor = db.query("categoria", columnas, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Categoria u = new Categoria();
            u.setId(cursor.getInt(cursor.getColumnIndex("id")));
            u.setName(cursor.getString(cursor.getColumnIndex("name")));

            cursor.moveToNext();
            categorias.add(u);
        }
        cursor.close();
        return categorias;
    }

    /**
     * Get Categoria By Id
     *
     * @param id
     * @return
     */
    public Categoria buscarId(Integer id) {

        Categoria categoria = new Categoria();
        SQLiteDatabase db = connection.getReadableDatabase();
        String columnas[] = new String[]{"id", "name"};
        Cursor cursor = db.query("categoria", columnas, "id=" + id, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            categoria.setId(cursor.getInt(cursor.getColumnIndex("id")));
            categoria.setName(cursor.getString(cursor.getColumnIndex("name")));
            cursor.moveToNext();
        }
        cursor.close();
        return categoria;
    }
}
