package com.tj.mode3.Article16.old;

import com.tj.mode3.Article16.old.constant.NotificationEmergencyLevel;

public class Alert {
  private AlertRule rule;
  private Notification notification;

  public Alert(AlertRule rule, Notification notification) {
    this.rule = rule;
    this.notification = notification;
  }

  public void check(String api, long requestCount, long errorCount, long durationOfSeconds) {
    long tps = requestCount / durationOfSeconds;
    if (tps > rule.getMatchedRule(api).getMaxTps()) {
      notification.notify(NotificationEmergencyLevel.URGENCY, "...");
    }
    if (errorCount > rule.getMatchedRule(api).getMaxErrorCount()) {
      notification.notify(NotificationEmergencyLevel.SEVERE, "...");
    }
  }

  /**
   * 现在，如果我们需要添加一个功能，当每秒钟接口超时请求个数，超过某个预先设置的最大阈值时，我们也要触发告警发送通知。
   * 这个时候，我们该如何改动代码呢？主要的改动有两处：
   * 第一处是修改 check() 函数的入参，添加一个新的统计数据 timeoutCount，表示超时接口请求数；
   * 第二处是在 check() 函数中添加新的告警逻辑。
   */
}