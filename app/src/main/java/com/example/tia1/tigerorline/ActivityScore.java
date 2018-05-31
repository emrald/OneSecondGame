package com.example.tia1.tigerorline;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by TI A1 on 19-10-2016.
 */
public class ActivityScore extends Activity {

    String score;
    Bundle bn;
    TextView textView,tvhighscore;
    Button btnback;
    pl.droidsonroids.gif.GifTextView gif_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        textView = (TextView) findViewById(R.id.textView);
        tvhighscore = (TextView)findViewById(R.id.tvhighscore);
        gif_view = (pl.droidsonroids.gif.GifTextView) findViewById(R.id.gif);

        btnback = (Button) findViewById(R.id.btnback);

        bn = getIntent().getExtras();
        score = bn.getString("score");

        int score_int = Integer.parseInt(score);

        if (score_int > 100) {
            gif_view.setBackgroundResource(R.drawable.awesome);
        } else if (score_int < 10) {
            gif_view.setBackgroundResource(R.drawable.very_sad);
        } else if (score_int > 10 && score_int < 30) {
            gif_view.setBackgroundResource(R.drawable.sad);
        }
        else
            gif_view.setBackgroundResource(R.drawable.highfive);

        textView.setText("Your Score is " + score + "");
     //   tvhighscore.setText("Highest Score is "+score_int+"");

        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("key", score_int);
        editor.commit();

        SharedPreferences prefsget = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        int score = prefsget.getInt("key", 0);

       /* SharedPreferences prefs = getSharedPreferences("MyPrefsFile", MODE_PRIVATE);
        String restoredText = prefs.getString("high_score", null);
        if (restoredText != null) {
            String high_score = prefs.getString("high_score", "");//"No name defined" is the default value.
            if(Integer.parseInt(high_score)<score_int) {
                SharedPreferences.Editor editor = getSharedPreferences("MyPrefsFile", MODE_PRIVATE).edit();
                int score_save =  score_int;
                editor.putString("high_score", score_save+"");
                editor.commit();
                tvhighscore.setText("High Score is " + high_score + "");
            }
            else
                tvhighscore.setText("High Score is "+score_int+"");
        }*/

       /* SharedPreferences.Editor editor = getSharedPreferences("MyPrefsFile", MODE_PRIVATE).edit();
        editor.putString("high_score", score_int+"");
        editor.commit();*/

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityScore.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ActivityScore.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
