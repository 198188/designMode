package com.tj.combat.one.ratelimiter.alg;



import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 限流算法抽象类
 */
public abstract class RateLimitAlg {
  /* timeout for {@code Lock.tryLock() }. */

  protected Stopwatch stopwatch;
  protected int limit;

  public RateLimitAlg(int limit) {
    this(limit, Stopwatch.createStarted());
  }

  @VisibleForTesting
  RateLimitAlg(int limit, Stopwatch stopwatch) {
    this.limit = limit;
    this.stopwatch = stopwatch;
  }

  public boolean tryAcquire() throws Exception {
    return false;
  }
}