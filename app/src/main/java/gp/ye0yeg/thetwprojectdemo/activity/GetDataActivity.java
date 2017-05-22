package gp.ye0yeg.thetwprojectdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
        setContentView(R.layout.getdata_activity);
        x.view().inject(this);
    }

    private void initEvent() {
        bt_analyse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UIUtils.getContext(),"Your foot"+ FootCal.calResult(2,2),Toast.LENGTH_SHORT).show();
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
