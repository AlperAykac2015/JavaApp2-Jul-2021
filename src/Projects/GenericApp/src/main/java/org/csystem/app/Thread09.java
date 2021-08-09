package org.csystem.app;


import org.csystem.util.console.Console;
import org.csystem.util.thread.ThreadUtil;

import java.util.Random;

public class Thread09 {

    public static void main(String[] args)
    {
        var random = new Random();

        var t = new Thread(() -> {
            var i = 0;

            var self = Thread.currentThread();
            while (!self.isInterrupted())
                Console.writeLine("%d", i++);

            Console.writeLine("Interrupt geldi. Artık işleme devam etmeyeceğim");
            Console.writeLine("Artık sonlanma zamanı!!");
        });

        t.start();

        ThreadUtil.sleep(random.nextInt(2000) + 1000);

        t.interrupt();
    }
}


