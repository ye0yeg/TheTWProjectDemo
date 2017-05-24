package gp.ye0yeg.thetwprojectdemo.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import gp.ye0yeg.thetwprojectdemo.R;
import gp.ye0yeg.thetwprojectdemo.base.BaseHolder;
import gp.ye0yeg.thetwprojectdemo.utils.UIUtils;

/**
 * Created by Administrator on 5/24/2017.
 */
public class SportHolder extends BaseHolder<String> {

    @ViewInject(R.id.item_appinfo_tv_title)
    TextView tv_title;
    @ViewInject(R.id.item_appinfo_iv_icon)
    ImageView iv_icon;
    @ViewInject(R.id.item_appinfo_tv_des)
    TextView iv_des;
    @ViewInject(R.id.item_appinfo_tv_size)
    TextView tv_price;

    //下面这些东西其实是可以放在string中，然后用取出使用
    private String[] title = new String[]{"SportShoes1", "SportShoes2", "SportShoes3"
            , "SportShoes4", "SportShoes5", "SportShoes6", "SportShoes7"};
    private int[] images = new int[]{R.mipmap.sport1, R.mipmap.sport2, R.mipmap.sport22, R.mipmap.sport3, R.mipmap.sport4
            , R.mipmap.sport5, R.mipmap.sport6};
    private String[] des = new String[]{"SportDes1", "SportDes2"
            , "SportDes3", "SportDes4", "SportDes5", "SportDes6", "SportDes7"};
    private String[] prices = new String[]{"Prince1","Prince2"
            ,"Prince3","Prince4","Prince5","Prince6","Prince7"};

    @Override
    protected View initHolderView() {
        View view = View.inflate(UIUtils.getContext(), R.layout.item_shoes_info, null);
        x.view().inject(this,view);

        return null;
    }

    @Override
    protected void refreshHolderView(String data) {

    }
}
