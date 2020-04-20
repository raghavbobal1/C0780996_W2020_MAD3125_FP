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
import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Internet;
import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Mobile;
import com.king.c0780996_w2020_mad3125_fp.R;
import com.king.c0780996_w2020_mad3125_fp.Utility.Validations;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddNewBillActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
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
    @BindView(R.id.buttonClearFields) Button buttonClearFields;

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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
        ((TextView) parent.getChildAt(0)).setTextSize(18);
        ((TextView) parent.getChildAt(0)).setTypeface(null, Typeface.BOLD);

        if(position == 0)
        {
            initFields();
            clearfields();
            editUnitsUsed.setVisibility(View.INVISIBLE);
            editAgencyName.setVisibility(View.INVISIBLE);
            buttonAddBill.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean someFlag = false;
                    if(editBillIdtext.getText().toString().isEmpty())
                    {
                        editBillIdtext.setError("Enter Bill ID");
                        someFlag = true;
                        return;
                    }
                    if(editBillDateText.getText().toString().isEmpty()){
                        editBillDateText.setError("Enter Bill Date");
                        someFlag = true;
                        return;
                    }
                    if(editPhoneNumberText.getText().toString().isEmpty())
                    {
                        editPhoneNumberText.setError("Enter Phone Number");
                        someFlag = true;
                        return;
                    }
                    if(editDataUsedText.getText().toString().isEmpty())
                    {
                        editDataUsedText.setError("Enter Data Used");
                        someFlag = true;
                        return;
                    }
                    if(editMinsUsedText.getText().toString().isEmpty())
                    {
                        editMinsUsed.setError("Enter Minutes Used");
                        someFlag = true;
                        return;
                    }
                    if(editManufacturerNameText.getText().toString().isEmpty())
                    {
                        editManufacturerNameText.setError("Enter Manufacturer Name");
                        someFlag = true;
                        return;
                    }
                    if(editPlanNameText.getText().toString().isEmpty())
                    {
                        editPlanNameText.setError("Enter Plan Name");
                        someFlag = true;
                        return;
                    }
                    if(!Validations.getInstance().mobileValidation(editPhoneNumberText.getText().toString()))
                    {
                        editPhoneNumberText.setError("Invalid Phone number");
                        new MaterialAlertDialogBuilder(AddNewBillActivity.this)
                                .setTitle("Invalid phone number")
                                .setMessage("Please check the Phone no. you entered")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                        someFlag = true;
                        return;
                    }
                    if (!someFlag)
                    {
                        Mobile mObj = new Mobile(editBillIdtext.getText().toString(),
                                Validations.getInstance().stringToDate(editBillDateText.getText().toString()),
                                Bill.BillType.Mobile,
                                editManufacturerNameText.getText().toString(),
                                editPlanNameText.getText().toString(),
                                editPhoneNumberText.getText().toString(),
                                Integer.parseInt(editDataUsedText.getText().toString()),
                                Integer.parseInt(editMinsUsedText.getText().toString()));
                        customerObj2.getCustomerBills().put(mObj.getBillId(), mObj);
                        Intent mIntent = new Intent(AddNewBillActivity.this, BillTotalActivity.class);
                        mIntent.putExtra("CustomerBills", customerObj2);
                        startActivity(mIntent);
                    }
                }
            });
        }

        if(position == 1)
        {
            hidefields();
            clearfields();
            editUnitsUsed.setVisibility(View.VISIBLE);
            editAgencyName.setVisibility(View.VISIBLE);
            editAgencyName.setHint("ENTER AGENCY NAME");
            editUnitsUsed.setHint("ENTER UNITS USED");
            buttonAddBill.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean someFlag = false;
                    if(editBillIdtext.getText().toString().isEmpty())
                    {
                        editBillIdtext.setError("Please enter the bill ID");
                        someFlag = true;
                        return;
                    }
                    if(editBillDateText.getText().toString().isEmpty()){
                        editBillDateText.setError("Please enter your the bill text");
                        someFlag = true;
                        return;
                    }
                    if(editUnitsUsedtext.getText().toString().isEmpty())
                    {
                        editUnitsUsedtext.setError("Please enter the units used");
                        someFlag = true;
                        return;
                    }
                    if(editAgencyNameText.getText().toString().isEmpty())
                    {
                        editAgencyNameText.setError("Please enter the agency");
                        someFlag = true;
                        return;
                    }
                    if(!editBillIdtext.getText().toString().contains("HY"))
                    {
                        new MaterialAlertDialogBuilder(AddNewBillActivity.this)
                                .setTitle("Invalid bill ID")
                                .setMessage("Hydro bill IDs must contain HY")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                        someFlag = true;
                        return;
                    }
                    if(!someFlag) {
                        Hydro hObj = new Hydro(editBillIdtext.getText().toString(),
                                Validations.getInstance().stringToDate(editBillDateText.getText().toString()),
                                Bill.BillType.Hydro,
                                editAgencyNameText.getText().toString(),
                                Integer.parseInt(editUnitsUsedtext.getText().toString()));
                        customerObj2.getCustomerBills().put(hObj.getBillId(), hObj);
                        Intent mIntent = new Intent(AddNewBillActivity.this, BillTotalActivity.class);
                        mIntent.putExtra("CustomerBills", customerObj2);
                        startActivity(mIntent);
                    }
                }
            });
        }

        if(position == 2)
        {
            hidefields();
            clearfields();
            editUnitsUsed.setVisibility(View.VISIBLE);
            editAgencyName.setVisibility(View.VISIBLE);
            editAgencyName.setHint("ENTER PROVIDER NAME");
            editUnitsUsed.setHint("ENTER DATA USED");
            buttonAddBill.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean someFlag = false;
                    if(editBillIdtext.getText().toString().isEmpty())
                    {
                        editBillIdtext.setError("Please enter the bill ID");
                        someFlag = true;
                        return;
                    }
                    if(editBillDateText.getText().toString().isEmpty()){
                        editBillDateText.setError("Please enter your the bill text");
                        someFlag = true;
                        return;
                    }
                    if(editAgencyNameText.getText().toString().isEmpty())
                    {
                        editAgencyNameText.setError("Please enter the provider");
                        someFlag = true;
                        return;
                    }
                    if(editUnitsUsedtext.getText().toString().isEmpty())
                    {
                        editDataUsedText.setError("Please enter the data used");
                        someFlag = true;
                        return;
                    }
                    if(!editBillIdtext.getText().toString().contains("IN"))
                    {
                        new MaterialAlertDialogBuilder(AddNewBillActivity.this)
                                .setTitle("Invalid bill ID")
                                .setMessage("Hydro bill IDs must contain IN")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                        someFlag = true;
                        return;
                    }
                    Internet iObj = new Internet   (editBillIdtext.getText().toString(),
                            Validations.getInstance().stringToDate(editBillDateText.getText().toString()),
                            Bill.BillType.Internet,
                            editAgencyNameText.getText().toString(),
                            Double.parseDouble(editUnitsUsedtext.getText().toString()));
                    customerObj2.getCustomerBills().put(iObj.getBillId(),iObj);
                    Intent mIntent = new Intent(AddNewBillActivity.this, BillTotalActivity.class);
                    mIntent.putExtra("CustomerBills", customerObj2);
                    startActivity(mIntent);
                }
            });
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    private void addingDatePicker()
    {
        editBillDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddNewBillActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                String date ="";
                month = month + 1;
                String monthName = getMonthName(month);
                if(day<10) {
                    date = "0"+day + "-" + monthName + "-" + year;
                }
                else
                {
                    date = day + "-" + monthName + "-" + year;
                }
                editBillDateText.setText(date);
            }
        };
    }

    public static String getMonthName(int monthNumber){
        String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
        return monthNames[monthNumber-1];
    }
    public void initFields()
    {
        editMinsUsed.setVisibility(View.VISIBLE);
        editPhoneNumber.setVisibility(View.VISIBLE);
        editDataUsed.setVisibility(View.VISIBLE);
        editMinsUsed.setVisibility(View.VISIBLE);
        editPlanName.setVisibility(View.VISIBLE);
        editManufacturerName.setVisibility(View.VISIBLE);
    }
    public void hidefields()
    {
        editMinsUsed.setVisibility(View.INVISIBLE);
        editPhoneNumber.setVisibility(View.INVISIBLE);
        editDataUsed.setVisibility(View.INVISIBLE);
        editMinsUsed.setVisibility(View.INVISIBLE);
        editPlanName.setVisibility(View.INVISIBLE);
        editManufacturerName.setVisibility(View.INVISIBLE);
    }

    public void clearfields()
    {
        editPhoneNumberText.getText().clear();
        editDataUsedText.getText().clear();
        editMinsUsedText.getText().clear();
        editPlanNameText.getText().clear();
        editManufacturerNameText.getText().clear();
        editBillDateText.getText().clear();
        editBillIdtext.getText().clear();
        editAgencyNameText.getText().clear();
        editDataUsedText.getText().clear();
        editUnitsUsedtext.getText().clear();
    }
}
