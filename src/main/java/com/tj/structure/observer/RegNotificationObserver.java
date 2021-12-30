package com.tj.structure.observer;

public class RegNotificationObserver  {


  @Subscribe
  public void handleRegSuccess(Long userId) {
    System.out.println("RegNotificationObserver handleRegSuccess... userId: "+userId);
  }
}