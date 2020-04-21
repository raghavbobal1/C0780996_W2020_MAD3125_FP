package com.king.c0780996_w2020_mad3125_fp.Utility;

import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Bill;
import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Customer;
import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Hydro;
import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Internet;
import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Mobile;
import com.king.c0780996_w2020_mad3125_fp.R;

import java.util.ArrayList;
import java.util.HashMap;

public class DataStorage {
    private static DataStorage repoObj = new DataStorage();

    public static DataStorage getInstance() {
        return repoObj;
    }

    private DataStorage() {
    }

    private HashMap<String, Customer> customerMap = new HashMap<>();
    private ArrayList<Mobile> mobileBills = new ArrayList<>();
    private ArrayList<Hydro> hydroBills = new ArrayList<>();
    private ArrayList<Internet> internetBills = new ArrayList<>();

    public HashMap getCustomerMap() {
        return this.customerMap;
    }

    public void loadData() {
        Customer c4 = new Customer("004",
                "Raghav",
                "Bobal",
                "Male",
                "raghav@gmail.com",
                "rgv",
                "raghav",
                "13/07/1997",
                "Delhi,India", R.drawable.raghav_icon);
        Customer c2 = new Customer("002",
                "Prakash",
                "Rana",
                "Male",
                "prana@gmail.com",
                "Rana",
                "rana",
                "27/04/1995",
                "Kathmandu, Nepal", R.drawable.prana_icon);
        Customer c3 = new Customer("003",
                "Kush",
                "Bhatia",
                "Male",
                "kush@gmail.com",
                "kbhatia",
                "1234qwer",
                "21/07/1997",
                "Delhi,India", R.drawable.kush_icon);

        Customer c1 = new Customer("001",
                "Sagar",
                "Panday",
                "Male",
                "majnu@gmail.com",
                "majju",
                "12345",
                "18/09/1976",
                "Dubai,UAE", R.drawable.majju_icon);

        Mobile m1 = new Mobile("MB001",
                org.joda.time.LocalDate.now(),
                Bill.BillType.Mobile,
                "ROGERS",
                "Student Plan",
                "6479370707",
                5,
                600);
        Mobile m2 = new Mobile("MB002",
                org.joda.time.LocalDate.now(),
                Bill.BillType.Mobile,
                "FREEDOM",
                "Business Plan",
                "6545677876",
                16,
                1400);
        Hydro h1 = new Hydro("HY001",
                org.joda.time.LocalDate.now(),
                Bill.BillType.Hydro,
                "TORONTO HYDRO",
                450);
        Hydro h2 = new Hydro("HY002",
                org.joda.time.LocalDate.now(),
                Bill.BillType.Hydro,
                "HYDRO POWER",
                780);
        Internet in1 = new Internet("IN001",
                org.joda.time.LocalDate.now(),
                Bill.BillType.Internet,
                "BELL",
                18.9);
        Internet in2 = new Internet("IN002",
                org.joda.time.LocalDate.now(),
                Bill.BillType.Internet,
                "FIDO",
                14.9);

        c1.addBill("IN001", in1);
        c1.addBill("MB001", m1);
        c1.addBill("HY001", h1);
        c2.addBill("IN002", in2);
        c2.addBill("HY002",h2);
        c3.addBill("MB002",m2);

        mobileBills.add(m1);
        hydroBills.add(h1);
        internetBills.add(in1);
        internetBills.add(in2);
        customerMap.put(c1.getCustomerId(), c1);
        customerMap.put(c2.getCustomerId(), c2);
        customerMap.put(c3.getCustomerId(), c3);
        customerMap.put(c4.getCustomerId(), c4);
    }
}