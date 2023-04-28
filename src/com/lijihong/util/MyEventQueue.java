package com.lijihong.util;

import java.util.HashMap;
import java.util.Vector;

/**
 * \* Created with IntelliJ IDEA.
 * \* @ProjectName: TankWar
 * \* @FileName: MyEventQueue
 * \* @author: li-jihong
 * \* Date: 2023-04-25 18:41
 */
public class MyEventQueue {
    protected final static HashMap<String, Thread> threads = new HashMap<>();
    protected final static HashMap<String, Vector<Runnable>> tasks = new HashMap<>();

    public static void invokeLater(String threadName, Runnable task) {
        Thread thread = threads.get(threadName);
        if (thread == null) {
            thread = new Thread(MyEventQueue::handleLoop, threadName);
            thread.setDaemon(true);
            threads.put(threadName, thread);
            tasks.put(threadName, new Vector<>());
            thread.start();
        }
        Vector<Runnable> tasks_ = tasks.get(threadName);
        tasks_.add(task);
    }

    public static void handleLoop() {
        Vector<Runnable> tasks_ = tasks.get(Thread.currentThread().getName());
        while (!Thread.interrupted()) {
            if (!tasks_.isEmpty()) {
                Runnable task = tasks_.remove(0);
                task.run();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                cancel();
                throw new RuntimeException(e);
            }
        }
    }

    public static void cancel() {
        tasks.forEach((name, tasks) -> {
            tasks.clear();
        });
        tasks.clear();
        threads.forEach((name, thread) -> {
            thread.interrupt();
        });
        threads.clear();
    }
}
