package com.king.c0780996_w2020_mad3125_fp.ModelClasses;

import org.joda.time.LocalDate;

public class Internet extends Bill
{
    private String providerName;
    private Double gbUsed;

    public Internet(String billId, LocalDate billDate, BillType billType, String providerName, Double gbUsed)
    {
        super(billId, billDate, billType);
        this.providerName = providerName;
        this.gbUsed = gbUsed;
        this.billTotal = billCalculate();
    }

    @Override
    public Double billCalculate(){
        double price = 0.0;
        if( gbUsed < 3)
        {
            price = 12.15 * gbUsed;
        }
        else if (gbUsed > 3 && gbUsed < 10)
        {
            price = 14.0 * gbUsed;
        }
        else
            {
            price = 15.15 * gbUsed;
            }
        return price;
    }

    public String getProviderName()
    {
        return providerName;
    }

    public void setProviderName(String providerName)
    {
        this.providerName = providerName;
    }

    public Double getGbUsed()
    {
        return gbUsed;
    }

    public void setGbUsed(Double gbUsed)
    {
        this.gbUsed = gbUsed;
    }
}


