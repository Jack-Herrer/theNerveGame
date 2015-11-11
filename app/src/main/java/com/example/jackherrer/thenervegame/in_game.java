package com.example.jackherrer.thenervegame;

import android.content.Intent;
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
        Intent to_name_entry = new Intent(this, enter_name.class);
        to_name_entry.putExtra("score", counter);
        startActivity(to_name_entry);
        finish();

    }
}
