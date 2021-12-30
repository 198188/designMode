package com.tj.structure.observer;

import java.util.ArrayList;
import java.util.List;

public class TestClient {

  public static void main(String[] args) {
    UserController controller = new UserController();

    List<Object> observers = new ArrayList<>();
    observers.add(new RegPromotionObserver());
    observers.add(new RegNotificationObserver());

    controller.setRegObservers(observers);
    controller.register("2123", "xxx");


    try {
      Thread.sleep(1000);
    } catch (Exception e) {
      e.printStackTrace();
    }

    controller.register("888", "xxx");


  }
}