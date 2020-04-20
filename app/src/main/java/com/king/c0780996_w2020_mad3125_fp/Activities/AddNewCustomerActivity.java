package com.king.c0780996_w2020_mad3125_fp.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Customer;
import com.king.c0780996_w2020_mad3125_fp.R;
import com.king.c0780996_w2020_mad3125_fp.Utility.DataStorage;
import com.king.c0780996_w2020_mad3125_fp.Utility.Validations;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddNewCustomerActivity extends AppCompatActivity {
    @BindView(R.id.editCustomerId) TextInputLayout editCustomerId;
    @BindView(R.id.editFName) TextInputLayout editFName;
    @BindView(R.id.editLname) TextInputLayout editLname;
    @BindView(R.id.editDOB) TextInputLayout editDOB;
    @BindView(R.id.editUserName) TextInputLayout editUserName;
    @BindView(R.id.editEmail) TextInputLayout editEmail;
    @BindView(R.id.editPassword) TextInputLayout editPassword;
    @BindView(R.id.editLocation) TextInputLayout editLocation;

    @BindView(R.id.spinner_gender) Spinner spinner_gender;

    @BindView(R.id.editCustomerIdtext) TextInputEditText editCustomerIdtext;
    @BindView(R.id.editFNametext) TextInputEditText editFNametext;
    @BindView(R.id.editLnametext) TextInputEditText editLnametext;
    @BindView(R.id.editDOBtext) TextInputEditText editDOBtext;
    @BindView(R.id.editUserNameText) TextInputEditText editUserNameText;
    @BindView(R.id.editEmailText) TextInputEditText editEmailText;
    @BindView(R.id.editPasswordText) TextInputEditText editPasswordText;
    @BindView(R.id.editLocationText) TextInputEditText editLocationText;

    @BindView(R.id.btnSubmit) Button btnSubmit;
    @BindView(R.id.btnClear) Button btnClear;

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private String gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_customer);
        ButterKnife.bind(this);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.hide();

        addingDatePicker();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fieldChecker();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearfields();
            }
        });
    }

    private void addingDatePicker()
    {
        editDOBtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddNewCustomerActivity.this,
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
                editDOBtext.setText(date);
            }
        };
    }

    