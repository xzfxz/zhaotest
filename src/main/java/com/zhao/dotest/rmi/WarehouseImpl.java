package com.zhao.dotest.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhao on 2016/4/17.
 */
public class WarehouseImpl extends UnicastRemoteObject implements Warehouse{
    private Map<String,Double> prices;

    public WarehouseImpl() throws RemoteException {
        super();
        prices = new HashMap<String, Double>();
        prices.put("apple",22.33);
        prices.put("pare",11.22);

    }
    public double getPrice(String desc) throws RemoteException {
        Double aDouble = prices.get(desc);
        return aDouble==null?0:aDouble;
    }
}
