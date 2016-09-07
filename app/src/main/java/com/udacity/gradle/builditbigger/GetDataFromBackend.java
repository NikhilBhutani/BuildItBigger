package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.github.nikhilbhutani.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;


import java.io.IOException;

/**
 * Created by Nikhil Bhutani on 9/7/2016.
 */
public class GetDataFromBackend extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
 //   private Context context;
    JokeListener jokeListener;

    public GetDataFromBackend(JokeListener listener){
        this.jokeListener = listener;
    }

    public interface JokeListener{
        public void jokehere(String response);

    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... strings) {

        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.0.4:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }
      //   String name = strings[0];
        try {
                  return myApiService.getJoke().execute().getData();
        //    return myApiService.sayHi(name).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        System.out.println("HEEEEEEEEEEEEEEEYYYYYYYYY "+ s);

        jokeListener.jokehere(s);
       // Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }
}
