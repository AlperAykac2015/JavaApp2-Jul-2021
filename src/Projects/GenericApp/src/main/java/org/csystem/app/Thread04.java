package org.csystem.app;


import org.csystem.util.console.Console;
import org.csystem.util.thread.ThreadUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Thread04 {

    public static void main(String[] args)
    {
        var timer = new Timer();

        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");

        timer.schedule(new TimerTask() {
            @Override
            public void run()
            {
                var now = LocalDateTime.now();

                Console.write("%s\r", formatter.format(now));
            }
        }, 0, 1000);
    }
}


