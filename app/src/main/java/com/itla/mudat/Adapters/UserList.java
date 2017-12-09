package com.itla.mudat.Adapters;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itla.mudat.R;
import com.itla.mudat.entity.Usuario;

import java.util.List;

/**
 * Created by Gerónimo Díaz on 07/12/2017.
 */

public class UserList extends BaseAdapter {

    List<Usuario> users;
    Activity context;

    public UserList(List<Usuario> users, Activity context) {
        this.users = users;
        this.context = context;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.row_user_list, null);
        }
        TextView textViewName = view.findViewById(R.id.userNameRow);
        TextView textViewEmail = view.findViewById(R.id.userEmailRow);
        Usuario u = users.get(i);

        textViewName.setText(u.getNombre());
        textViewEmail.setText(u.getEmail());
        return view;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
