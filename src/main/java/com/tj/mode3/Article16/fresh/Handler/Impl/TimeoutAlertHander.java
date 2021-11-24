package com.tj.mode3.Article16.fresh.Handler.Impl;

import com.tj.mode3.Article16.fresh.AlertRule;
import com.tj.mode3.Article16.fresh.ApiStatInfo;
import com.tj.mode3.Article16.fresh.Handler.AlertHandler;
import com.tj.mode3.Article16.fresh.Notification;
import com.tj.mode3.Article16.fresh.constant.NotificationEmergencyLevel;

public class TimeoutAlertHander extends AlertHandler {

    public TimeoutAlertHander(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getTimeoutCount() / apiStatInfo.getDurationOfSeconds();

        if (tps > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTimeoutTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
    }
}
