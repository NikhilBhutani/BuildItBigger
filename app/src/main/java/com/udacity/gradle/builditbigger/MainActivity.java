package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.SupplyJokes;
import com.github.nikhilbhutani.showjokelibrary.DisplayJokes;


public class MainActivity extends AppCompatActivity {


    private final String JOKE_KEY = "joke_key";
    private GetDataFromBackend.JokeListener jokeListener;

    //For Loading Indicator
    public static ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        progressDialog.show();

        if (MainActivityFragment.mInterstitialAd != null) {
            if (MainActivityFragment.mInterstitialAd.isLoaded())
                System.out.println("AD LOADED");
            MainActivityFragment.mInterstitialAd.show();
        }

        jokeListener = new GetDataFromBackend.JokeListener() {
            @Override
            public void jokehere(String response) {
                Intent intent = new Intent(MainActivity.this, DisplayJokes.class);
                intent.putExtra(JOKE_KEY, response);
                startActivity(intent);

            }
        };
        GetDataFromBackend dataFromBackend = new GetDataFromBackend(jokeListener);
        dataFromBackend.execute();
        //  Toast.makeText(this, supplyJokes.getJoke(), Toast.LENGTH_SHORT).show();
    }

}
