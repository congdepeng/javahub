package com.depeng.dynamic_proxy;

public class BookFacadeImpl implements BookFacade {
    @Override
    public void addBook() {
        System.out.println("Call BookFacadeImpl.addBook()... ");
    }
}
