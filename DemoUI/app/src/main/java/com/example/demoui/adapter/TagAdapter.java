package com.example.demoui.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.demoui.R;

import com.example.demoui.model.Tag;

import java.util.List;

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.TagViewHolder> {
    private final List<Tag> tagList;
    private final LayoutInflater layoutInflater;
    public TagAdapter(Context context, List<Tag> datas) {
        tagList = datas;
        layoutInflater = LayoutInflater.from(context);
    }

    public static class TagViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvTag;

        public TagViewHolder(View itemView) {
            super(itemView);
            tvTag = itemView.findViewById(R.id.tv_tag);
        }
    }

    @NonNull
    @Override
    public TagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.tag_item, parent, false);
        return new TagViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TagViewHolder holder, int position) {
        Tag tag = tagList.get(position);
        holder.tvTag.setText(tag.getTag());
    }

    @Override
    public int getItemCount() {
        return tagList.size();
    }


}