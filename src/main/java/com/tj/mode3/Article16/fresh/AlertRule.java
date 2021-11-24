package com.tj.mode3.Article16.fresh;


/**
 * 存储告警规则
 */
public class AlertRule {

    public Rule getMatchedRule(String api) {
        return new Rule().getRule(api);
    }
}
