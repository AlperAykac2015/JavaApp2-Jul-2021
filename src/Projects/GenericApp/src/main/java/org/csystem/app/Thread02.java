package org.csystem.app;


import org.csystem.util.console.Console;
import org.csystem.util.thread.ThreadUtil;

import java.util.Random;

public class Thread02 {

    public static void main(String[] args) {
        var random = new Random();
        var n = Console.readInt("Bir sayı giriniz:");

        var t = new Thread(() -> {
            try {
                for (int i = 0; i < n; ++i) {
                    Console.write("%d ", i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ignore) {
                Console.writeLine("\nInterrupt geldi. Artık işleme devam etmeyeceğim");
            }

            Console.writeLine("Artık sonlanma zamanıdır");
        });

        t.start();

        ThreadUtil.sleep(random.nextInt(4000) + 1000);

        t.interrupt();
    }
}


