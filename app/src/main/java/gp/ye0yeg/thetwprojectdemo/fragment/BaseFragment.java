package gp.ye0yeg.thetwprojectdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 5/24/2017.
 */
public abstract class BaseFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initData();
        return initView();
    }

    /*
    * @des 初始化数据
    * */
    protected abstract void initData();

    /*
    * 初始化界面，在子类方法继承
    * */
    protected abstract View initView();
}
