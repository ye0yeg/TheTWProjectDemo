package gp.ye0yeg.thetwprojectdemo.factory;

import android.support.v4.app.Fragment;
import android.support.v4.util.SparseArrayCompat;

import gp.ye0yeg.thetwprojectdemo.fragment.BootsFragment;
import gp.ye0yeg.thetwprojectdemo.fragment.CasualFragment;
import gp.ye0yeg.thetwprojectdemo.fragment.HikingFragment;
import gp.ye0yeg.thetwprojectdemo.fragment.SandalsFragment;
import gp.ye0yeg.thetwprojectdemo.fragment.SlipperFragment;
import gp.ye0yeg.thetwprojectdemo.fragment.SportsFragment;
import gp.ye0yeg.thetwprojectdemo.fragment.TravelingFragment;

/**
 * Created by Administrator on 4/27/2017.
 */

public class FragmentFactory {

    public static final int SHOES1 = 0;
    public static final int SHOES2 = 1;
    public static final int SHOES3 = 2;
    public static final int SHOES4 = 3;
    public static final int SHOES5 = 4;
    public static final int SHOES6 = 5;
    public static final int SHOES7 = 6;

    static SparseArrayCompat<Fragment> cachesFragmentMap = new SparseArrayCompat<Fragment>();

    public static Fragment getFragment(int position) {

        Fragment fragment = null;

        Fragment tmpFragment = cachesFragmentMap.get(position);
        if (tmpFragment != null) {
            fragment = tmpFragment;
            return fragment;
        }
        /*
        *
        *         <item>Sports</item>
        <item>Casual</item>
        <item>Hiking</item>
        <item>Traveling</item>
        <item>Slipper拖鞋</item>
        <item>Sandals凉鞋</item>
        <item>LISBoots马靴</item>*/
        switch (position) {
            case SHOES1:
                fragment = new SportsFragment();
                break;
            case SHOES2:
                fragment = new CasualFragment();
                break;
            case SHOES3:
                fragment = new HikingFragment();
                break;
            case SHOES4:
                fragment = new TravelingFragment();
                break;
            case SHOES5:
                fragment = new SlipperFragment();
                break;
            case SHOES7:
                fragment = new SandalsFragment();
                break;
            case SHOES6:
                fragment = new BootsFragment();
                break;
            default:
                break;
        }
        //保存对应的缓存
        cachesFragmentMap.put(position, fragment);
        return fragment;
    }
    //我居然渴望他们爱我，我真可怜。——提利昂·兰尼斯特
}
