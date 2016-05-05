package com.zhao.dotest.threadtest;


/**
 * Created by zhao on 2016/4/22.
 */
public class DoTest {

    public static void main(String[] args) {
        Ticket ticket = new Ticket(100);
        SellTicket sellTicket = new SellTicket(ticket);
        new Thread(sellTicket,"aa").start();
        new Thread(sellTicket,"bb").start();
    }
}
