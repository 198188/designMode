package com.tj.mode3.Article16.fresh.Handler.Impl;

import com.tj.mode3.Article16.fresh.AlertRule;
import com.tj.mode3.Article16.fresh.ApiStatInfo;
import com.tj.mode3.Article16.fresh.Handler.AlertHandler;
import com.tj.mode3.Article16.fresh.Notification;
import com.tj.mode3.Article16.fresh.constant.NotificationEmergencyLevel;

public class ErrorAlertHandler extends AlertHandler {

  public ErrorAlertHandler(AlertRule rule, Notification notification){
    super(rule, notification);
  }


  @Override
  public void check(ApiStatInfo apiStatInfo) {
    if (apiStatInfo.getErrorCount() > rule.getMatchedRule(apiStatInfo.getApi()).getMaxErrorCount()) {
      notification.notify(NotificationEmergencyLevel.SEVERE, "...");
    }
  }

}