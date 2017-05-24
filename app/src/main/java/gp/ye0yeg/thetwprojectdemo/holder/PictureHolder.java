package gp.ye0yeg.thetwprojectdemo.holder;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import gp.ye0yeg.thetwprojectdemo.R;
import gp.ye0yeg.thetwprojectdemo.base.BaseHolder;
import gp.ye0yeg.thetwprojectdemo.utils.UIUtils;

/**
 * Created by Administrator on 5/24/2017.
 */
public class PictureHolder extends BaseHolder<String>{

    @ViewInject(R.id.item_home_picture_pager)
    ViewPager vp_picture;
    @ViewInject(R.id.item_home_picture_container_indicator)
    LinearLayout ll_point;

    //数组，图片
    int[] pics = new int[]{R.mipmap.sport1,R.mipmap.sport2,R.mipmap.sport22,R.mipmap.sport3,R.mipmap.sport4,R.mipmap.sport5,R.mipmap.sport6};

    @Override
    protected View initHolderView() {
        View view = View.inflate(UIUtils.getContext(), R.layout.item_sport_picture,null);
        x.view().inject(this,view);
        return view;
    }

    @Override
    protected void refreshHolderView(String data) {
        vp_picture.setAdapter(new PictureAdapter());
    }

    class PictureAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            if(pics !=null){
                return Integer.MAX_VALUE;
            }
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            position = position % pics.length;// 无限轮播
            ImageView iv = new ImageView(UIUtils.getContext());
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setImageResource(pics[position]);
            container.addView(iv);
            return iv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }
}
