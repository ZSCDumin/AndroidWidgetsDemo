package com.edu.zscdm.androidwidgetsdemo;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.arvin.gifloader.core.GifLoader;
import com.arvin.gifloader.widget.GifView;

public class MainActivity extends AppCompatActivity {
    private AnimationDrawable animationDrawable;
    private ImageView imageView;
    private GifView gifView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gifView= (GifView) findViewById(R.id.gif);
        imageView= (ImageView) findViewById(R.id.iv);
        imageView.setImageResource(R.drawable.anim_list);
        animationDrawable= (AnimationDrawable) imageView.getDrawable();
        animationDrawable.start();

        GifLoader.getInstance().displayGif(gifView, "https://media.giphy.com/media/cbWQm0HonZORq/giphy.gif");
    }
}
