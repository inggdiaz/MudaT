package com.itla.mudat.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.itla.mudat.Adapters.CategoryList;
import com.itla.mudat.R;
import com.itla.mudat.dao.AnuncioDbo;
import com.itla.mudat.dao.CategoriaDbo;
import com.itla.mudat.entity.Anuncio;
import com.itla.mudat.entity.Categoria;

import java.util.Date;
import java.util.List;

public class RegBannerActivity extends AppCompatActivity {

    private Spinner spCategory;
    private Categoria categoriaSelectioned;
    private Button btnSave;
    private Button btnSearch;
    private EditText txtTitle;
    private EditText txtPrice;
    private EditText txtDetail;
    private Anuncio anuncio;
    private Integer id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_banner);
        Bundle params = getIntent().getExtras();


        this.btnSave = findViewById(R.id.btnSaveBanner);
        this.btnSearch = findViewById(R.id.btnSearchBanner);
        this.txtTitle = findViewById(R.id.txtTitle);
        this.txtPrice = findViewById(R.id.txtPrice);
        this.txtDetail = findViewById(R.id.txtDetail);
//        this.btnSave = findViewById(R.id.btnSaveBanner);
        this.spCategory = findViewById(R.id.spCategory);

        List<Categoria> categorias = new CategoriaDbo(this).buscar();
//        System.out.println("Categorias: " + categorias.toString());
        this.spCategory.setAdapter(new CategoryList(categorias, this));

        if (params != null && params.containsKey("anuncio")) {
            this.fillFields(params);
        }

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

        this.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = "The User was Updated";
                Anuncio anuncio = new Anuncio();
                if (RegBannerActivity.this.anuncio == null) {
                    RegBannerActivity.this.anuncio = new Anuncio();
                    msg = "The User was Created";
                } else {
                    anuncio.setId(RegBannerActivity.this.id);
                }

                anuncio.setCategoria(RegBannerActivity.this.categoriaSelectioned);
                anuncio.setFecha(new Date());
                anuncio.setCondicion(1);
                anuncio.setPrecio(Double.parseDouble(RegBannerActivity.this.txtPrice.getText().toString()));
                anuncio.setTitulo(RegBannerActivity.this.txtTitle.getText().toString());
                anuncio.setUbicacion("1,1");
                anuncio.setDetalle(RegBannerActivity.this.txtDetail.getText().toString());

                new AnuncioDbo(RegBannerActivity.this).crear(anuncio);
                Toast message = Toast.makeText(RegBannerActivity.this, msg, Toast.LENGTH_SHORT);
                message.show();
                RegBannerActivity.this.anuncio = null;
            }
        });

        this.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewer = new Intent(RegBannerActivity.this, BannerActivity.class);
                startActivity(viewer);
            }
        });

    }

    public void fillFields(Bundle params) {
        this.anuncio = (Anuncio) params.getSerializable("anuncio");
        this.txtTitle.setText(this.anuncio.getTitulo());
        this.id = this.anuncio.getId();
        this.txtPrice.setText(this.anuncio.getPrecio().toString());
        this.txtDetail.setText(this.anuncio.getDetalle());
    }

}
