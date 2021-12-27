package com.tj.structure.Decorator;

/**
 * 4、定义微信通知
 */
public class WeChatNotifier extends NotifierDecorator {

    public WeChatNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String msg) {
        System.out.println(" --WeChatNotifier-- :"+msg);
        super.send(msg);
    }



}
