package com.tj.structure.chainResponsibility;

public class HandlerA extends Handler {
    @Override
    public void handle() {
        boolean handled = false;
        //...
        System.out.println("HandlerA");
        if (!handled && successor != null) {
            System.out.println("HandlerA handle()");
            successor.handle();
        }
    }
}