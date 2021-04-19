package com.example.recyclerview;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IUpdate{
    public static final String KEY = "key";
    private RecyclerView rvSongs;
    private SongAdapter mSongAdapter;
    private List<Song> mSongs;
    private Button btAdd;
    private EditText edtTitle;
    private EditText edtLyric;
    private EditText edtArctist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvSongs= (RecyclerView) findViewById(R.id.rv_songs);
        btAdd = findViewById(R.id.bt_add);
        // Create song data
        initData();

        mSongAdapter = new SongAdapter(this, mSongs);
        rvSongs.setAdapter(mSongAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        rvSongs.setLayoutManager(linearLayoutManager);

        btAdd.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) throws NumberFormatException {
                Intent i = new Intent(MainActivity.this,ActivitySecond.class);
                startActivityForResult(i,100);

            }
        });

    }

    protected void initData(){
        mSongs = new ArrayList<>();
        mSongs.add(new Song(R.drawable.ho_ngoc_ha, "NẾU EM CÒN TỒN TẠI", "Khi anh bắt đầu 1 tình yêu Là lúc anh tự thay", "Trịnh Đình Quang"));
        mSongs.add(new Song(R.drawable.hung, "NGỐC", "Có rất nhiều những câu chuyện Em dấu riêng mình em biết", "Khắc Việt"));
        mSongs.add(new Song(R.drawable.noo_phuoc_thinh, "HÃY TIN ANH LẦN NỮA", "Dẫu cho ta đã sai khi ở bên nhau Cô yêu thương", "Thiên Dũng"));
        mSongs.add(new Song(R.drawable.my_tam, "CHUỖI NGÀY VẮNG EM", "Từ khi em bước ra đi cõi lòng anh ngập tràng bao", "Duy Cường"));
        mSongs.add(new Song(R.drawable.son_tung, "KHI NGƯỜI MÌNH YÊU KHÓC", "Nước mắt em đang rơi trên những ngón tay Nước mắt em", "Phạm Mạnh Quỳnh"));
        mSongs.add(new Song(R.drawable.hung, "MỞ", "Anh mơ gặp em anh mơ được ôm anh mơ được gần", "Trịnh Thăng Bình"));
        mSongs.add(new Song(R.drawable.noo_phuoc_thinh, "TÌNH YÊU CHẮP VÁ", "Muốn đi xa nơi yêu thương mình từng có Để không nghe", "Mr. Siro"));
        mSongs.add(new Song(R.drawable.ho_ngoc_ha, "CHỜ NGÀY MƯA TAN", "1 ngày mưa và em khuất xa nơi anh bóng dáng cứ", "Trung Đức"));
        mSongs.add(new Song(R.drawable.my_tam, "CÂU HỎI EM CHƯA TRẢ LỜI", "Cần nơi em 1 lời giải thích thật lòng Đừng lặng im", "Yuki Huy Nam"));
        mSongs.add(new Song(R.drawable.hung, "QUA ĐI LẶNG LẼ", "Đôi khi đến với nhau yêu thương chẳng được lâu nhưng khi", "Phan Mạnh Quỳnh"));
        mSongs.add(new Song(R.drawable.noo_phuoc_thinh, "QUÊN ANH LÀ ĐIỀU EM KHÔNG THỂ - REMIX", "Cần thêm bao lâu để em quên đi niềm đâu Cần thêm", "Thiện Ngôn"));
        mSongs.add(new Song(R.drawable.son_tung, "CÓ CHÀNG TRAI VIẾT LÊN CÂY", "Có chàng trai viết lên cây lời yêu thương", "Phan Mạnh Quỳnh"));
        mSongs.add(new Song(R.drawable.ho_ngoc_ha, "NẾU EM CÒN TỒN TẠI", "Khi anh bắt đầu 1 tình yêu Là lúc anh tự thay", "Trịnh Đình Quang"));
        mSongs.add(new Song(R.drawable.hung, "NGỐC", "Có rất nhiều những câu chuyện Em dấu riêng mình em biết", "Khắc Việt"));
        mSongs.add(new Song(R.drawable.noo_phuoc_thinh, "HÃY TIN ANH LẦN NỮA", "Dẫu cho ta đã sai khi ở bên nhau Cô yêu thương", "Thiên Dũng"));
        mSongs.add(new Song(R.drawable.my_tam, "CHUỖI NGÀY VẮNG EM", "Từ khi em bước ra đi cõi lòng anh ngập tràng bao", "Duy Cường"));
    }

    private void layoutAnimation(RecyclerView recyclerView) {
        Context context = recyclerView.getContext();
        LayoutAnimationController layoutAnimationController =
                AnimationUtils.loadLayoutAnimation(context,R.anim.layout_fall_down);
        recyclerView.setLayoutAnimation(layoutAnimationController);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100){
            if (resultCode == RESULT_OK) {
                Song s = (Song) data.getSerializableExtra(KEY);
                mSongs.add(0,s);
                mSongAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void updateData(Song song) {
        edtTitle.setText(song.getmTitle());
        edtLyric.setText(song.getmLyric());
        edtArctist.setText(song.getmArtist());
    }
}