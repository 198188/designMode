package com.tj.structure.Decorator;
/**
 * 6、定义邮件通知
 */
public class SMSNotifier extends NotifierDecorator{

    public SMSNotifier(Notifier notifier) {
        super(notifier);
    }
    @Override
    public void send(String msg) {
        System.out.println(" --SMSNotifier-- :"+msg);
        super.send(msg);
    }
}
