package com.example.user.HealeApps.fragment.medicine;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.HealeApps.R;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine_detail);


        int image = getIntent().getExtras().getInt("image");
        String title = getIntent().getExtras().getString("title");
        String desc = getIntent().getExtras().getString("description");

        TextView txtDetailTitle = (TextView) findViewById(R.id.textTitle);
        txtDetailTitle.setText(title);

        ImageView imgDetailImage = (ImageView) findViewById(R.id.image);
        imgDetailImage.setImageResource(image);

        TextView txtDetailDescription = (TextView) findViewById(R.id.textDescription);
        txtDetailDescription.setText(desc);
    }
}