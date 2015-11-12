package com.example.jackherrer.thenervegame;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class highscore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        FileInputStream fis = null;
        try {
            fis = openFileInput("user_photo_file");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Bitmap b = BitmapFactory.decodeStream(fis);
        try {
            if (fis != null) {
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageView img=(ImageView)findViewById(R.id.highscore_photo);
        img.setImageBitmap(b);

        // get values by shared prefs
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);

        String username = prefs.getString("user_name_pref", "No name defined");//"No name defined" is the default value.
        int score = prefs.getInt("score_pref", 0); //0 is the default value.


        TextView username_view = (TextView) findViewById(R.id.user_name_view_highscore);
        TextView score_view = (TextView) findViewById(R.id.score_highscore);



        username_view.setText(username);
        score_view.setText("Score: " + score);




    }

//    public Bitmap getImageBitmap(Context context,String name,String extension){
//        name=name+"."+extension;
//        try{
//            FileInputStream fis = context.openFileInput(name);
//            Bitmap b = BitmapFactory.decodeStream(fis);
//            fis.close();
//            return b;
//        }
//        catch(Exception e){
//        }
//        return null;
//    }

//    private void loadImageFromStorage(String path)
//    {
//
//        try {
//            File f=new File(path, "user_photo_file");
//            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
//            ImageView img=(ImageView)findViewById(R.id.highscore_photo);
//            img.setImageBitmap(b);
//        }
//        catch (FileNotFoundException e)
//        {
//            e.printStackTrace();
//        }
//
//    }

    public void to_main_menu(View view) {
        finish();
    }
}
