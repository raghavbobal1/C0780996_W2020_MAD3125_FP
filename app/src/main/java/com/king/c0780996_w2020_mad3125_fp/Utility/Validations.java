package com.king.c0780996_w2020_mad3125_fp.Utility;

import android.content.Context;
import android.widget.Toast;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
    private static Validations repoObj = new Validations();
    public static Validations getInstance() {
        return repoObj;
    }
    private Validations()
    { }

    public LocalDate stringToDate(String aDate)
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MMM-yyyy");
        return formatter.parseLocalDate(aDate);
    }

    public String doubleFormatter(Double d)
    {
        return String.format("$ " + "%,.2f", d);
    }

    public void makeToast(String message, Context context)
    {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
    public boolean emailValidation(String s) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }

    public boolean mobileValidation(String s)
    {
        if(s.length() == 10)
        {
            return true;
        }
        return false;
    }

    public String gbFormatter(Integer s)
    {
        return s + " GB";
    }

    public String minsFormatter(String s)
    {
        return s + " MINS";
    }

}
