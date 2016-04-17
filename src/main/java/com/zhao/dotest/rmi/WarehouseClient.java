package com.zhao.dotest.rmi;

import javax.naming.*;
import java.rmi.RemoteException;

/**
 * Created by zhao on 2016/4/17.
 */
public class WarehouseClient {
    public static void main(String[] args) throws NamingException {
        Context context = new InitialContext();
        System.out.println("RMi registry bingdings: ");
        NamingEnumeration<NameClassPair> list = context.list("rmi://localhost/");
        while (list.hasMoreElements()){
            System.out.println(list.next().getName());
            String url = "rmi://localhost/warehouseServer";
            Warehouse lookup = (Warehouse) context.lookup(url);
            String desc = "apple";
            try {
                double price = lookup.getPrice(desc);
                System.out.println("price:"+price);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

    }
}
