package org.csystem.app;


import org.csystem.util.console.Console;
import org.csystem.util.scheduler.Scheduler;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Thread07 {

    public static void main(String[] args)
    {
        var random = new Random();


        var t = new Thread(() -> {
            int i = 0;

            for (;;) {
                Console.writeLine("%d", i++);
                //...
            }
        });

        t.start();

        var scheduler = new Scheduler(1, TimeUnit.SECONDS);

        scheduler.schedule(t::interrupt);
    }
}


