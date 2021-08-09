package org.csystem.app;


import org.csystem.util.console.Console;

import java.util.Timer;
import java.util.TimerTask;

public class Thread03 {

    public static void main(String[] args)
    {
        var timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run()
            {
                Console.write('.');
            }
        }, 0, 1000);

        //...
    }
}


