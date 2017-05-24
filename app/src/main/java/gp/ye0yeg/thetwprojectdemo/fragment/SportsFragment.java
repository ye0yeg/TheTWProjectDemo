package gp.ye0yeg.thetwprojectdemo.fragment;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import gp.ye0yeg.thetwprojectdemo.R;
import gp.ye0yeg.thetwprojectdemo.holder.PictureHolder;
import gp.ye0yeg.thetwprojectdemo.holder.SportHolder;
import gp.ye0yeg.thetwprojectdemo.utils.UIUtils;

/**
 * 加载数据
 * <p>
 * 轮播图
 * <p>
 * 轮播点击详情
 * <p>
 * 详情条目
 */
public class SportsFragment extends BaseFragment {

    /*
    * 获取数据
    * */
    @Override
    protected void initData() {

    }

    /*
    * 加载视图
    * */
    @Override
    protected View initView() {
        PictureHolder picHolder = new PictureHolder();
        ListView listView = new ListView(UIUtils.getContext());
        picHolder.setDataAndRefreshHolderView(null);
        View headView = picHolder.getHolderView();
        listView.setCacheColorHint(Color.YELLOW);
        listView.setFastScrollEnabled(true);
        listView.addHeaderView(headView);
        listView.setAdapter(new myAdapter());
        return listView;
    }

    class myAdapter extends BaseAdapter {

        //初始化holder
        @Override
        public int getCount() {
            return 11;
        }

        @Override
        public int getViewTypeCount() {
            return super.getViewTypeCount() + 1;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SportHolder sportHolder = new SportHolder();
            View view = View.inflate(UIUtils.getContext(), R.layout.item_shoes_info, null);

            return view;
        }
    }

}
