package com.gxl.bluetooth.activity.seekbar.barchart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gxl.bluetooth.activity.R;
import com.gxl.bluetooth.utils.MyLineChartView;
import com.gxl.bluetooth.utils.music.PlayVoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BarChartActivity extends AppCompatActivity {
    MyLineChartView chartView;
    List<String> xValues;   //x轴数据集合
    List<Integer> yValues;  //y轴数据集合
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barchart);
        PlayVoice.playVoice(this,1);

        chartView = (MyLineChartView) findViewById(R.id.linechartview);
        xValues = new ArrayList<>();
        yValues = new ArrayList<>();
        for (int i=0;i<10;i++){
            xValues.add("2019-12-20 17:20:30"+i);
        }
        Random random=new Random();
        for (int i=0;i<10;i++){
            yValues.add(random.nextInt(100)*2+10);
        }
        // xy轴集合自己添加数据
        chartView.setXValues(xValues);
        chartView.setYValues(yValues);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        PlayVoice.stopVoice();
    }
}