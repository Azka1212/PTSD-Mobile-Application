package com.example.ptsdetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    TextView tv;
    Button proSwipeBtn;
    Button proSwipeBtn2;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_result);

        tv = findViewById(R.id.tv);
        linearLayout = findViewById(R.id.linearLayout);

        //Receiving value from the previous activity
        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("SCORE");

        if (score > 42) {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.unsafe));
            tv.setTextColor(Color.BLACK);
        } else {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.safe));
            tv.setTextColor(Color.WHITE);
        }

        //Setting the score to textView
        tv.setText("Score : " + score);

        proSwipeBtn = (Button) findViewById(R.id.awesome_btn);
        proSwipeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // task success! show TICK icon in ProSwipeButton
                        Intent i = new Intent(Result.this, Score.class);
                        startActivity(i);
                    }
                }, 1000);
            }
        });

        proSwipeBtn2 = (Button) findViewById(R.id.awesome_btn2);
        proSwipeBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // task success! show TICK icon in ProSwipeButton
                        Intent i = new Intent(Result.this, Suggestion.class);
                        startActivity(i);
                    }
                }, 1000);
            }
        });
    }
}