package com.edu.zscdm.androidwidgetsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter_season, adapter_month;
    String months[][] = {{"一月", "二月", "三月"}, {"四月", "五月", "六月"}, {"七月", "八月", "九月"}, {"十月", "十一月", "十二月"}};
    private Spinner spinner_season, spinner_month;
    private List<String> list_season;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_complex);
        spinner_season = (Spinner) findViewById(R.id.spinner_season);
        spinner_month = (Spinner) findViewById(R.id.spinner_month);
        spinner_season.setPrompt("请选择季节");
        initDatas();
        adapter_season = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_season);
        spinner_season.setAdapter(adapter_season);
        spinner_season.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                adapter_month = new ArrayAdapter<String>(SpinnerActivity.this, android.R.layout.simple_list_item_1, months[position]);//通过二维数组及position的值动态决定下级菜单的数据源
                adapter_month.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);//设置下拉显示样式
                spinner_month.setAdapter(adapter_month);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initDatas() {
        list_season = new ArrayList<String>();
        list_season.add("春季");
        list_season.add("夏季");
        list_season.add("秋季");
        list_season.add("冬季");

    }
}
