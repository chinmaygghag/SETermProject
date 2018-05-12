package com.example.demo.util;

import java.util.concurrent.atomic.AtomicLong;

public class UtilityClass {

    public long uniqueTimeStamp(){
        AtomicLong lastTimeMs = new AtomicLong();
        long now = System.currentTimeMillis();
        while (true){
            long lastTime = lastTimeMs.get();
            if (lastTime  >=now){
                now = lastTime + 1;
            }if (lastTimeMs.compareAndSet(lastTime,now))
                return now;
        }
    }

}
