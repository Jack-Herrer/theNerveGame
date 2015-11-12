package com.example.jackherrer.thenervegame;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileOutputStream;

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


    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView user_picture = (ImageView)findViewById(R.id.user_picture_view);
            user_picture.setImageBitmap(imageBitmap);

            //broadcast user image
            Intent broadcast_img = new Intent();
            broadcast_img.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            broadcast_img.setAction("com.example.Broadcast");
            broadcast_img.putExtra("user_image", imageBitmap);
            sendBroadcast(broadcast_img);


        }
    }


    public void name_entered(View view) {

        // get data to pass to highscore
        EditText name_entry = (EditText) findViewById(R.id.get_name_box);
        String username = String.valueOf(name_entry.getText());
        Bundle extras = getIntent().getExtras();
        int score = extras.getInt("score");

        Intent to_highscore = new Intent(this, highscore.class);


        // shared preferences for highscore
        SharedPreferences.Editor editor = getSharedPreferences("prefs", MODE_PRIVATE).edit();
        editor.putString("user_name_pref", username);
        editor.putInt("score_pref", score);
        editor.commit();

        String SCORE_FILENAME = "score_file";

//        FileOutputStream score_file = null;
//        openFileOutput(SCORE_FILENAME, Context.MODE_PRIVATE);
//        score_file.write(score.getBytes());


        String FILENAME = "hello_file";
        String string = "hello world!";

//        FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
//        fos.write(string.getBytes());
//        fos.close();




        startActivity(to_highscore);
        finish();

    }

    public void take_picture(View view) {
        dispatchTakePictureIntent();

    }
}
