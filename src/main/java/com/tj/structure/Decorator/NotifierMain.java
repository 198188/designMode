package com.tj.structure.Decorator;


/**
 * 8、组合 main函数
 */
public class NotifierMain {

    public static void main(String[] args) {


        String msg = " ***发生了错误!";

        Notifier baseNotifier = new BaseDecorator(msg);

        Notifier weChatNotifier = new WeChatNotifier(baseNotifier);

        Notifier qqNotifier = new QQNotifier(weChatNotifier);

        Notifier smsNotifier = new SMSNotifier(qqNotifier);

        smsNotifier.send(msg);


    }
}
