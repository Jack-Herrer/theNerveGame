package com.example.jackherrer.thenervegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class highscore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        Bundle extras = getIntent().getExtras();
        int score = extras.getInt("score");
        String username = extras.getString("username");

        TextView username_view = (TextView)findViewById(R.id.user_name_view_highscore);
        TextView score_view = (TextView)findViewById(R.id.score_highscore);

        username_view.setText(username);
        score_view.setText(""+score);

    }

}
