package com.itla.mudat.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.itla.mudat.Adapters.CategoryList;
import com.itla.mudat.R;
import com.itla.mudat.dao.CategoriaDbo;
import com.itla.mudat.entity.Categoria;

import java.util.List;

public class RegBannerActivity extends AppCompatActivity {

    private Spinner spCategory;
    private Categoria categoriaSelectioned;
    private Button btnSave;
    private Button btnSearch;
    private EditText txtTitle;
    private EditText txtPrice;
    private EditText txtDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_banner);

        this.btnSave = findViewById(R.id.btnSaveBanner);
        this.btnSearch = findViewById(R.id.btnSearchBanner);
        this.txtTitle = findViewById(R.id.txtTitle);
//        this.btnSave = findViewById(R.id.btnSaveBanner);
//        this.spCategory = findViewById(R.id.spCategory);

        List<Categoria> categorias = new CategoriaDbo(this).buscar();
        this.spCategory.setAdapter(new CategoryList(categorias, this));

        this.spCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                RegBannerActivity.this.categoriaSelectioned = (Categoria) spCategory.getItemAtPosition(i);
                System.out.println(RegBannerActivity.this.categoriaSelectioned.toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

}
