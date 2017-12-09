package com.itla.mudat.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.itla.mudat.Adapters.CategoryList;
import com.itla.mudat.R;
import com.itla.mudat.dao.CategoriaDbo;
import com.itla.mudat.entity.Categoria;

import java.util.List;

public class CategoryListActivity extends AppCompatActivity {
    private Button btnAddCategory;
    private ListView categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        this.btnAddCategory = findViewById(R.id.btnAddCategory);
        this.categoryList = findViewById(R.id.categoryViewList);

        List<Categoria> categorias = new CategoriaDbo(this).buscar();
        this.categoryList.setAdapter(new CategoryList(categorias, this));

        this.btnAddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewCategory = new Intent(CategoryListActivity.this, RegCategoryActivity.class);
                startActivity(viewCategory);
            }
        });

        this.categoryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent viewer = new Intent(CategoryListActivity.this, RegCategoryActivity.class);
                Categoria categoria = (Categoria) categoryList.getItemAtPosition(i);
                Bundle bundle = new Bundle();
                bundle.putSerializable("category", categoria);
                viewer.putExtras(bundle);
                startActivity(viewer);
            }
        });

    }
}
