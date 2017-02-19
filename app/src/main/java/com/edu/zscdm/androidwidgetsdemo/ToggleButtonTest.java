package com.edu.zscdm.androidwidgetsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ToggleButton;

public class ToggleButtonTest extends AppCompatActivity {

    private ToggleButton toggleButton;
    private Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button_test);
        toggleButton = (ToggleButton) findViewById(R.id.toggle_btn);
        aSwitch = (Switch) findViewById(R.id.switch_btn);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    aSwitch.setText("ON");
                else
                    aSwitch.setText("OFF");
            }
        });
    }
}
