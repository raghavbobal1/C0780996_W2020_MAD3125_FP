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


  