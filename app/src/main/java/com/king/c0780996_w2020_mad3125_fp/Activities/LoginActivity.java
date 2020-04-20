package com.king.c0780996_w2020_mad3125_fp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.jakewharton.threetenabp.AndroidThreeTen;
import com.king.c0780996_w2020_mad3125_fp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.Executor;

public class LoginActivity extends AppCompatActivity {
        private TextInputLayout editEmail;
        private TextInputEditText editEmailText;

        private TextInputEditText editPasswordText;
        private TextInputLayout editPassword;

        private Button btnSignIn;

        private Switch switchRembMe;

        public static ArrayList<String> emailList = new ArrayList<>();

        public static ArrayList<String> passwordList = new ArrayList<>();

        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;

        public static final String PREFS_NAME = "MyPrefsFile";
        private static final String PREF_USERNAME = "username";
        private static final String PREF_PASSWORD = "password";

        Integer someflag = 1;

      