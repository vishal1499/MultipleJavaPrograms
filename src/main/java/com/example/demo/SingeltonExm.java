package com.example.demo;

import java.util.concurrent.locks.ReentrantLock;

public class SingeltonExm {

   volatile static SingeltonExm obj ;
   private static ReentrantLock lock = new ReentrantLock();
    private SingeltonExm(){

    }


    public static synchronized SingeltonExm getObj(){
        lock.lock();
            if (obj == null) {
                obj = new SingeltonExm();
            }
        lock.unlock();
        return obj;
    }
}
