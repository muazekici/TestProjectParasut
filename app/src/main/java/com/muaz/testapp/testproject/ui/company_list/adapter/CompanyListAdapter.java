package com.muaz.testapp.testproject.ui.company_list.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.muaz.testapp.testproject.R;
import com.muaz.testapp.testproject.data_manager.network_manager.modals.Company;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by muazekici on 21.10.2018.
 */

public class CompanyListAdapter  extends RecyclerView.Adapter<CompanyListAdapter.CompanyItemHolder>{

    public interface CompanySelectedListener{
        void onCompanySelected(int position, int companyId);
    }

    private List<Company> mList;
    private CompanySelectedListener mListener;

    public CompanyListAdapter(List<Company> companies,CompanySelectedListener listener){
        mList = companies;
        mListener = listener;
    }

    @NonNull
    @Override
    public CompanyItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_company_list,parent,false);

        return new CompanyItemHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyItemHolder holder, int position) {
        holder.tvCompanyName.setText(mList.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    mListener.onCompanySelected(position,mList.get(position).getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public static class CompanyItemHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_company_name)
        TextView tvCompanyName;

        public CompanyItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
