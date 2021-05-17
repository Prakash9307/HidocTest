package com.example.hidoctest.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.hidoctest.fragment.FragmentBooks;
import com.example.hidoctest.fragment.FragmentNews;

public class TabAdapter extends FragmentStatePagerAdapter {



    public TabAdapter( FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position)
    {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new FragmentNews();
        }
        else if (position == 1)
        {
            fragment = new FragmentBooks();
        }


        return fragment;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "News";
        }
        else if (position == 1)
        {
            title = "Books";
        }


        return title;
    }

    @Override
    public int getCount()
    {
        return 2;
    }
}
