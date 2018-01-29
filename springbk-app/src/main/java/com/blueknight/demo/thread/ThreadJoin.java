package com.blueknight.demo.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by liuyang on 2017/9/6.
 */
public class ThreadJoin {


    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("Sleepy", 3000);
        Joiner dopey = new Joiner("Dopey", sleepy);

        Sleeper grumpy = new Sleeper("Grumpy", 3000);
        Joiner doc = new Joiner("Doc", grumpy);

        grumpy.interrupt();
    }
}

class Sleeper extends Thread{
    private long time;

    public Sleeper(String name, long time) {
        super(name);
        this.time = time;
        start();
    }

    @Override
    public void run() {
        try {
            System.out.println(getName()+" before sleep.");
            TimeUnit.MILLISECONDS.sleep(time);
            System.out.println(getName()+" is asleep.");
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted. " + " isInterrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened.");
    }
}

class Joiner extends Thread{
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            System.out.println(getName()+" before join.");
            this.sleeper.join();
            System.out.println(getName() + " after join.");
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted.");
        }
        System.out.println(getName() + " join completed.");
    }
}
