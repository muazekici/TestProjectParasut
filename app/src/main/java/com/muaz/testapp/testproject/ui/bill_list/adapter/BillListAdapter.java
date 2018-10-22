package com.muaz.testapp.testproject.ui.bill_list.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.muaz.testapp.testproject.R;
import com.muaz.testapp.testproject.data_manager.network_manager.modals.Expense;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by muazekici on 21.10.2018.
 */

public class BillListAdapter extends RecyclerView.Adapter<BillListAdapter.BillItemHolder> {

    private List<Expense> mList;

    public BillListAdapter(List<Expense> expenses){
        mList = expenses;
    }
    @NonNull
    @Override
    public BillItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bill_list,parent,false);
        return new BillItemHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BillItemHolder holder, int position) {

        holder.tvBillDescp.setText(mList.get(position).getDescription());
        holder.tvTotalAmount.setText(mList.get(position).getNetTotal());
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public static class BillItemHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_bill_descp)
        TextView tvBillDescp;
        @BindView(R.id.tv_total_amount)
        TextView tvTotalAmount;

        public BillItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
