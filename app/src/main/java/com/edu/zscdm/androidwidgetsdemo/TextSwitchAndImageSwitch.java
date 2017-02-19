package com.edu.zscdm.androidwidgetsdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class TextSwitchAndImageSwitch extends AppCompatActivity {

    private TextSwitcher textSwitcher;
    private TimeCount timeCount;
    private int count;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_switch_and_image_switch);
        timeCount = new TimeCount(3000, 100);

        //初始化倒计时类
        textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
        textSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.test_switch_in));//载入动画
        textSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.test_switch_out));//载入动画
        timeCount.start();//倒计时类开始
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(TextSwitchAndImageSwitch.this);
                textView.setTextColor(Color.RED);//设置字体颜色
                textView.setTextSize(40);//设置字体大小
                textView.setLayoutParams(new TextSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));//设置宽高属性
                return textView;
            }
        });
    }

    class TimeCount extends CountDownTimer {//倒计时类

        public TimeCount(long millisInFuture, long countDownInterval) {//必须重载的构造方法
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {//计时过程中触发
            count = (int) millisUntilFinished / 1000;
            textSwitcher.setText(count + "");
        }

        @Override
        public void onFinish() {//计时结束时触发
            textSwitcher.setText("Dead");
        }
    }
}
