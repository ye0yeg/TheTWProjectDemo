package gp.ye0yeg.thetwprojectdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.Random;

import gp.ye0yeg.thetwprojectdemo.R;
import gp.ye0yeg.thetwprojectdemo.utils.FootCal;
import gp.ye0yeg.thetwprojectdemo.utils.UIUtils;

/**
 * Created by Administrator on 5/22/2017.
 */

public class GetDataActivity extends AppCompatActivity {
    @ViewInject(R.id.et_getdata_foot_width)
    EditText et_foot_width;
    @ViewInject(R.id.et_getdata_foot_height)
    EditText et_foot_height;
    @ViewInject(R.id.et_getdata_heiht)
    EditText et_height;
    @ViewInject(R.id.bt_getdata_analyse)
    Button bt_analyse;
    @ViewInject(R.id.iv_getdata_foot_size)
    ImageView iv_foot_size;
    @ViewInject(R.id.bt_getdata_shoes)
    Button bt_shoes;

    private int footHeight;
    private int footWidth;
    private int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initEvent();
        initData();
    }

    private void initView() {
        setContentView(R.layout.activity_getdata);
        x.view().inject(this);
        iv_foot_size.setImageResource(R.mipmap.middle);
    }

    private void initEvent() {
        bt_analyse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radio = FootCal.calFootRatio(Integer.parseInt(String.valueOf(et_foot_height.getText())),Integer.parseInt(String.valueOf(et_foot_width.getText())));
                if(radio==0){
                    iv_foot_size.setImageResource(R.mipmap.little);
                }else if(radio==1){
                    iv_foot_size.setImageResource(R.mipmap.middle);
                }else{
                    iv_foot_size.setImageResource(R.mipmap.big);
                }
                int footHeight = FootCal.calFootHeight(Integer.parseInt(String.valueOf(et_height.getText())));
                Toast.makeText(UIUtils.getContext(),"Your foot"+ FootCal.calResult(radio,footHeight),Toast.LENGTH_SHORT).show();
                //该地方可以使用根据预判不同来更换节点图片
            }
        });

        bt_shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initData()  {
        setRandomData();
        while (footHeight-footWidth<20) {
            setRandomData();
        }
        et_foot_height.setText(footHeight+"");
        et_foot_width.setText(footWidth+"");
        et_height.setText(height+"");
    }

    private void setRandomData(){
        //10-50
        footHeight = footRandom(50);
        //10-30
        footWidth = footRandom(30);
        //height 的取值范围为10-20之间
        height = footRandom(20);
    }
    private int footRandom(int num) {
            Random random = new Random();
            int footNum = random.nextInt(num-10);
            return footNum+10;
    }
}
