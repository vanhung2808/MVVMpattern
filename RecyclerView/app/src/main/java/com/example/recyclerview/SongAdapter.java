package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private List<Song> mSongs;
    private Context mContext;
    private LayoutInflater layoutInflater;
    private IUpdate iUpdate;
    public SongAdapter(Context context, List<Song> datas) {
        mContext = context;
        mSongs = datas;
        layoutInflater = LayoutInflater.from(context);
    }

    public class SongViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvLyric;
        private TextView tvArtist;
        private ImageView tvImage;
        private Button btDelete;
        private Button btUpdate;

        public SongViewHolder(View itemView) {
            super(itemView);
            btDelete = itemView.findViewById(R.id.btDelete);
            btUpdate = itemView.findViewById(R.id.btUpdate);
            tvImage = itemView.findViewById(R.id.img_category);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvLyric = (TextView) itemView.findViewById(R.id.tv_lyric);
            tvArtist = (TextView) itemView.findViewById(R.id.tv_artist);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) throws NumberFormatException{
                    Song song = mSongs.get(getAdapterPosition());
                    Toast.makeText(mContext,song.getmTitle(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate view from row_item_song.xml
        View itemView = layoutInflater.inflate(R.layout.row_item_song, parent, false);
        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        // Get song in mSong via position
        Song song = mSongs.get(position);
        //bind data to viewholder
        holder.tvTitle.setText(song.getmTitle());
        holder.tvLyric.setText(song.getmLyric());
        holder.tvArtist.setText(song.getmArtist());
        holder.tvImage.setImageResource(song.getmImage());
        holder.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) throws NumberFormatException {
                int index = mSongs.indexOf(song);
                if(index < 0) {
                    return;
                }
                mSongs.remove(index);
                notifyItemRemoved(index);
            }
        });

        holder.btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) throws NumberFormatException {
                if (position < 0) {
                    return;
                }
                mSongs.set(position, new Song(R.drawable.noo_phuoc_thinh, "Cho ngay mua tan", "Va anh se cho mot giac mo", "Noo Phuoc Thinh"));
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }


}