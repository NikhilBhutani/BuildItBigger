package com.example;

import java.util.Random;

/**
 * Created by Nikhil Bhutani on 9/6/2016.
 */
public class SupplyJokes {

    private int i = 0;
    String jokesarray[] = new String[5];

    public String getJoke(){

        i = getRandomNum();


        jokesarray[0] = "Why do Java developers wear glasses? \n" +
                         "Because they can't C#";
        jokesarray[1] = "Why did the developer go broke? \n" +
                "Because he used up all his cache";
        jokesarray[2] = "Two bytes meet. The first byte asks, \"Are you ill?\" \n" +
                "The second byte replies, \"No, just feeling a bit off.\"";
        jokesarray[3] = "How do two programmers make money? \n" +
                 "One writes viruses, the other anti-viruses.";
        jokesarray[4] = "Your momma is so fat, when she sat on an iPod, she made the iPad! ";

              return jokesarray[i];
          }


    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(4-0+1) + 0;

    }

}
