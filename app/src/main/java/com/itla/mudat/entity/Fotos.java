package com.itla.mudat.entity;

/**
 * Created by Gerónimo Díaz on 18/11/2017.
 */

public class Fotos {
    private Integer id;
    private String image;
    private Anuncio anuncio;
    private Boolean estatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Fotos{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", anuncio=" + anuncio +
                ", estatus=" + estatus +
                '}';
    }
}
