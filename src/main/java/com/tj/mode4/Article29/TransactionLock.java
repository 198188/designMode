package com.tj.mode4.Article29;

public class TransactionLock {
  public boolean lock(String id) {
    return RedisDistributedLock.getSingletonIntance().lockTransction(id);
  }
  
  public void unlock(String id) {
    RedisDistributedLock.getSingletonIntance().unlockTransction(id);
  }
}