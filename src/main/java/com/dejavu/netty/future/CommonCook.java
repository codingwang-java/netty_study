package com.dejavu.netty.future;

public class CommonCook {
    static void cook(Pig pig,Chicken chicken){}
    static class Pig{}
    static class Chicken{}
    static class CookPig extends Thread{
        private Pig pig;
        public void run() {
            System.out.println("cook pig");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //过5s准备好猪肉
            pig = new Pig();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        CookPig thread = new CookPig();
        thread.start();
        thread.join();
        Thread.sleep(2000);
        Chicken chicken = new Chicken();
        cook(thread.pig,chicken);
        System.out.println("time="+(System.currentTimeMillis()-startTime));
    }

}
