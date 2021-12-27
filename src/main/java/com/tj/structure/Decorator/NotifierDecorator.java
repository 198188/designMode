package com.tj.structure.Decorator;

/**
 * 3、抽象基础通知
 */
public class NotifierDecorator implements Notifier{

    private Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String msg) {
        this.notifier.send(msg);
    }
}
