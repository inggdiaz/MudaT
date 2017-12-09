package com.itla.mudat.entity;

import java.io.Serializable;

/**
 * Created by Gerónimo Díaz on 18/11/2017.
 */

public class Categoria implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
