package com.tj.combat.one.ratelimiter.rule;

public interface RateLimitRule {
  public ApiLimit getLimit(String appId, String api);
}
