package com.tj.structure.chainResponsibility;

public class HandlerB extends Handler {
    @Override
    public void handle() {
        boolean handled = false;
        //...
        System.out.println("HandlerB");
        if (!handled && successor != null) {
            System.out.println("HandlerB handle() ");
            successor.handle();
        }
    }
}