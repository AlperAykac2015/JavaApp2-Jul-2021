package org.csystem.app;


import org.csystem.util.console.Console;
import org.csystem.util.thread.ThreadUtil;

import java.util.Random;

public class Thread01 {

    public static void main(String[] args) {
        var random = new Random();
        var n = Console.readInt("Bir sayı giriniz:");

        var t = new Thread(() -> {
            for (int i = 0; i < n; ++i) {
                try {
                    Console.write("%d ", i);
                    Thread.sleep(1000);
                } catch (InterruptedException ignore) {
                    Console.writeLine("\nInterrupt geldi ama umurumda değil!....");
                }
            }


            Console.writeLine("Artık sonlanma zamanıdır");
        });

        t.start();

        ThreadUtil.sleep(random.nextInt(4000) + 1000);

        t.interrupt();

        ThreadUtil.sleep(random.nextInt(4000) + 1000);

        t.interrupt();
    }
}


