package net.nitroservices.algodsrealtimeperformance.RunTimeComplexity;

import java.util.concurrent.TimeUnit;

/**
 * Created by rezan on 8/28/17.
 */

class Watch {

    private long startTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public long getTime() {
        return TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
    }

}
