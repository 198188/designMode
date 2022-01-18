package com.tj.combat.one.ratelimiter.alg;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FixedTimeWinRateLimitAlg extends RateLimitAlg {
    private AtomicInteger currentCount = new AtomicInteger(0);
    private static final long TRY_LOCK_TIMEOUT = 200L;  // 200ms.
    private Lock lock = new ReentrantLock();

    public FixedTimeWinRateLimitAlg(int limit) {
        super(limit, Stopwatch.createStarted());
    }

    @Override
    public boolean tryAcquire() throws Exception {
        int updatedCount = currentCount.incrementAndGet();
        if (updatedCount <= limit) {
            return true;
        }
        try {
            if (lock.tryLock(TRY_LOCK_TIMEOUT, TimeUnit.MILLISECONDS)) {
                try {
                    // 以秒为单位返回此Stopwatch经过时间Duration
                    if (stopwatch.elapsed(TimeUnit.MILLISECONDS) > TimeUnit.SECONDS.toMillis(1)) {
                        currentCount.set(0);
                        stopwatch.reset();
                    }
                    updatedCount = currentCount.incrementAndGet();
                    return updatedCount <= limit;
                } finally {
                    lock.unlock();
                }
            } else {
                throw new Exception("tryAcquire() wait lock too long:" + TRY_LOCK_TIMEOUT + "ms");
            }
        } catch (InterruptedException e) {
            throw new InterruptedException("tryAcquire() is interrupted by lock-time-out." + e);
        }
    }

}
