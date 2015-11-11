package com.example.jackherrer.thenervegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

        // get data to pass to highscore
        EditText name_entry = (EditText) findViewById(R.id.get_name_box);
        String username = String.valueOf(name_entry.getText());
        Bundle extras = getIntent().getExtras();
        int score = extras.getInt("score");

        Intent to_highscore = new Intent(this, highscore.class);
        to_highscore.putExtra("score", score);
        to_highscore.putExtra("username", username);

        startActivity(to_highscore);
        finish();

    }
}
