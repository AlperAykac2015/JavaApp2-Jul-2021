package org.csystem.appender;

import org.csystem.util.console.Console;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.StreamSupport;

class App {
    public static void main(String[] args)
    {
        var appender = new Appender(10, 1_00);

        appender.run();
        StreamSupport.stream(appender.spliterator(), false).limit(1000).forEach(Console::writeLine);
        Console.writeLine("Size:%d", appender.size());
    }
}

class Appender implements Iterable<String> {
    private final ArrayList<String> m_texts = new ArrayList<>();
    private final int m_numberOfThreads;
    private final long m_count;

    private void threadCallback()
    {
        var name = Thread.currentThread().getName();

        LongStream.range(0, m_count).forEach(i -> {
            synchronized (this) {
                m_texts.add(String.format("%s-%d-", name, i));
            }
        });
    }

    private void startThreads(ArrayList<Thread> threads)
    {
        IntStream.range(0, m_numberOfThreads).forEach(i -> {
            var thread = new Thread(this::threadCallback, "Appender-" + (i + 1));

            threads.add(thread);
            thread.start();
        });
    }

    private void joinThreads(ArrayList<Thread> threads)
    {
        try {
            for (var thread : threads)
                thread.join();
        }
        catch (InterruptedException ignore) {

        }
    }

    public Appender(int numberOfThreads, long count)
    {
        if (numberOfThreads <= 0 || count <= 0)
            throw new IllegalArgumentException("Invalid Arguments");

        m_numberOfThreads = numberOfThreads;
        m_count = count;
    }

    public int size()
    {
        return m_texts.size();
    }

    public void run()
    {
        var threads = new ArrayList<Thread>();
        startThreads(threads);
        joinThreads(threads);
    }

    @Override
    public Iterator<String> iterator()
    {
        return m_texts.iterator();
    }
}