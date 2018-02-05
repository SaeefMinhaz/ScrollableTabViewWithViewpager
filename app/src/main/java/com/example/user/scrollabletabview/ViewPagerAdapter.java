package com.example.user.scrollabletabview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.user.scrollabletabview.fragments.OneFragment;

/**
 * Created by USER on 2/4/2018.
 */

class ViewPagerAdapter extends FragmentPagerAdapter {

    private int NUM_ITEMS = 10;

//        private final List<Fragment> mFragmentList = new ArrayList<>();
//        private final List<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }


    @Override
    public int getCount() {
//            return mFragmentList.size();
//            return OneFragment.newInstance(id);
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: // Fragment # 0 - This will show FirstFragment
                return OneFragment.newInstance(0, "Page # 1");
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return OneFragment.newInstance(1, "Page # 2");
            case 2: // Fragment # 1 - This will show SecondFragment
                return OneFragment.newInstance(2, "Page # 3");
            case 3: // Fragment # 1 - This will show SecondFragment
                return OneFragment.newInstance(3, "Page # 4");
            case 4: // Fragment # 1 - This will show SecondFragment
                return OneFragment.newInstance(4, "Page # 5");
            case 5: // Fragment # 1 - This will show SecondFragment
                return OneFragment.newInstance(5, "Page # 6");
            case 6: // Fragment # 1 - This will show SecondFragment
                return OneFragment.newInstance(6, "Page # 7");
            case 7: // Fragment # 1 - This will show SecondFragment
                return OneFragment.newInstance(7, "Page # 8");
            case 8: // Fragment # 1 - This will show SecondFragment
                return OneFragment.newInstance(8, "Page # 9");
            case 9: // Fragment # 1 - This will show SecondFragment
                return OneFragment.newInstance(9, "Page # 10");
            default:
                return null;
        }
    }


//        public void addFrag(Fragment fragment, String title) {
//            mFragmentList.add(fragment);
//            mFragmentTitleList.add(title);
//        }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "page " + position;
    }
}