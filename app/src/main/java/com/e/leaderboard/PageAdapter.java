package com.e.leaderboard;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    private int nbreoftabs;
public PageAdapter(FragmentManager fm,int nbreoftabs){
    super(fm);
    this.nbreoftabs=nbreoftabs;

}

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                    return new LeaderFragment();
            case 1:
                    return new SkillFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return nbreoftabs;
    }
}
