package com.tj.structure.observer;

public class UserService {

  public long register(String telephone, String password) {
    Long aLong = Long.valueOf(telephone);
    System.out.println("register long:"+aLong );
    return aLong;
  }
}
