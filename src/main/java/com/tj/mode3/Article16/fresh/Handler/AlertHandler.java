package com.tj.mode3.Article16.fresh.Handler;

import com.tj.mode3.Article16.fresh.AlertRule;
import com.tj.mode3.Article16.fresh.ApiStatInfo;
import com.tj.mode3.Article16.fresh.Notification;

public abstract class AlertHandler {
  protected AlertRule rule;
  protected Notification notification;

  public AlertHandler(AlertRule rule, Notification notification) {
    this.rule = rule;
    this.notification = notification;
  }

  public abstract void check(ApiStatInfo apiStatInfo);
}