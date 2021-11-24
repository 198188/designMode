package com.tj.mode3.Article16.old;

public class Rule {

    private long maxTps;

    private long maxErrorCount;

    public Rule getRule (String api) {
        return new Rule();
    }

    public long getMaxTps() {
        return maxTps;
    }

    public long getMaxErrorCount() {
        return maxErrorCount;
    }
}
