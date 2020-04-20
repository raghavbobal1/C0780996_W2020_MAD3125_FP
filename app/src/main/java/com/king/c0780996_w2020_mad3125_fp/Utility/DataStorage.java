package com.king.c0780996_w2020_mad3125_fp.Utility;

import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Customer;
import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Hydro;
import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Internet;
import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Mobile;

import java.util.ArrayList;
import java.util.HashMap;

public class DataStorage
{
    private static DataStorage repoObj = new DataStorage();
    public static DataStorage getInstance() {
        return repoObj;
    }
    private DataStorage() { }
    private HashMap<String, Customer> customerMap = new HashMap<>();
    private ArrayList<Mobile> mobileBills = new ArrayList<>();
    private ArrayList<Hydro> hydroBills = new ArrayList<>();
    private ArrayList<Internet> internetBills = new ArrayList<>();

    public HashMap getCustomerMap(){
        return this.customerMap;
    }

