package com.tj.mode3.Article16.fresh;

public class Rule {

    private long maxTps;

    private long maxErrorCount;

    private long maxTimeoutTps;

    public Rule getRule (String api) {
        return new Rule();
    }

    public long getMaxTps() {
        return maxTps;
    }

    public long getMaxErrorCount() {
        return maxErrorCount;
    }

    public long getMaxTimeoutTps() {
        return maxTimeoutTps;
    }
}
