package com.itla.mudat.dao;

/**
 * Created by Gerónimo Díaz on 25/11/2017.
 */

public class SqlHelperSchema {
    public static final String USUARIO_TABLE = "CREATE TABLE IF NOT EXISTS `usuario` (\n" +
            "\t`id`\tINTEGER NOT NULL primary key AUTOINCREMENT,\n" +
            "\t`nombre`\tTEXT NOT NULL,\n" +
            "\t`tipo_usuario`\tTEXT NOT NULL,\n" +
            "\t`identificacion`\tTEXT NOT NULL,\n" +
            "\t`email`\tTEXT NOT NULL,\n" +
            "\t`telefonos`\tTEXT NOT NULL,\n" +
            "\t`clave`\tTEXT NOT NULL,\n" +
            "\t`status`\tINTEGER NOT NULL DEFAULT 1\n" +
//            "\tPRIMARY KEY(`id`)\n" +
            ");";

    public static final String CATEGORIA_TABLE = "CREATE TABLE IF NOT EXISTS `categoria` (\n" +
            "\t`id`\tINTEGER NOT NULL primary key AUTOINCREMENT,\n" +
            "\t`name`\tTEXT NOT NULL\n" +
            ");";
    public static final String ANUNCIO_TABLE = "CREATE TABLE IF NOT EXISTS `anuncio` (\n" +
            "\t`id`\tINTEGER NOT NULL primary key AUTOINCREMENT,\n" +
            "\t`id_categoria`\tINTEGER NOT NULL,\n" +
            "\t`id_usuario`\tINTEGER NOT NULL,\n" +
            "\t`fecha`\tTEXT NOT NULL,\n" +
            "\t`condicion`\tINTEGER NOT NULL,\n" +
            "\t`precio`\tNUMERIC NOT NULL,\n" +
            "\t`titulo`\tTEXT NOT NULL,\n" +
            "\t`ubicacion`\tTEXT NOT NULL,\n" +
            "\t`detalle`\tTEXT NOT NULL\n" +
            ");";
    public static final String FOTOS_TABLE = "CREATE TABLE IF NOT EXISTS `fotos` (\n" +
            "\t`id`\tINTEGER NOT NULL primary key AUTOINCREMENT,\n" +
            "\t`id_anuncio`\tINTEGER NOT NULL,\n" +
            "\t`image`\tTEXT NOT NULL,\n" +
            "\t`status`\tINTEGER NOT NULL DEFAULT 1\n" +
            ");";
}
