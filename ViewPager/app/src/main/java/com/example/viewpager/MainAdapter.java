package com.example.viewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends FragmentPagerAdapter {
    private ArrayList<String> arrayList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();

    public MainAdapter(@NonNull FragmentManager fm, int behavior) {

        super(fm, behavior);
    }


    public void addFragment(Fragment fragment, String title) {
        arrayList.add(title);
        fragmentList.add(fragment);
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arrayList.get(position);
    }


}