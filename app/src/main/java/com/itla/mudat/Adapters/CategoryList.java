package com.itla.mudat.Adapters;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itla.mudat.R;
import com.itla.mudat.entity.Categoria;
import com.itla.mudat.entity.Usuario;

import java.util.List;

/**
 * Created by Gerónimo Díaz on 07/12/2017.
 */

public class CategoryList extends BaseAdapter {

    List<Categoria> categorias;
    Activity context;

    public CategoryList(List<Categoria> categorias, Activity context) {
        this.categorias = categorias;
        this.context = context;
    }

    @Override
    public int getCount() {
        return categorias.size();
    }

    @Override
    public Object getItem(int i) {
        return categorias.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.row_category_list, null);
        }
        TextView textViewName = view.findViewById(R.id.categoryNameRow);
        Categoria u = categorias.get(i);
        textViewName.setText(u.getName());
        return view;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
