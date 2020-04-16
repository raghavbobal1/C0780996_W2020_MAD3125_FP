package com.king.c0780996_w2020_mad3125_fp.ModelClasses;

import org.joda.time.LocalDate;

public class Internet extends Bill {
    private String providerName;
    private Double gbUsed;

    public Internet(String billId, LocalDate billDate, BillType billType, String providerName, Double gbUsed) {
        super(billId, billDate, billType);
        this.providerName = providerName;
        this.gbUsed = gbUsed;
        this.billTotal = billCalculate();
    }

}