package com.tj.combat.one.ratelimiter.rule.parser;

import com.tj.combat.one.ratelimiter.rule.RuleConfig;

import java.io.InputStream;

public interface RuleConfigParser {
  RuleConfig parse(String configText);
  RuleConfig parse(InputStream in);
}