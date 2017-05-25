package gp.ye0yeg.thetwprojectdemo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import gp.ye0yeg.thetwprojectdemo.R;
import gp.ye0yeg.thetwprojectdemo.factory.FragmentFactory;
import gp.ye0yeg.thetwprojectdemo.utils.LogUtils;
import gp.ye0yeg.thetwprojectdemo.utils.UIUtils;

/**
 * Created by Administrator on 5/23/2017.
 */

public class ShoesActivity extends AppCompatActivity {

    @ViewInject(R.id.vp_shoes_viewpager)
    private ViewPager vp_viewpager;
    @ViewInject(R.id.psts_shoes_pt)
    private PagerSlidingTabStrip psts_tabs;
    private String[] mainTitle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_shoes);
        x.view().inject(this);
        mainTitle = UIUtils.getStringArr(R.array.main_titles);
        MainFragmentStatePagerAdapter adapter= new MainFragmentStatePagerAdapter(getSupportFragmentManager());
        vp_viewpager.setAdapter(adapter);
//        vp_viewpager.setAdapter(new HomeAdapter());
//        psts_tabs.setViewPager(vp_viewpager);
    }

    private class MainFragmentStatePagerAdapter extends FragmentStatePagerAdapter{

        public MainFragmentStatePagerAdapter(FragmentManager fm) { super(fm);}

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = FragmentFactory.getFragment(position);
            LogUtils.sf("初始化" + mainTitle[position]);
            return fragment;
        }

        @Override
        public int getCount() {
            if(mainTitle!=null){
                return mainTitle.length;
            }
            return 0;
        }
        //必须重新写
        @Override
        public CharSequence getPageTitle(int position) {
            return mainTitle[position];
        }

    }

    private class HomeAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            if (mainTitle != null) {
                return mainTitle.length;
            }
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView tv = new TextView(UIUtils.getContext());
            tv.setText(mainTitle[position]);
            container.addView(tv);
            return tv;
        }

        //必须重新写
        @Override
        public CharSequence getPageTitle(int position) {
            return mainTitle[position];
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
