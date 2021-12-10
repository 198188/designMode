package com.tj.mode4.Article29;


public class RedisDistributedLock {

    private SingletonIntance singletonIntance;

    public static SingletonIntance getSingletonIntance() {
        return new SingletonIntance();
    }
}

class SingletonIntance {

    public boolean lockTransction(String id) {
        return true;
    }

    public void unlockTransction(String id) {
    }
}
