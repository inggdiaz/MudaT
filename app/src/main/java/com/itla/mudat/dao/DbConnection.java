package com.itla.mudat.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Gerónimo Díaz on 25/11/2017.
 */

public class DbConnection extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "mudat.db";
    public static String LOG_T = "DbConnection";

    public DbConnection(Context context) {
        super(context, DATABASE_NAME, null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(LOG_T, "Iniciando onCreate...");
        db.execSQL(SqlHelperSchema.USUARIO_TABLE);
        db.execSQL(SqlHelperSchema.ANUNCIO_TABLE);
        db.execSQL(SqlHelperSchema.FOTOS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Log.i(LOG_T, "Iniciando onUpgrade...");
        db.execSQL(SqlHelperSchema.CATEGORIA_TABLE);
//        db.execSQL(SqlHelperSchema.ANUNCIO_TABLE);
//        db.execSQL(SqlHelperSchema.FOTOS_TABLE);
    }
}
