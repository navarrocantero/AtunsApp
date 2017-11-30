package org.thinway.linuxapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView mTextViewDistroName;
    TextView mTextViewDistroOstype;
    TextView mTextViewDistroBasedon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String name = "";
        String ostype = "";
        String basedon = "";

        mTextViewDistroName = findViewById(R.id.distro_name_text_view);
        mTextViewDistroOstype = findViewById(R.id.ostype_text_view);
        mTextViewDistroBasedon = findViewById(R.id.basedon_text_view);

        Intent detailIntent = DetailActivity.this.getIntent();

        if(detailIntent.hasExtra("distro_name")){
            name = detailIntent.getStringExtra("distro_name");
        }
        if(detailIntent.hasExtra("distro_ostype")){
            ostype = detailIntent.getStringExtra("distro_ostype");
        }
        if(detailIntent.hasExtra("distro_basedon")){
            basedon = detailIntent.getStringExtra("distro_basedon");
        }

        mTextViewDistroName.setText(name);
        mTextViewDistroOstype.setText(ostype);
        mTextViewDistroBasedon.setText(basedon);
    }
}
