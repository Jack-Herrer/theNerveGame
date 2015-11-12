package com.example.jackherrer.thenervegame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class in_game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);
    }

    public int counter = 0;


    public void on_in_game_click(View view) {
        counter++;
        TextView counter_text = (TextView)findViewById(R.id.in_game_counter);
        counter_text.setText(String.valueOf(counter));

    }

    public void on_finish_game_click(View view) {

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        int highscore = prefs.getInt("score_pref", 0);

        if(counter > highscore) {
            Intent to_name_entry = new Intent(this, enter_name.class);
            to_name_entry.putExtra("score", counter);
            startActivity(to_name_entry);
        }
        else{
            Intent to_highscore = new Intent(this, highscore.class);
            startActivity(to_highscore);
        }
        finish();

    }
}
