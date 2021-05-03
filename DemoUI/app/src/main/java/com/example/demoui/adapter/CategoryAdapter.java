package com.example.demoui.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoui.R;
import com.example.demoui.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHodel> {
    private final List<Category> mList;
    private final IItemClickListener itemClickListener;

    int row_index = 0;


    public CategoryAdapter(List<Category> mList, IItemClickListener itemClickListener) {
        this.mList = mList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public CategoryViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent,false);
        return new CategoryViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHodel holder, int position) {
        Category category = mList.get(position);
        holder.tvTittle.setText(category.getTittle());
        holder.itemView.setOnClickListener(v->{
            row_index = position;
            notifyDataSetChanged();
            itemClickListener.getDataItemClick(category);
        });

        if (row_index==position) {
            holder.tvTittle.setBackgroundResource(R.drawable.category_selected);
            holder.tvTittle.setTextColor(Color.WHITE);
        }
        else {
            holder.tvTittle.setBackgroundResource(R.drawable.category_unselect);
            holder.tvTittle.setTextColor(Color.parseColor("#9A9A9A"));
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class CategoryViewHodel extends RecyclerView.ViewHolder {
        private final TextView tvTittle;

        public CategoryViewHodel(@NonNull View itemView) {
            super(itemView);
            tvTittle = itemView.findViewById(R.id.tv_tittle);

        }

    }
    public  interface  IItemClickListener {
        void getDataItemClick(Category category);
    }

}
