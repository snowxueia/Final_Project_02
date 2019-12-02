package com.example.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;

public class DailyTaskActivity extends AppCompatActivity {

    TextView word, pos, definition, sample, title;
    Button check, next, previous;
    int row = 0;
    int col = 0;
    int prev = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_task);

        title = (TextView)findViewById(R.id.title);
        next = (Button)findViewById(R.id.next);
        check = (Button)findViewById(R.id.check);
        previous = (Button)findViewById(R.id.previous);
        word = (TextView)findViewById(R.id.word);
        pos = (TextView)findViewById(R.id.pos);
        definition = (TextView)findViewById(R.id.definition);
        sample = (TextView)findViewById(R.id.sample);

        // open database
        final DataBaseHelper myDatabaseHelper;
        myDatabaseHelper = new DataBaseHelper(this);
        final String[][] str = myDatabaseHelper.getAppCategoryDetail("vocab", 52, 4);

        Random random = new Random();
        row = random.nextInt(str[0].length);

        word.setText(str[col][row]);
        pos.setText(str[col+1][row]);
        definition.setText(str[col+2][row]);
        sample.setText(str[col+3][row]);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev = row;
                Random random = new Random();
                row = random.nextInt(str[0].length);

                word.setText(str[col][row]);
                pos.setText(str[col+1][row]);
                definition.setText(str[col+2][row]);
                sample.setText(str[col+3][row]);
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row = prev;
                word.setText(str[col][row]);
                pos.setText(str[col+1][row]);
                definition.setText(str[col+2][row]);
                sample.setText(str[col+3][row]);
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = myDatabaseHelper.insertInReview(str[col][row], str[col+2][row]);

                String[][] str1 = myDatabaseHelper.getAppCategoryDetail("review", myDatabaseHelper.getReviewRowNum(), 2);

                if(result == false) {
                    Toast.makeText(getApplicationContext(), "failed to insert", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "insert succeeded", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
