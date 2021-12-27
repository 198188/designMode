package com.tj.structure.Decorator;

/**
 * 5、定义QQ通知
 */
public class QQNotifier extends NotifierDecorator{


    public QQNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String msg) {
        System.out.println(" --QQNotifier-- :"+msg);
        super.send(msg);
    }
}
