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

        private TextView aboutUsText;

        public static ArrayList<String> emailList = new ArrayList<>();

        public static ArrayList<String> passwordList = new ArrayList<>();

        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;

        public static final String PREFS_NAME = "MyPrefsFile";
        private static final String PREF_USERNAME = "username";
        private static final String PREF_PASSWORD = "password";

        Integer firstflag = 1;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            AndroidThreeTen.init(this);
            ActionBar mActionBar = getSupportActionBar();
            mActionBar.hide();

            editEmailText = findViewById(R.id.editEmailText);
            editPasswordText = findViewById(R.id.editPasswordText);
            btnSignIn = findViewById(R.id.btnSignIn);
            switchRembMe = findViewById(R.id.switchRembMe);
            editEmail = findViewById(R.id.editEmail);
            editPassword = findViewById(R.id.editPassword);
            aboutUsText = findViewById(R.id.aboutUsText);

            aboutUsText.setPaintFlags(aboutUsText.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
            aboutUsText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent mIntent = new Intent(LoginActivity.this, AboutUsActivity.class);
                    startActivity(mIntent);
                }
            });
            sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
            editor = sharedPreferences.edit();

            String email = sharedPreferences.getString(PREF_USERNAME, null);
            String password = sharedPreferences.getString(PREF_PASSWORD, null);
            editEmailText.setText(email);
            editPasswordText.setText(password);

            try {
                JSONObject obj = new JSONObject(loadJSONFromAsset("LoginInformation.json"));
                JSONArray userArray = obj.getJSONArray("users");
                for (int i = 0; i < userArray.length(); i++)
                {
                    JSONObject userInfo = userArray.getJSONObject(i);
                    emailList.add(userInfo.getString("email"));
                    passwordList.add(userInfo.getString("password"));
                }
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }

            btnSignIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(editEmailText.getText().toString().isEmpty())
                    {
                        editEmailText.setError("Email id left blank");
                    }

                    if(editPasswordText.getText().toString().isEmpty())
                    {
                        editPasswordText.setError("Password left blank");
                        return;
                    }

                    for(int i=0, j =0; i<emailList.size(); i++,j++)
                    {
                        if(emailList.get(i).equals(editEmailText.getText().toString()) && passwordList.get(i).equals(editPasswordText.getText().toString()))
                        {
                            if(switchRembMe.isChecked()){
                                editor.putString(PREF_USERNAME,editEmailText.getText().toString());
                                editor.putString(PREF_PASSWORD,editPasswordText.getText().toString());
                                editor.apply();
                            }
                            else
                            {
                                editor.putString(PREF_USERNAME,"");
                                editor.putString(PREF_PASSWORD,"");
                                editor.apply();
                            }
                        }
                    }
                    invalidLogin();
                }
            });
        }

   
