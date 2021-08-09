package org.csystem.app;


import org.csystem.util.console.Console;
import org.csystem.util.scheduler.Scheduler;
import org.csystem.util.thread.ThreadUtil;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Thread08 {

    public static void main(String[] args) {
        var random = new Random();

        var t = new Thread(() -> {
            var i = 0;

            while (!Thread.interrupted())
                Console.write("%d-", i++);

            Console.writeLine("Interrupt geldi. Artık işleme devam etmeyeceğim");
            Console.writeLine("Artık sonlanma zamanı!!");
        });

        t.start();

        ThreadUtil.sleep(random.nextInt(1000) + 1000);

        t.interrupt();
    }
}


