package com.dejavu.netty.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureCook {
    static void cook(Pig pig,Chicken chicken){}
    static class Pig{}
    static class Chicken{}

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        Callable<Pig> cookPig = new Callable<Pig>() {
            @Override
            public Pig call() throws Exception {
                System.out.println("cook");
                Thread.sleep(5000);
                return new Pig();
            }
        };
        FutureTask<Pig> task = new FutureTask<>(cookPig);
        new Thread(task).start();
        Thread.sleep(2000);
        Chicken chicken = new Chicken();
        if(!task.isDone()){
            System.out.println("not cooked");
        }
        Pig pig = task.get();
        cook(pig,chicken);
        System.out.println("time="+(System.currentTimeMillis()-startTime));

    }
}
