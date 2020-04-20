package com.king.c0780996_w2020_mad3125_fp.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Bill;
import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Hydro;
import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Internet;
import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Mobile;
import com.king.c0780996_w2020_mad3125_fp.R;
import com.king.c0780996_w2020_mad3125_fp.Utility.Validations;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BillInfoActivity extends AppCompatActivity {
    @BindView(R.id.billIdText) TextView billIdText;
    @BindView(R.id.dateText) TextView dateText;
    @BindView(R.id.dataUsedtext) TextView dataUsedtext;
    @BindView(R.id.manufacturerText) TextView manufacturerText;
    @BindView(R.id.planNameText) TextView planNameText;
    @BindView(R.id.minutesUsedText) TextView minutesUsedText;
    @BindView(R.id.billAmountText) TextView billAmountText;
    @BindView(R.id.billTypeImg) ImageView billTypeImg;
    @BindView(R.id.text4) TextView text4;
    @BindView(R.id.text5) TextView text5;
    @BindView(R.id.text6) TextView text6;
    @BindView(R.id.text7) TextView text7;
    @BindView(R.id.textBillType) TextView textBillType;
    @BindView(R.id.btnHome)
    Button btnHome;
    Bill billObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_info);
        ButterKnife.bind(this);

        btnHome.setVisibility(View.INVISIBLE);
        ActionBar mAction = getSupportActionBar();
        mAction.setTitle("Detailed Bill View");

        Intent mIntent = getIntent();
        billObj = (Bill) mIntent.getSerializableExtra("BillObj");

        if(billObj.getBillId().contains("MB"))
        {
            Mobile m = (Mobile) billObj;
            billIdText.setText(m.getBillId());
            dateText.setText(m.getBillDate().toString());
            dataUsedtext.setText(Validations.getInstance().gbFormatter(m.getMobGbUsed()));
            manufacturerText.setText(m.getManufacturerName());
            planNameText.setText(m.getPlanName());
            minutesUsedText.setText(Validations.getInstance().minsFormatter(m.getMinute().toString()));
            billAmountText.setText(Validations.getInstance().doubleFormatter(m.getBillTotal()));
            billTypeImg.setImageResource(R.drawable.mob_icon);
            dataUsedtext.setVisibility(View.VISIBLE);
            minutesUsedText.setVisibility(View.VISIBLE);
            text4.setText("Manufacturer");
            text5.setText("Plan Name");
            textBillType.setText("YOUR MOBILE BILL");
        }
        if(billObj.getBillId().contains("HY"))
        {
            Hydro h = (Hydro) billObj;
            billIdText.setText(h.getBillId());
            dateText.setText(h.getBillDate().toString());
            planNameText.setText(Validations.getInstance().gbFormatter(h.getUnitsUsed()));
            manufacturerText.setText(h.getAgencyName());
            billAmountText.setText(Validations.getInstance().doubleFormatter(h.getBillTotal()));
            billTypeImg.setImageResource(R.drawable.hydro_icon);
            text4.setText("Agency Name");
            text5.setText("Units Used");
            textBillType.setText("YOUR HYDRO BILL");
            removeFields();
        }
        if(billObj.getBillId().contains("IN"))
        {
            Internet i = (Internet) billObj;
            billIdText.setText(i.getBillId());
            dateText.setText(i.getBillDate().toString());
            planNameText.setText(Validations.getInstance().doubleFormatter(i.getGbUsed()));
            manufacturerText.setText(i.getProviderName());
            billAmountText.setText(Validations.getInstance().doubleFormatter(i.getBillTotal()));
            billTypeImg.setImageResource(R.drawable.int_icon);
            text4.setText("Provider Name");
            text5.setText("Data Used");
            textBillType.setText("YOUR INTERNET BILL");
            removeFields();
        }

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(BillInfoActivity.this, CustomerListActivity.class);
                startActivity(mIntent);
            }
        });
    }

    public void removeFields()
    {
        dataUsedtext.setVisibility(View.INVISIBLE);
        minutesUsedText.setVisibility(View.INVISIBLE);
        text6.setVisibility(View.INVISIBLE);
        text7.setVisibility(View.INVISIBLE);
    }
}
