package com.tj.combat.one.ratelimiter;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import com.tj.combat.one.ratelimiter.alg.FixedTimeWinRateLimitAlg;
import com.tj.combat.one.ratelimiter.alg.RateLimitAlg;
import com.tj.combat.one.ratelimiter.rule.ApiLimit;
import com.tj.combat.one.ratelimiter.rule.RateLimitRule;
import com.tj.combat.one.ratelimiter.rule.RuleConfig;
import com.tj.combat.one.ratelimiter.rule.TrieRateLimitRule;
import com.tj.combat.one.ratelimiter.rule.datasource.FileRuleConfigSource;
import com.tj.combat.one.ratelimiter.rule.datasource.RuleConfigSource;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter {
    private static final Logger log = LoggerFactory.getLogger(RateLimiter.class);
    // 为每个api在内存中存储限流计数器
    private ConcurrentHashMap<String, RateLimitAlg> counters = new ConcurrentHashMap<>();
    private RateLimitRule rule;

    public RateLimiter() {
/*        // 将限流规则配置文件ratelimiter-rule.yaml中的内容读取到RuleConfig中
        InputStream in = null;
        RuleConfig ruleConfig = null;
        try {
            in = this.getClass().getResourceAsStream("/ratelimiter-rule.yaml");
            if (in != null) {
                Yaml yaml = new Yaml();
                ruleConfig = yaml.loadAs(in, RuleConfig.class);
            }
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    log.error("close file error:{}", e);
                }
            }
        }
        // 将限流规则构建成支持快速查找的数据结构RateLimitRule
        this.rule = new RateLimitRule(ruleConfig);*/
        //改动主要在这里：调用RuleConfigSource类来实现配置加载
        RuleConfigSource configSource = new FileRuleConfigSource();
        RuleConfig ruleConfig = configSource.load();
        this.rule = new TrieRateLimitRule(ruleConfig);
    }

    public boolean limit(String appId, String url) throws Exception {
        ApiLimit apiLimit = rule.getLimit(appId, url);
        if (apiLimit == null) {
            return true;
        }
        // 获取api对应在内存中的限流计数器（rateLimitCounter）
        String counterKey = appId + ":" + apiLimit.getApi();
        RateLimitAlg rateLimitCounter = counters.get(counterKey);
        if (rateLimitCounter == null) {
            RateLimitAlg newRateLimitCounter = new FixedTimeWinRateLimitAlg(apiLimit.getLimit());
            rateLimitCounter = counters.putIfAbsent(counterKey, newRateLimitCounter);
            if (rateLimitCounter == null) {
                rateLimitCounter = newRateLimitCounter;
            }
        }
        // 判断是否限流
        return rateLimitCounter.tryAcquire();
    }
}