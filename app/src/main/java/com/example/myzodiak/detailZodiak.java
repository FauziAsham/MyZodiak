package com.example.myzodiak;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class detailZodiak extends AppCompatActivity {

    private TextView tvJudul, tvDetail;
    private ImageView photo;
    String judul;
    String detail;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_zodiak);

        tvJudul = findViewById(R.id.tv_zodiak_name);
        tvDetail = findViewById(R.id.tv_zodiak_detail);
        photo = findViewById(R.id.iv_zodiak);

        judul = getIntent().getStringExtra("name");
        detail = getIntent().getStringExtra("detail");


        image = getIntent().getIntExtra("photo", 0);
        photo.setImageResource(image);
        tvDetail.setText(detail);
        tvJudul.setText(judul);
    }
}