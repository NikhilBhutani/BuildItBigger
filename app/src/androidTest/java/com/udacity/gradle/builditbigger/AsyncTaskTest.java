package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.ExecutionException;

/**
 * Created by Nikhil Bhutani on 9/8/2016.
 */
public class AsyncTaskTest extends AndroidTestCase {

    String result = null;

    public void myTest()
    {
       GetDataFromBackend getDataFromBackend = new GetDataFromBackend(null);
        getDataFromBackend.execute();

        try {
            result = getDataFromBackend.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        assertNotNull(result);

    }

}
