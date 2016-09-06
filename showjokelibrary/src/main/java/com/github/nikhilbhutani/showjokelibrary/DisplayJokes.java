package com.github.nikhilbhutani.showjokelibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Nikhil Bhutani on 9/6/2016.
 */
public class DisplayJokes extends AppCompatActivity {

    private final String JOKE_KEY = "joke_key";
    private TextView joke;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.display_joke_activity);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        joke = (TextView) findViewById(R.id.displayJoke);
        showJoke();
    }

    private void showJoke() {

        String jokeString = getIntent().getExtras().getString(JOKE_KEY);
        joke.setText(jokeString);
    }


}
