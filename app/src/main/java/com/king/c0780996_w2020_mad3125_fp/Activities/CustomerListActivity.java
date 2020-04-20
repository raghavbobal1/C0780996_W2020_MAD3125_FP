package com.king.c0780996_w2020_mad3125_fp.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.king.c0780996_w2020_mad3125_fp.Adapters.CustomerAdapter;
import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Customer;
import com.king.c0780996_w2020_mad3125_fp.R;
import com.king.c0780996_w2020_mad3125_fp.Utility.DataStorage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomerListActivity extends AppCompatActivity {


    private RecyclerView customerRV;
    private ArrayList customerArrayList;
    private ArrayList tempCustomerArrayList;
    private CustomerAdapter customerAdapter;
    private ImageView barAddCustomer;
    private ImageView barLogout;

    @BindView(R.id.btnAddCustomer) Button btnAddCustomer;

}
