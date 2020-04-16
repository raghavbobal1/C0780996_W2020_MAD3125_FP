package com.king.c0780996_w2020_mad3125_fp.ModelClasses;

import org.joda.time.LocalDate;

public class Hydro extends Bill
{
    private String agencyName;
    private Integer unitsConsumed;

    public Hydro(String billId, LocalDate billDate, BillType billType, String agencyName, Integer unitsConsumed)
    {
        super(billId, billDate, billType);
        this.agencyName = agencyName;
        this.unitsConsumed = unitsConsumed;
        this.billTotal = billCalculate();
    }

    @Override
    public Double billCalculate()
    {
        double price = 0.0;
        double hydroAmt = 0.0;
        if (unitsConsumed < 60)
        {
            price += 150;
        }
        else if(unitsConsumed > 600 && unitsConsumed <= 800)
        {
            price += 215;
        }
        else if (unitsConsumed > 800 && unitsConsumed < 1000)
        {
            price += 300;
        }
        else
        {
            price = 0.75 * unitsConsumed;
        }
        hydroAmt = price ;
        return hydroAmt;
    }


    public String getAgencyName()
    {
        return agencyName;
    }

    public void setAgencyName(String agencyName)
    {
        this.agencyName = agencyName;
    }

    public Integer getUnitsUsed()
    {
        return unitsConsumed;
    }

    public void setUnitsUsed(Integer unitsConsumed)
    {
        this.unitsConsumed = unitsConsumed;
    }

}