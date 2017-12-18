package com.itla.mudat.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.itla.mudat.Adapters.AnuncioList;
import com.itla.mudat.R;
import com.itla.mudat.dao.AnuncioDbo;
import com.itla.mudat.entity.Anuncio;

import java.util.List;

public class BannerActivity extends AppCompatActivity {

    private Button btnAdd;
    private ListView bannerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        this.btnAdd = findViewById(R.id.btnAddBanner);
        this.bannerList = findViewById(R.id.bannerViewList);

        List<Anuncio> anuncioList = new AnuncioDbo(this).buscar();
        this.bannerList.setAdapter(new AnuncioList(anuncioList, this));

        this.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewReg = new Intent(BannerActivity.this, RegBannerActivity.class);
                startActivity(viewReg);
            }
        });

        this.bannerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent viewer = new Intent(BannerActivity.this, RegBannerActivity.class);
                Anuncio anuncio = (Anuncio) bannerList.getItemAtPosition(i);
                Bundle bundle = new Bundle();
                bundle.putSerializable("anuncio", anuncio);
                viewer.putExtras(bundle);
                startActivity(viewer);
            }
        });
    }
}
