package com.example.demoui.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.demoui.R;
import com.example.demoui.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private final List<Product> productList;
    private final LayoutInflater layoutInflater;
    private final IItemClickListener itemClickListener;
    public ProductAdapter(Context context, List<Product> datas, IItemClickListener itemClickListener) {
        productList = datas;
        layoutInflater = LayoutInflater.from(context);
        this.itemClickListener = itemClickListener;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivProduct;
        private final TextView tvInfo;
        private final TextView tvPrice;
        private final TextView tvOldPrice;
        private final TextView tvNewProduct;
        private final TextView tvPercent;
        private final CheckBox cbFavorite;

        public ProductViewHolder(View itemView) {
            super(itemView);
            ivProduct = itemView.findViewById(R.id.iv_product);
            tvInfo = itemView.findViewById(R.id.tv_product_info);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvOldPrice = itemView.findViewById(R.id.tv_old_price);
            tvNewProduct = itemView.findViewById(R.id.tv_newproduct);
            tvPercent = itemView.findViewById(R.id.tv_percent);
            cbFavorite = itemView.findViewById(R.id.cb_favorite);
        }
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.ivProduct.setImageResource(product.getImage());
        holder.tvInfo.setText(product.getProductInfo());
        holder.tvPrice.setText(product.getPrice());
        if(product.getNewProduct() != null)  {
            holder.tvNewProduct.setVisibility(View.VISIBLE);
            holder.tvNewProduct.setText(product.getNewProduct());
        }
        else {
            holder.tvNewProduct.setVisibility(View.GONE);
        }
        if(product.getPercent() != null) {
            holder.tvPercent.setVisibility(View.VISIBLE);
            holder.tvPercent.setText(product.getPercent());
        }
        holder.cbFavorite.setChecked(product.isFavorite());
        holder.cbFavorite.setOnClickListener(v -> itemClickListener.onClick(product));
        holder.tvOldPrice.setText(product.getOldPrice());
        holder.tvOldPrice.setPaintFlags(holder.tvOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public interface IItemClickListener {
        void onClick(Product product);
    }

    public void updateUIposition(Product product) {
        int position = productList.indexOf(product);
        notifyItemChanged(position);
    }


}