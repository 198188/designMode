package com.tj.structure.observer;

public class RegPromotionObserver {

  private PromotionService promotionService; // 依赖注入


  public RegPromotionObserver() {
    promotionService = new PromotionService();
  }

  @Subscribe
  public void handleRegSuccess(Long userId) {
    System.out.println("RegPromotionObserver handleRegSuccess...userId:"+userId);
    // promotionService.issueNewUserExperienceCash(userId);
  }
}