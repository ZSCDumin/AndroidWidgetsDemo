package com.edu.zscdm.androidwidgetsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class SeekBarActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        imageView = (ImageView) findViewById(R.id.iv);
        seekBar.setMax(20);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(SeekBarActivity.this, "正在拖动" + progress, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(SeekBarActivity.this, "开始拖动", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (seekBar.getProgress() <= 5) {
                    imageView.setImageResource(R.mipmap.ic_launcher);
                    seekBar.setProgress(0);
                } else if (seekBar.getProgress() > 5 && seekBar.getProgress() < 15) {
                    seekBar.setProgress(10);
                    imageView.setImageResource(R.mipmap.ic_launcher);
                } else {
                    seekBar.setProgress(20);
                    imageView.setImageResource(R.mipmap.ic_launcher);
                }
                Toast.makeText(SeekBarActivity.this, "停止拖动", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
