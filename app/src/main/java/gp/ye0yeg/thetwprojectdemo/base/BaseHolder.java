package gp.ye0yeg.thetwprojectdemo.base;

import android.view.View;

/**
 * Created by Administrator on 5/24/2017.
 */

public abstract class BaseHolder<T> {
    public View holderView;
    private T data;


    public View getHolderView(){
        return holderView;
    }

    /*
    * @des 视图
    * */
    public BaseHolder(){
        holderView = initHolderView();

//        holderView.setTag(this);
    }
    /*
    * 刷新视图
    * */
    public void setDataAndRefreshHolderView(T data){
        this.data= data;
        refreshHolderView(data);
    }

    protected abstract View initHolderView();

    protected abstract void refreshHolderView(T data);




}
