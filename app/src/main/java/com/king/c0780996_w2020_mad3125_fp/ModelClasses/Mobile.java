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

    @Override
    public Double billCalculate()
    {
        double monthlyBill = 0.0;
        double minutePrice = 0.0;
        double dataPrice = 0.0;

        if (minutesUsed < 300)
        {
            minutePrice += 35 ;
        }
        else if (minutesUsed > 300 && minutesUsed < 500)
        {
            minutePrice += 50;
        }
        else
        {
            minutePrice = (int)0.15 * minutesUsed;
        }

        if (mobGbUsed < 5)
        {
            dataPrice += 50 ;
        }
        else if (mobGbUsed > 5 && mobGbUsed < 10)
        {
            dataPrice += 85;
        }
        else
        {
            dataPrice = 9.75 * mobGbUsed;
        }

        monthlyBill = minutePrice + dataPrice;
        return monthlyBill;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName)
    {
        this.manufacturerName = manufacturerName;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Integer getMobGbUsed() {
        return mobGbUsed;
    }

    public void setMobGbUsed(Integer mobGbUsed) {
        this.mobGbUsed = mobGbUsed;
    }

    public Integer getMinute() {
        return minutesUsed;
    }

    public void setMinute(Integer minute) {
        this.minutesUsed = minute;
    }
}
