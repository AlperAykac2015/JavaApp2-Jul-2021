package org.csystem.app;


import org.csystem.util.console.Console;
import org.csystem.util.thread.ThreadUtil;

import java.util.Random;

public class Thread11 {

    public static void main(String[] args)
    {
        var random = new Random();

        var t = new Thread(() -> {
            var i = 0;
            while (!Thread.currentThread().isInterrupted())
                Console.write("+");

            i = 0;

            Console.writeLine("---------------");

            while (!Thread.interrupted())
                Console.write(".");

            Console.writeLine("Interrupt geldi. Artık işleme devam etmeyeceğim");
            Console.writeLine("Artık sonlanma zamanı!!");
        });

        t.start();

        ThreadUtil.sleep(random.nextInt(500) + 500);

        t.interrupt();
        ThreadUtil.sleep(random.nextInt(500) + 500);

        t.interrupt();
    }
}


