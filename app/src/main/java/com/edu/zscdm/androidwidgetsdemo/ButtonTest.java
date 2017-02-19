package com.edu.zscdm.androidwidgetsdemo;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ButtonTest extends AppCompatActivity {
    private Button buttonClock;
    private TimeCount timeCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonClock = (Button) findViewById(R.id.btn);
        timeCount = new TimeCount(60 * 1000, 1000);//实例化TimeCount类
        buttonClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeCount.start();//调用start方法开始倒计时
            }
        });
    }

    class TimeCount extends CountDownTimer {
        //构造方法
        public TimeCount(long totalTime, long interval) {
            super(totalTime, interval);
        }

        @Override
        public void onTick(long millisUntilFinished) {//覆写方法-计时中
            buttonClock.setEnabled(false);//按钮不可点击
            //参数millisUntilFinished表示剩余时间
            buttonClock.setText(millisUntilFinished / 1000 + "秒");
        }

        @Override
        public void onFinish() {//覆写方法，即时结束
            buttonClock.setEnabled(true);//恢复按钮可点击
            buttonClock.setText("重新获取");//修改按钮提示文字
        }
    }
}
