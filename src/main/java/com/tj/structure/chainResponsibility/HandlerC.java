package com.tj.structure.chainResponsibility;

public class HandlerC extends Handler {
    @Override
    public void handle() {
        boolean handled = false;
        //...
        System.out.println("HandlerC");
        if (!handled && successor != null) {
            System.out.println("HandlerC handle() ");
            successor.handle();
        }
    }
}