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

   