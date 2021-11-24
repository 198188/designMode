package com.tj.mode3.Article16.fresh;

public class ApiStatInfo {// 省略 constructor/getter/setter 方法
  private String api;
  private long requestCount;
  private long errorCount;
  private long durationOfSeconds;

  // 第一处改动
  private long timeoutCount;

  public long getTimeoutCount() {
    return timeoutCount;
  }

  public String getApi() {
    return api;
  }

  public long getRequestCount() {
    return requestCount;
  }

  public long getErrorCount() {
    return errorCount;
  }

  public long getDurationOfSeconds() {
    return durationOfSeconds;
  }

  public void setTimeoutCount(int timeoutCount) {
    this.timeoutCount = timeoutCount;
  }
}