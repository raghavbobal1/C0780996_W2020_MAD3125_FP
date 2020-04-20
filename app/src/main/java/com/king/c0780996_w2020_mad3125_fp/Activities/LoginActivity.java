package com.king.c0780996_w2020_mad3125_fp.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

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

public class LoginActivity extends AppCompatActivity
{
    private TextInputEditText edtEmailIdText;
    private TextInputEditText edtPasswordText;
    private TextInputLayout edtEmailId;
    private TextInputLayout edtPassword;
    private Button btnlogin;
    private Switch swchRememberMe;
    private TextView txtAboutUs;
    public static ArrayList<String> emailList = new ArrayList<>();
    public static ArrayList<String> passwordList = new ArrayList<>();
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public static final String PREFS_NAME = "MyPrefsFile";
    private static final String PREF_USERNAME = "username";
    private static final String PREF_PASSWORD = "password";

    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;
    MediaPlayer mp;
    Integer someflag = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidThreeTen.init(this);

        // BIOMETRIC CODE
        executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(LoginActivity.this,
                executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode,
                                              @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(getApplicationContext(),
                        "Authentication error: " + errString, Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onAuthenticationSucceeded(
                    @NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getApplicationContext(),
                        "Authentication succeeded!", Toast.LENGTH_SHORT).show();
                successfulLogin();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                invalidFinger();
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Biometric login for my app")
                .setSubtitle("Log in using your biometric credential")
                .setNegativeButtonText("Use password")
                .build();
        // BIOMETRIC CODE END

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.hide();

        edtEmailIdText = findViewById(R.id.editEmailText);
        edtPasswordText = findViewById(R.id.editPasswordText);
        btnlogin = findViewById(R.id.btnSignIn);
        swchRememberMe = findViewById(R.id.switchRembMe);
        edtEmailId = findViewById(R.id.editEmail);
        edtPassword = findViewById(R.id.editPassword);
        txtAboutUs = findViewById(R.id.aboutUsText);

        txtAboutUs.setPaintFlags(txtAboutUs.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
        txtAboutUs.setOnClickListener(new View.OnClickListener() {
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
        edtEmailIdText.setText(email);
        edtPasswordText.setText(password);

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

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edtEmailIdText.getText().toString().isEmpty())
                {
                    edtEmailIdText.setError("Enter your email address");
                }

                if(edtPasswordText.getText().toString().isEmpty())
                {
                    edtPasswordText.setError("Enter your password");
                    return;
                }

                for(int i=0, j =0; i<emailList.size(); i++,j++)
                {
                    if(emailList.get(i).equals(edtEmailIdText.getText().toString()) && passwordList.get(i).equals(edtPasswordText.getText().toString()))
                    {
                        if(swchRememberMe.isChecked()){
                            editor.putString(PREF_USERNAME,edtEmailIdText.getText().toString());
                            editor.putString(PREF_PASSWORD,edtPasswordText.getText().toString());
                            editor.apply();
                        }
                        else
                        {
                            editor.putString(PREF_USERNAME,"");
                            editor.putString(PREF_PASSWORD,"");
                            editor.apply();
                        }
                        if(someflag == 1) {
                            biometricPrompt.authenticate(promptInfo);
                            someflag = 0;
                            return;
                        }
                        successfulLogin();
                        someflag = 1;
                        return;
                    }
                }
                invalidLogin();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String loadJSONFromAsset(String filename) {
        String json = null;
        try {
            InputStream is = getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void successfulLogin()
    {
        Intent mIntent = new Intent(LoginActivity.this, CustomerListActivity.class);
        startActivity(mIntent);
        return;
    }

    public void invalidLogin()
    {
        new MaterialAlertDialogBuilder(LoginActivity.this)
                .setTitle("Invalid username or password")
                .setMessage("Please check the information you entered")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
        return;
    }
    public void invalidFinger()
    {
        new MaterialAlertDialogBuilder(LoginActivity.this)
                .setTitle("Invalid fingerprint")
                .setMessage("Please try again")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
        return;
    }
}
