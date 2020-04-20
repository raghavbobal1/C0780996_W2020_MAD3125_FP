package com.king.c0780996_w2020_mad3125_fp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.king.c0780996_w2020_mad3125_fp.Adapters.BillsAdapter;
import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Bill;
import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Customer;
import com.king.c0780996_w2020_mad3125_fp.R;
import com.king.c0780996_w2020_mad3125_fp.Utility.Validations;

import java.util.ArrayList;

public class BillTotalActivity extends AppCompatActivity {

    private RecyclerView rvBillsList;
    private ArrayList<Bill> billsArrayListDetail;
    private BillsAdapter billsAdapter;
    private ImageView addBillimg;
    private TextView txtTotalAmountValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_total);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setTitle("YOUR BILLS");

        Intent mIntent = getIntent();
        final Customer customerObj = mIntent.getParcelableExtra("CustomerBills");
        billsArrayListDetail = customerObj.getBills();

        txtTotalAmountValue = findViewById(R.id.textBillTotal);

        if(!billsArrayListDetail.isEmpty())
        {
            txtTotalAmountValue.setText("YOUR TOTAL IS " + Validations.getInstance().doubleFormatter(customerObj.getTotalAmount()));
        }
        else
        {
            txtTotalAmountValue.setText("NO BILLS TO DISPLAY");
        }

        rvBillsList = findViewById(R.id.billTotalRV);
        billsAdapter = new BillsAdapter(billsArrayListDetail);

        RecyclerView.LayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        billsAdapter.notifyDataSetChanged();
        rvBillsList.setLayoutManager(mLinearLayoutManager);
        rvBillsList.setAdapter(billsAdapter);

        addBillimg = findViewById(R.id.addBillimg);
        addBillimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(BillTotalActivity.this, AddNewBillActivity.class);
                mIntent.putExtra("CustomerBills2", customerObj);
                startActivity(mIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_customerlist, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuAddCustomer:
                Intent addBill = new Intent(BillTotalActivity.this, AddNewBillActivity.class);
                startActivity(addBill);
                break;
            case R.id.mnuLogout:
                Intent logoutIntent = new Intent(BillTotalActivity.this, LoginActivity.class);
                startActivity(logoutIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
