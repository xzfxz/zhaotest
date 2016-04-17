package com.zhao.dotest.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

/**
 * Created by zhao on 2016/4/17.
 */
public class WarehouseServer {
    public static void main(String[] args){
        System.out.println("constructing server method......");
        try {
            Warehouse warehouse = new WarehouseImpl();
            System.out.println("binding server to registry");
            Context context;
            context = new InitialContext();
            try {
                context.bind("rmi:warehouseServer",warehouse);
            } catch (NamingException e) {
                e.printStackTrace();
            }
            System.out.println("waiting for client invoking");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
