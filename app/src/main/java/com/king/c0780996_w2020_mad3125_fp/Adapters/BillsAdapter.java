package com.king.c0780996_w2020_mad3125_fp.Adapters;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.king.c0780996_w2020_mad3125_fp.ModelClasses.Bill;
import com.king.c0780996_w2020_mad3125_fp.R;
import com.king.c0780996_w2020_mad3125_fp.Utility.Validations;

import java.util.ArrayList;

public class BillsAdapter extends RecyclerView.Adapter<BillsAdapter.BillsViewHolder> {

    private ArrayList<Bill> billArrayList;

    public BillsAdapter(ArrayList<Bill> billArrayList)
    {
        this.billArrayList = billArrayList;
    }

    @NonNull
    @Override
    public BillsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bill_cell
                        , parent
                        , false);
        BillsAdapter.BillsViewHolder mBillsViewHolder = new BillsAdapter.BillsViewHolder(mView);
        return mBillsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final BillsViewHolder holder, final int position) {
        Bill mBills = this.billArrayList.get(position);
        if(mBills.getBillId().contains("MB"))
        {
            holder.imgCellBillType.setImageResource(R.drawable.mob_icon);
        }
        if(mBills.getBillId().contains("HY")) {
            holder.imgCellBillType.setImageResource(R.drawable.hydro_icon);
        }
        if(mBills.getBillId().contains("IN")) {
            holder.imgCellBillType.setImageResource(R.drawable.int_icon);

        }
        holder.txtCellBillId.setText(mBills.getBillId());
        holder.txtCellBillAmount.setText(Validations.getInstance().doubleFormatter(mBills.getBillTotal()));
        holder.txtCellBillDate.setText(mBills.getBillDate().toString());
        holder.txtCellBillType.setText(mBills.getBillType().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Bill billObj = billArrayList.get(position);
                Intent mIntent = new Intent(holder.itemView.getContext(), BillInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("BillObj", billObj);
                mIntent.putExtras(bundle);
                holder.itemView.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.billArrayList.size();
    }
    public class BillsViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtCellBillId;
        TextView txtCellBillDate;
        TextView txtCellBillType;
        TextView txtCellBillAmount;
        ImageView imgCellBillType;

        public BillsViewHolder(@NonNull View itemView)
        {
            super(itemView);
            txtCellBillId = itemView.findViewById(R.id.txtCellBillId);
            txtCellBillDate = itemView.findViewById(R.id.txtCellBillDate);
            txtCellBillType = itemView.findViewById(R.id.txtCellBillType);
            txtCellBillAmount = itemView.findViewById(R.id.txtCellBillAmount);
            imgCellBillType = itemView.findViewById(R.id.imgCellBillType);
        }
    }
}
