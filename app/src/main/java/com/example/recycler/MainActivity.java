package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");

        initImageBitMaps();
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: started");
        RecyclerView recyclerView = findViewById(R.id.rv);
        RecycleViewAdapter adapter = new RecycleViewAdapter(mNames, mImageUrls, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)) ;

    }

    private void initImageBitMaps() {
        Log.d(TAG, "initImageBitMaps: Started");

        mImageUrls.add("https://assets3.thrillist.com/v1/image/2498965/size/tmg-article_tall.jpg");
        mNames.add("Snail");

        mImageUrls.add("https://assets3.thrillist.com/v1/image/2498969/size/tmg-article_tall.jpg");
        mNames.add("Elephant");

        mImageUrls.add("https://assets3.thrillist.com/v1/image/2498971/size/tmg-article_tall.jpg");
        mNames.add("Rhino");

        mImageUrls.add("https://assets3.thrillist.com/v1/image/2498972/size/tmg-article_tall.jpg");
        mNames.add("Frog");

        mImageUrls.add("https://assets3.thrillist.com/v1/image/2498974/size/tmg-article_tall.jpg");
        mNames.add("Sloth");

        mImageUrls.add("https://assets3.thrillist.com/v1/image/2498975/size/tmg-article_tall.jpg");
        mNames.add("Penguin");

        mImageUrls.add("https://assets3.thrillist.com/v1/image/2498978/size/tmg-article_tall.jpg");
        mNames.add("Cow");

        mImageUrls.add("https://assets3.thrillist.com/v1/image/2498980/size/tmg-article_tall.jpg");
        mNames.add("Giraffe");

        mImageUrls.add("https://assets3.thrillist.com/v1/image/2498986/size/tmg-article_tall.jpg");
        mNames.add("Kangaroo");

        initRecyclerView();
    }

}
