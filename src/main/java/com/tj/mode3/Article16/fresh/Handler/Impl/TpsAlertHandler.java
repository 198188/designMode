package com.tj.mode3.Article16.fresh.Handler.Impl;

import com.tj.mode3.Article16.fresh.AlertRule;
import com.tj.mode3.Article16.fresh.ApiStatInfo;
import com.tj.mode3.Article16.fresh.Handler.AlertHandler;
import com.tj.mode3.Article16.fresh.Notification;
import com.tj.mode3.Article16.fresh.constant.NotificationEmergencyLevel;

public class TpsAlertHandler extends AlertHandler {
  public TpsAlertHandler(AlertRule rule, Notification notification) {
    super(rule, notification);
  }

  @Override
  public void check(ApiStatInfo apiStatInfo) {
    long tps = apiStatInfo.getRequestCount()/ apiStatInfo.getDurationOfSeconds();
    if (tps > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTps()) {
      notification.notify(NotificationEmergencyLevel.URGENCY, "...");
    }
  }
}