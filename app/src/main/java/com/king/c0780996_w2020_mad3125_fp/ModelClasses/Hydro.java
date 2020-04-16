package com.king.c0780996_w2020_mad3125_fp.ModelClasses;

import org.joda.time.LocalDate;

public class Hydro extends Bill
{
    private String agencyName;
    private Integer unitsConsumed;

    public Hydro(String billId, LocalDate billDate, BillType billType, String agencyName, Integer unitsUsed){
        super(billId, billDate, billType);
        this.agencyName = agencyName;
        this.unitsConsumed = unitsUsed;
        this.billTotal = billCalculate();
    }

   
}