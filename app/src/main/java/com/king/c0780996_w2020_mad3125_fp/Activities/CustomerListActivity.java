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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        ButterKnife.bind(this);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar);
        View view = getSupportActionBar().getCustomView();

        barAddCustomer = view.findViewById(R.id.barAddCustomer);
        barLogout = view.findViewById(R.id.barLogout);

        customerRV = findViewById(R.id.customerRV);

        barAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(CustomerListActivity.this, AddNewCustomerActivity.class);
                startActivity(mIntent);
            }
        });

        barLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(CustomerListActivity.this, LoginActivity.class);
                startActivity(mIntent);
            }
        });

        loadCustomers();

        customerAdapter = new CustomerAdapter(customerArrayList);
        RecyclerView.LayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        customerRV.setLayoutManager(mLinearLayoutManager);
        customerRV.setAdapter(customerAdapter);

        btnAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(CustomerListActivity.this, AddNewCustomerActivity.class);
                startActivity(mIntent);
            }
        });
    }

    private void loadCustomers()
    {
        DataStorage.getInstance().loadData();
        customerArrayList = new ArrayList();
        HashMap<String, Customer> customerHashMap = DataStorage.getInstance().getCustomerMap();
        Collection<Customer> demoValues = customerHashMap.values();
        tempCustomerArrayList = new ArrayList<>(demoValues);
        customerArrayList.addAll(tempCustomerArrayList);
    }


}
