package com.tj.mode3.Article16.fresh;

import com.tj.mode3.Article16.fresh.Handler.Impl.ErrorAlertHandler;
import com.tj.mode3.Article16.fresh.Handler.Impl.TimeoutAlertHander;
import com.tj.mode3.Article16.fresh.Handler.Impl.TpsAlertHandler;

/**
 * 负责 Alert 的创建、组装（alertRule 和 notification 的依赖注入）、初始化（添加 handlers）工作
 */
public class ApplicationContext {
  /**
   * 添加上面讲到的那个新功能，每秒钟接口超时请求个数超过某个最大阈值就告警
   * 第一处改动是：在 ApiStatInfo 类中添加新的属性 timeoutCount。
   * 第二处改动是：添加新的 TimeoutAlertHander 类。
   * 第三处改动是：在 ApplicationContext 类的 initializeBeans() 方法中，往 alert 对象中注册新的 timeoutAlertHandler。
   * 第四处改动是：在使用 Alert 类的时候，需要给 check() 函数的入参 apiStatInfo 对象设置 timeoutCount 的值。
   */


  private AlertRule alertRule;
  private Notification notification;
  private Alert alert;
  
  public void initializeBeans() {
    alertRule = new AlertRule(/*. 省略参数.*/); // 省略一些初始化代码
    notification = new Notification(/*. 省略参数.*/); // 省略一些初始化代码

    alert = new Alert();

    alert.addAlertHandler(new TpsAlertHandler(alertRule, notification));
    alert.addAlertHandler(new ErrorAlertHandler(alertRule, notification));
    // 第三处
    alert.addAlertHandler(new TimeoutAlertHander(alertRule, notification));
  }

  public Alert getAlert() {
    return alert;
  }

  // 饿汉式单例
  private static final ApplicationContext instance = new ApplicationContext();

  private ApplicationContext() {
    instance.initializeBeans();
  }

  public static ApplicationContext getInstance() {
    return instance;
  }
}