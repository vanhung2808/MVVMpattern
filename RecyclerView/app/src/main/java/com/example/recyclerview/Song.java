package com.example.recyclerview;

import android.media.Image;

import java.io.Serializable;

public class Song implements Serializable {
    private int mImage;
    private String mTitle;
    private String mLyric;
    private String mArtist;
    public Song() {
        // TODO something
    }

    public Song(int mImage, String mTitle, String mLyric, String mArtist) {
        this.mImage = mImage;
        this.mTitle = mTitle;
        this.mLyric = mLyric;
        this.mArtist = mArtist;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmLyric() {
        return mLyric;
    }

    public void setmLyric(String mLyric) {
        this.mLyric = mLyric;
    }

    public String getmArtist() {
        return mArtist;
    }

    public void setmArtist(String mArtist) {
        this.mArtist = mArtist;
    }

    @Override
    public String toString() {
        return "Song{" +
                "mImage=" + mImage +
                ", mTitle='" + mTitle + '\'' +
                ", mLyric='" + mLyric + '\'' +
                ", mArtist='" + mArtist + '\'' +
                '}';
    }
}
