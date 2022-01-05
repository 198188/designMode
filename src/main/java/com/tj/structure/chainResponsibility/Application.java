package com.tj.structure.chainResponsibility;

import java.util.ArrayList;
import java.util.Iterator;

public class Application {
    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.addHandler(new HandlerC());
        chain.addHandler(new HandlerC());
        chain.handle();

    }
}