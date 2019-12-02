package com.example.finalproject;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ReviewActivity extends AppCompatActivity {

    ListView listView;

    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        listView = findViewById(R.id.listView);

        final DataBaseHelper myDatabaseHelper;
        myDatabaseHelper = new DataBaseHelper(this);
        final String[][] str = myDatabaseHelper.getAppCategoryDetail("review", myDatabaseHelper.getReviewRowNum(), 2);



        ArrayList<Vocab> list = new ArrayList<>();

        for(int i = 0; i < myDatabaseHelper.getReviewRowNum(); i++) {
            Vocab v = new Vocab(str[0][i], str[1][i]);
            list.add(v);
        }


        VocabListAdapter adapter = new VocabListAdapter(this, R.layout.adapter_view_layout, list);

        listView.setAdapter(adapter);
    }
}
