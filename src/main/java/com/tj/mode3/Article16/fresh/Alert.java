package com.tj.mode3.Article16.fresh;

import com.tj.mode3.Article16.fresh.Handler.AlertHandler;

import java.util.ArrayList;
import java.util.List;

public class Alert {
  private List<AlertHandler> alertHandlers = new ArrayList<>();
  
  public void addAlertHandler(AlertHandler alertHandler) {
    this.alertHandlers.add(alertHandler);
  }

  public void check(ApiStatInfo apiStatInfo) {

    for (AlertHandler handler : alertHandlers) {
      handler.check(apiStatInfo);
    }

  }
}