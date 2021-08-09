package org.csystem.app;


import org.csystem.util.console.Console;
import org.csystem.util.thread.ThreadUtil;

import java.util.Random;




import org.csystem.util.console.Console;
import org.csystem.util.thread.ThreadUtil;

import java.util.Random;

class App2 {
    public static void main(String[] args)
    {
        ThreadInterruptSimulation.run();
    }
}

final class ThreadInterruptSimulation {
    private static void doFirstLoop()
    {
        int i = 0;
        var reset = new Random().nextBoolean();

        if (reset)
            while (!Thread.interrupted())
                Console.writeLine("first loop:%d", i++);
        else {
            var self = Thread.currentThread();

            while (!self.isInterrupted())
                Console.writeLine("first loop:%d", i++);
        }
    }


    private static void threadCallback()
    {
        doFirstLoop();

        var i = 0;

        while (!Thread.interrupted())
            Console.writeLine("Second loop:%d", i++);

        Console.writeLine("Interrupt geldi. Artık işleme devam etmeyeceğim");
        Console.writeLine("Artık sonlanma zamanı!!");
    }

    private ThreadInterruptSimulation()
    {
    }

    public static void run()
    {
        var random = new Random();

        var t = new Thread(ThreadInterruptSimulation::threadCallback);

        t.start();

        ThreadUtil.sleep(random.nextInt(4000) + 1000);

        t.interrupt();

        ThreadUtil.sleep(random.nextInt(4000) + 1000);

        t.interrupt();
    }
}