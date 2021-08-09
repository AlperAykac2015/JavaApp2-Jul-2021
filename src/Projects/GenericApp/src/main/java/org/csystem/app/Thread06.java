package org.csystem.app;


import org.csystem.util.console.Console;
import org.csystem.util.scheduler.Scheduler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Thread06 {

    public static void main(String[] args)
    {
        var random = new Random();

        var t = new Thread(() -> {
            var i = 0;
            for (;;) {
                try {
                    Console.writeLine("%d", i++);
                    Thread.sleep(random.nextInt(500) + 500);
                }
                catch (InterruptedException ignore) {
                    Console.writeLine("Interrupt geldi ama umurumda değil!....");
                }
            }
        });

        t.start();

        new Scheduler(1, TimeUnit.SECONDS).schedule(t::interrupt);
    }
}


