package com.itla.mudat.Adapters;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itla.mudat.R;
import com.itla.mudat.entity.Anuncio;
import com.itla.mudat.entity.Usuario;

import java.util.List;

/**
 * Created by Gerónimo Díaz on 07/12/2017.
 */

public class AnuncioList extends BaseAdapter {

    List<Anuncio> anuncios;
    Activity context;

    public AnuncioList(List<Anuncio> anuncios, Activity context) {
        this.anuncios = anuncios;
        this.context = context;
    }

    @Override
    public int getCount() {
        return anuncios.size();
    }

    @Override
    public Object getItem(int i) {
        return anuncios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.row_anuncio_list, null);
        }
        TextView textViewName = view.findViewById(R.id.anuncioTituloRow);
        TextView textViewEmail = view.findViewById(R.id.anuncioPrecioRow);
        Anuncio u = anuncios.get(i);

        textViewName.setText(u.getTitulo());
        textViewEmail.setText(u.getPrecio().toString());
        return view;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
