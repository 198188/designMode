package com.tj.combat.one.ratelimiter.rule.datasource;

import com.tj.combat.one.ratelimiter.rule.RuleConfig;

public interface RuleConfigSource {
    RuleConfig load();
}
