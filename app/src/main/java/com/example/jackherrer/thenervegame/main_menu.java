package com.example.jackherrer.thenervegame;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class main_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //set pic taken on false
        SharedPreferences.Editor editor = getSharedPreferences("prefs", MODE_PRIVATE).edit();
        editor.putBoolean("name_entry_pic_taken", false);
        editor.commit();
    }

    public void new_game_click(View view) {
        startActivity(new Intent(this,in_game.class));
    }

    public void to_highscore(View view) {
        Intent to_highscore = new Intent(this, highscore.class);
        startActivity(to_highscore);
    }

    public void main_menu_quit_click(View view) {
        finish();
    }
}
