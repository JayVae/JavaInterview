package com.interview.javabasic.thread;

public class YieldDemo {
    public static void main(String[] args) {
        Runnable yieldTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + i);
//                    时间长的话还没等到执行到yield，第二个进程就已经开始了
                    if (i == 5) {
                        Thread.yield();
                    }
                }
            }
        };
        Thread t1 = new Thread(yieldTask, "A");
        Thread t2 = new Thread(yieldTask, "B");
        t1.start();
        t2.start();
    }

}
