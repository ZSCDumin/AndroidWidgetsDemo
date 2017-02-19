package com.edu.zscdm.androidwidgetsdemo;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

public class ViewFlipperTest extends AppCompatActivity {
    private int[] imgs = {R.drawable.pic1, R.drawable.pic2,R.drawable.pic3, R.drawable.pic4};//图片源
    private ViewFlipper viewFlipper;
    private float startX = 0f, tempX = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);
        viewFlipper = (ViewFlipper) findViewById(R.id.vf);
        for (int i = 0; i < imgs.length; i++) { // 动态添加图片源
            ImageView iv = new ImageView(this);
            iv.setImageResource(imgs[i]);
            iv.setScaleType(ImageView.ScaleType.CENTER);
            viewFlipper.addView(iv, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT));
        }
        viewFlipper.setAutoStart(true); // 设置自动播放功能（点击事件，前自动播放）
        viewFlipper.setFlipInterval(3000);//间隔3秒
        if (viewFlipper.isAutoStart() && !viewFlipper.isFlipping()) {
            viewFlipper.startFlipping();//自动播放
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                viewFlipper.stopFlipping();
                tempX = event.getX();
                if (tempX - startX > 50) {//向右滑动看前一页
                    viewFlipper.showPrevious();
                    viewFlipper.setInAnimation(this, R.anim.push_left_in);
                    viewFlipper.setOutAnimation(this, R.anim.push_left_out);
                } else if (startX - tempX > 50) {//向左滑动看后一页
                    viewFlipper.showNext();
                    viewFlipper.setInAnimation(this, R.anim.push_right_in);
                    viewFlipper.setOutAnimation(this, R.anim.push_right_out);
                }
                break;
        }
        return super.onTouchEvent(event);
    }
}
