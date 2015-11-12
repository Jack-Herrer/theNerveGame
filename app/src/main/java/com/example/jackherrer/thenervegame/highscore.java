package com.example.jackherrer.thenervegame;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class highscore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        // get values by extras
//        Bundle extras = getIntent().getExtras();
//        int score = extras.getInt("score");
//        String username = extras.getString("username");
//
//        TextView username_view = (TextView)findViewById(R.id.user_name_view_highscore);
//        TextView score_view = (TextView)findViewById(R.id.score_highscore);
//
//        username_view.setText(username);
//        score_view.setText("Score: "+score);

        // get values by shared prefs
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);

        String username = prefs.getString("user_name_pref", "No name defined");//"No name defined" is the default value.
        int score = prefs.getInt("score_pref", 0); //0 is the default value.


        TextView username_view = (TextView) findViewById(R.id.user_name_view_highscore);
        TextView score_view = (TextView) findViewById(R.id.score_highscore);

        username_view.setText(username);
        score_view.setText("Score: " + score);


    }

    public void to_main_menu(View view) {
        finish();
    }
}
