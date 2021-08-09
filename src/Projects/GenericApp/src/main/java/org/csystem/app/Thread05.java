package org.csystem.app;


import org.csystem.util.console.Console;
import org.csystem.util.scheduler.Scheduler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Thread05 {

    public static void main(String[] args)
    {
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        var scheduler = new Scheduler(1, TimeUnit.SECONDS);

        scheduler.schedule(() -> {
            var now = LocalDateTime.now();

            Console.write("%s\r", formatter.format(now));
        });
    }
}


