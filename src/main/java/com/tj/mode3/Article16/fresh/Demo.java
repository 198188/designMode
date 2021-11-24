package com.tj.mode3.Article16.fresh;

public class Demo {
  public static void main(String[] args) {
    ApiStatInfo apiStatInfo = new ApiStatInfo();
    // ... 省略 apiStatInfo 的 set 字段代码
    apiStatInfo.setTimeoutCount(289); // 改动四：设置 tiemoutCount 值
    ApplicationContext.getInstance().getAlert().check(apiStatInfo);
  }
}