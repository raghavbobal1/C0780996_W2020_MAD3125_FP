package com.king.c0780996_w2020_mad3125_fp.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Bill;
import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Customer;
import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Hydro;
import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Mobile;
import com.king.c0780996_w2020_mad3125_fp.R;
import com.king.c0780996_w2020_mad3125_fp.Utility.Validations;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddNewBillActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    @BindView(R.id.spinnerBillType) Spinner spinnerBillType;
    @BindView(R.id.editBillId) TextInputLayout editBillId;
    @BindView(R.id.editBillIdtext) TextInputEditText editBillIdtext;
    @BindView(R.id.editPhoneNumber) TextInputLayout editPhoneNumber;
    @BindView(R.id.editPhoneNumberText) TextInputEditText editPhoneNumberText;
    @BindView(R.id.editBillDate) TextInputLayout editBillDate;
    @BindView(R.id.editBillDateText) TextInputEditText editBillDateText;
    @BindView(R.id.editDataUsed) TextInputLayout editDataUsed;
    @BindView(R.id.editDataUsedText) TextInputEditText editDataUsedText;
    @BindView(R.id.editMinsUsed) TextInputLayout editMinsUsed;
    @BindView(R.id.editMinsUsedText) TextInputEditText editMinsUsedText;
    @BindView(R.id.editManufacturerName) TextInputLayout editManufacturerName;
    @BindView(R.id.editManufacturerNameText) TextInputEditText editManufacturerNameText;
    @BindView(R.id.editPlanName) TextInputLayout editPlanName;
    @BindView(R.id.editPlanNameText) TextInputEditText editPlanNameText;
    @BindView(R.id.editUnitsUsed) TextInputLayout editUnitsUsed;
    @BindView(R.id.editUnitsUsedtext) TextInputEditText editUnitsUsedtext;
    @BindView(R.id.editAgencyName) TextInputLayout editAgencyName;
    @BindView(R.id.editAgencyNameText) TextInputEditText editAgencyNameText;
    @BindView(R.id.buttonAddBill) Button buttonAddBill;
    @BindView(R.id.buttonAddBill) Button buttonClearFields;

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    Customer customerObj2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_bill);
        ButterKnife.bind(this);

        Intent mIntent = getIntent();
        customerObj2 = mIntent.getParcelableExtra("CustomerBills2");

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.hide();

        ArrayList<String> billType = new ArrayList<>();
        billType.add("MOBILE");
        billType.add("HYDRO");
        billType.add("INTERNET");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, billType);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBillType.setAdapter(dataAdapter);

        spinnerBillType.setOnItemSelectedListener(this);

        buttonClearFields.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearfields();
            }
        });

        addingDatePicker();
    }

  