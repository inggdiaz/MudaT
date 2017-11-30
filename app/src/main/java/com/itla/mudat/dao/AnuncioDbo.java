package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itla.mudat.entity.Anuncio;
import com.itla.mudat.entity.Categoria;
import com.itla.mudat.entity.TipoUsuario;
import com.itla.mudat.entity.Usuario;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gerónimo Díaz on 25/11/2017.
 */

public class AnuncioDbo {
    private DbConnection connection;
    private Context context;

    public AnuncioDbo(Context context) {
        this.connection = new DbConnection(context);
        this.context = context;
    }

    /**
     * Insert Usuarios
     *
     * @param anuncio
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
            Categoria categoria = new Categoria();
            Usuario usuario = new Usuario();


            Integer idCategoria = cursor.getInt(cursor.getColumnIndex("id_categoria"));
            categoria = (new CategoriaDbo(this.context).buscarId(idCategoria));

            Integer idUsuario = cursor.getInt(cursor.getColumnIndex("id_categoria"));
            usuario = (new UsuarioDbo(this.context).buscarId(idUsuario));

            a.setId(cursor.getInt(cursor.getColumnIndex("id")));
            a.setCategoria(categoria);
            a.setUsuario(usuario);
            try {
                a.setFecha(new SimpleDateFormat("dd/MM/yyyy").parse(cursor.getString(cursor.getColumnIndex("fecha"))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            a.setCondicion(cursor.getInt(cursor.getColumnIndex("condicion")));
            a.setPrecio(cursor.getDouble(cursor.getColumnIndex("precio")));
            a.setTitulo(cursor.getString(cursor.getColumnIndex("titulo")));
            a.setUbicacion(cursor.getString(cursor.getColumnIndex("ubicacion")));
            a.setDetalle(cursor.getString(cursor.getColumnIndex("detalle")));

            cursor.moveToNext();
            anuncio.add(a);
        }
        cursor.close();
        return anuncio;
    }

    /**
     * Get Anuncio By Id
     * @param id
     * @return
     */
    public Anuncio buscarId(Integer id) {
        Anuncio anuncio = new Anuncio();
        SQLiteDatabase db = connection.getReadableDatabase();
        String columnas[] = new String[]{"id", "id_categoria", "id_usuario", "fecha", "condicion", "precio", "titulo", "ubicacion", "detalle"};
        Cursor cursor = db.query("usuario", columnas, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            Categoria categoria = new Categoria();
            Usuario usuario = new Usuario();

            Integer idCategoria = cursor.getInt(cursor.getColumnIndex("id_categoria"));
            categoria = (new CategoriaDbo(this.context).buscarId(idCategoria));

            Integer idUsuario = cursor.getInt(cursor.getColumnIndex("id_categoria"));
            usuario = (new UsuarioDbo(this.context).buscarId(idUsuario));

            anuncio.setId(cursor.getInt(cursor.getColumnIndex("id")));
            anuncio.setCategoria(categoria);
            anuncio.setUsuario(usuario);
            try {
                anuncio.setFecha(new SimpleDateFormat("dd/MM/yyyy").parse(cursor.getString(cursor.getColumnIndex("fecha"))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            anuncio.setCondicion(cursor.getInt(cursor.getColumnIndex("condicion")));
            anuncio.setPrecio(cursor.getDouble(cursor.getColumnIndex("precio")));
            anuncio.setTitulo(cursor.getString(cursor.getColumnIndex("titulo")));
            anuncio.setUbicacion(cursor.getString(cursor.getColumnIndex("ubicacion")));
            anuncio.setDetalle(cursor.getString(cursor.getColumnIndex("detalle")));

            cursor.moveToNext();

        }
        cursor.close();
        return anuncio;
    }


}
