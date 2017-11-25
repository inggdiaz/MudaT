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
}
