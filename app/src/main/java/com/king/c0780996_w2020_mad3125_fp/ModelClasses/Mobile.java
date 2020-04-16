package com.king.c0780996_w2020_mad3125_fp.ModelClasses;

import org.joda.time.LocalDate;

public class Mobile extends Bill {

    String manufacturerName;
    String planName;
    String mobileNumber;
    Integer mobGbUsed;
    Integer minutesUsed;

    public Mobile(String billId, LocalDate billDate, BillType billType, String manufacturerName, String planName, String mobileNumber, Integer mobGbUsed, Integer minutesUsed)
    {
        super(billId, billDate, billType);
        this.manufacturerName = manufacturerName;
        this.planName = planName;
        this.mobileNumber = mobileNumber;
        this.mobGbUsed = mobGbUsed;
        this.minutesUsed = minutesUsed;
        this.billTotal = billCalculate();
    }

}