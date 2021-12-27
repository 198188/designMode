package com.tj.structure.Decorator;

/**
 * 2、定义基础通知： 控制台打印
 */
public class BaseDecorator implements Notifier{

    private String msg;

    public BaseDecorator(String msg) {
        this.msg = msg;
    }

    @Override
    public void send(String msg) {
        System.out.println(" --BaseDecorator-- :"+msg);
    }
}
