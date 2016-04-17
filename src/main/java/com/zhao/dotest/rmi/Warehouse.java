package com.zhao.dotest.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by zhao on 2016/4/17.
 */
public interface Warehouse extends Remote {
    double getPrice(String desc) throws RemoteException;
}
