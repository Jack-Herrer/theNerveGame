package com.example.jackherrer.thenervegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class enter_name extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);


        Bundle extras = getIntent().getExtras();
        int score = extras.getInt("score");

        TextView score_view = (TextView)findViewById(R.id.your_score);
        score_view.setText(String.valueOf(score));
    }

    public void name_entered(View view) {
    }
}
