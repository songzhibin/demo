package com.song.demo.web;

import com.song.demo.entity.TeamDto;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Object obj = new Object();
                synchronized (obj){
                    try {
                        obj.wait();

                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        obj.notify();
                    }
                }

                TeamDto paramQueryDto = new TeamDto();
                synchronized (paramQueryDto){
                    try {
                        Thread.sleep(100l);
                    }catch (Exception e){

                    }
                }

                lock.writeLock().lock();
                System.out.println("Thread real execute");
                lock.writeLock().unlock();
            }
        });

        t.setDaemon(true);
        boolean daemon = t.isDaemon();
        System.out.println(daemon);


        lock.writeLock().lock();
        lock.writeLock().unlock();

        lock.writeLock().lock();
        t.start();
        Thread.sleep(200);

        System.out.println("realse one once");
        lock.writeLock().unlock();


    }
}
