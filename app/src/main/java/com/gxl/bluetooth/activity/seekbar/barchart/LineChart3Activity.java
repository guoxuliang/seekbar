package com.gxl.bluetooth.activity.seekbar.barchart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gxl.bluetooth.activity.R;
import com.gxl.bluetooth.utils.view.ScatterChartView;
import com.gxl.bluetooth.utils.view.ScatterChartView2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineChart3Activity extends AppCompatActivity {
    ScatterChartView chartView;
    ScatterChartView2 chartView2;

    //x轴坐标对应的数据
    private List<String> xValue = new ArrayList<>();
    //y轴坐标对应的数据
    private List<Integer> yValue = new ArrayList<>();
    //折线对应的数据
    private List<Integer> value = new ArrayList<>();

    private Map<String, Integer> value2 = new HashMap<>();
    private List<Integer> yValue2 = new ArrayList<>();
    private List<String> xValue2 = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linechart3);
        setView();
    }
    private void setView() {
        chartView = findViewById(R.id.chartview);
        chartView2 = findViewById(R.id.chartview2);

        for (int i = 0; i < 12; i++) {
            xValue.add("2019-12-12 15:28");
//            value.put((i + 1) + "月", 120);//60--240
        }

        for (int i = 0; i < 4; i++) {
            yValue.add(i * 60);
        }
        for (int i = 0; i < 12; i++) {
            xValue2.add((i + 1) + "月");
            value2.put((i + 1) + "月", (int) (Math.random() * 10 + 60));//60--240
        }
        value.add(120);//60--240
        value.add(60);//60--240
        value.add(120);//60--240
        value.add(60);//60--240
        value.add(120);//60--240
        value.add(60);//60--240
        value.add(120);//60--240
        value.add(60);//60--240
        value.add(120);//60--240
        value.add(60);//60--240
        value.add(120);//60--240
        value.add(60);//60--240
        chartView.setValue(value, xValue, yValue);
        chartView2.setValue(value2, xValue2, yValue);
    }


}
