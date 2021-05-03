package com.example.demoui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.demoui.R;
import com.example.demoui.model.Seller;

import java.util.List;

public class SellerAdapter extends RecyclerView.Adapter<SellerAdapter.SellerViewHolder> {
    private final List<Seller> sellerList;
    private final LayoutInflater layoutInflater;
    public SellerAdapter(Context context, List<Seller> datas) {
        sellerList = datas;
        layoutInflater = LayoutInflater.from(context);
    }

    public static class SellerViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvNumber;
        private final ImageView ivRank;
        private final TextView tvName;
        private final TextView tvCategory;
        private final ImageView ivProfile;

        public SellerViewHolder(View itemView) {
            super(itemView);
            tvNumber = itemView.findViewById(R.id.tv_number);
            ivRank = itemView.findViewById(R.id.iv_rank);
            tvName = itemView.findViewById(R.id.tv_name);
            tvCategory = itemView.findViewById(R.id.tv_category);
            ivProfile = itemView.findViewById(R.id.iv_profile);
        }
    }

    @NonNull
    @Override
    public SellerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.seller_item, parent, false);
        return new SellerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SellerViewHolder holder, int position) {
        Seller seller = sellerList.get(position);
        holder.ivRank.setImageResource(seller.getRank());
        holder.tvNumber.setText(seller.getNumber());
        holder.tvName.setText(seller.getName());
        holder.tvCategory.setText(seller.getCategory());
        holder.ivProfile.setImageResource(seller.getImage());

    }

    @Override
    public int getItemCount() {
        return sellerList.size();
    }


}