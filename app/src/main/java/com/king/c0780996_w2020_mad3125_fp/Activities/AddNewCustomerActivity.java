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

public class AddNewCustomerActivity extends AppCompatActivity
{
    @BindView(R.id.spinner_gender) Spinner spinner_gender;
    @BindView(R.id.editCustomerIdtext) TextInputEditText editCustomerIdtext;
    @BindView(R.id.editFNametext) TextInputEditText editFNametext;
    @BindView(R.id.editLnametext) TextInputEditText editLnametext;
    @BindView(R.id.editDOBtext) TextInputEditText editDOBtext;
    @BindView(R.id.editUserNameText) TextInputEditText editUserNameText;
    @BindView(R.id.editEmailText) TextInputEditText editEmailText;
    @BindView(R.id.editPasswordText) TextInputEditText editPasswordText;
    @BindView(R.id.editLocationText) TextInputEditText editLocationText;
    @BindView(R.id.editCustomerId) TextInputLayout editCustomerId;
    @BindView(R.id.editFName) TextInputLayout editFName;
    @BindView(R.id.editLname) TextInputLayout editLname;
    @BindView(R.id.editDOB) TextInputLayout editDOB;
    @BindView(R.id.editUserName) TextInputLayout editUserName;
    @BindView(R.id.editEmail) TextInputLayout editEmail;
    @BindView(R.id.editPassword) TextInputLayout editPassword;
    @BindView(R.id.editLocation) TextInputLayout editLocation;
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


    public static String getMonthName(int monthNumber){
        String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
        return monthNames[monthNumber-1];
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
                        android.R.style.Widget_Holo_Light,
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

    public String getGender()
    {
        int genderSpinnerPosition = spinner_gender.getSelectedItemPosition();
        gender = String.valueOf(spinner_gender.getItemAtPosition(genderSpinnerPosition));
        return gender;
    }

    public void clearfields()
    {
        editUserNameText.getText().clear();
        editPasswordText.getText().clear();
        editDOBtext.getText().clear();
        editCustomerIdtext.getText().clear();
        editEmailText.getText().clear();
        editLnametext.getText().clear();
        editFNametext.getText().clear();
        editLocationText.getText().clear();
    }

    public void fieldChecker()
    {
        boolean someFlag = false;
        if(editCustomerIdtext.getText().toString().isEmpty())
        {
            editCustomerId.setError("Please enter your customer ID");
            someFlag = true;
            return;
        }
        if(editFNametext.getText().toString().isEmpty()){
            editFName.setError("Please enter your first name");
            someFlag = true;
            return;
        }
        if(editLnametext.getText().toString().isEmpty())
        {
            editLname.setError("Please enter your last name");
            someFlag = true;
            return;
        }
        if(editDOBtext.getText().toString().isEmpty())
        {
            editDOB.setError("Please enter your date of birth");
            someFlag = true;
            return;
        }
        if(editUserNameText.getText().toString().isEmpty())
        {
            editUserName.setErrorEnabled(true);
            editUserName.setError("Please enter your username");
            someFlag = true;
            return;
        }
        if(editEmailText.getText().toString().isEmpty())
        {
            editEmail.setError("Please enter your email");
            someFlag = true;
            return;
        }
        if(editPasswordText.getText().toString().isEmpty())
        {
            editPassword.setErrorEnabled(true);
            editPassword.setError("Please enter your password");
            someFlag = true;
            return;
        }
        if(editLocationText.getText().toString().isEmpty())
        {
            editLocation.setError("Please enter your location");
            someFlag = true;
            return;
        }
        if(!Validations.getInstance().emailValidation(editEmailText.getText().toString()))
        {
            editEmail.setError("Please enter a valid email address");
            new MaterialAlertDialogBuilder(AddNewCustomerActivity.this)
                    .setTitle("Invalid email address")
                    .setMessage("Please check the email you entered")
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
            Customer customer = new Customer(editCustomerIdtext.getText().toString(),
                    editFNametext.getText().toString(),
                    editLnametext.getText().toString(),
                    getGender(),
                    editEmailText.getText().toString(),
                    editUserNameText.getText().toString(),
                    editPasswordText.getText().toString(),
                    editLocationText.getText().toString(),
                    editDOBtext.getText().toString(),
                    R.drawable.new_user);
            DataStorage.getInstance().getCustomerMap().put(customer.getCustomerId(), customer);
            LoginActivity.emailList.add(editEmailText.getText().toString());
            LoginActivity.passwordList.add(editPasswordText.getText().toString());
            Intent mIntent = new Intent(AddNewCustomerActivity.this, CustomerListActivity.class);
            mIntent.putExtra("CustomerBills", customer);
            startActivity(mIntent);
        }
    }
}
