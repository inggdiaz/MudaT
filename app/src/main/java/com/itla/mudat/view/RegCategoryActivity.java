package com.itla.mudat.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itla.mudat.R;
import com.itla.mudat.dao.CategoriaDbo;
import com.itla.mudat.entity.Categoria;

public class RegCategoryActivity extends AppCompatActivity {

    private EditText categoryName;
    private Button btnSave;
    private Button btnSearch;
    private Integer id;
    private Categoria categoria;

    public RegCategoryActivity() {
        this.id = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_category);

        Bundle params = getIntent().getExtras();

        this.categoryName = findViewById(R.id.txtNameCategory);
        this.btnSave = findViewById(R.id.btnSaveCategory);
        this.btnSearch = findViewById(R.id.btnSearchCategory);

        if (params != null && params.containsKey("category")) {
            this.fillFields(params);
        }


        this.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = "The Category was Update";
                Categoria categoria = new Categoria();

                if (RegCategoryActivity.this.categoria == null) {
                    RegCategoryActivity.this.categoria = new Categoria();
                    msg = "The Category was Created";
                } else {
                    categoria.setId(RegCategoryActivity.this.id);
                }

                categoria.setName(RegCategoryActivity.this.categoryName.getText().toString());

                new CategoriaDbo(RegCategoryActivity.this).crear(categoria);
                Toast message = Toast.makeText(RegCategoryActivity.this, msg, Toast.LENGTH_SHORT);
                message.show();
            }
        });

        this.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewCategoryList = new Intent(RegCategoryActivity.this, CategoryListActivity.class);
                startActivity(viewCategoryList);
            }
        });
    }

    public void fillFields(Bundle params) {
        this.categoria = (Categoria) params.getSerializable("category");
        this.categoryName.setText(this.categoria.getName());
        this.id = this.categoria.getId();
    }
}
