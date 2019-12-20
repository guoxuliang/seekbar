package com.gxl.bluetooth.activity.scatterchart;

import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.gxl.bluetooth.activity.R;
import com.gxl.bluetooth.utils.view.MyAxisValueFormatter;

import java.util.ArrayList;

public class ScatterActivity extends AppCompatActivity {
    ScatterChart mScatterChart;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scatter);
//
//        //散点图
        mScatterChart = (ScatterChart) findViewById(R.id.scatterchart);
        mScatterChart.getDescription().setEnabled(false);
        mScatterChart.setDrawGridBackground(false);
        mScatterChart.setTouchEnabled(false);
        mScatterChart.setMaxHighlightDistance(10f);

        // 支持缩放和拖动
        mScatterChart.setDragEnabled(true);
        mScatterChart.setScaleEnabled(true);

        mScatterChart.setMaxVisibleValueCount(10);
        mScatterChart.setPinchZoom(true);

        XAxis xAxis = mScatterChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        mScatterChart.getAxisRight().setEnabled(false); // 隐藏右边 的坐标轴
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(7);
        xAxis.setLabelRotationAngle(80);//柱的下面描述文字  旋转90度
        IAxisValueFormatter custom = new MyAxisValueFormatter();

        YAxis leftAxis = mScatterChart.getAxisLeft();
        leftAxis.setLabelCount(10, false);
        leftAxis.setValueFormatter(custom);
        leftAxis.setSpaceTop(100f);
        leftAxis.setAxisMinimum(0f);

        YAxis rightAxis = mScatterChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setLabelCount(10, false);
        rightAxis.setValueFormatter(custom);
        rightAxis.setSpaceTop(100f);
        rightAxis.setAxisMinimum(0f);
        Matrix mMatrix = new Matrix();
        mMatrix.postScale(2f, 1f);
        mScatterChart.getViewPortHandler().refresh(mMatrix, mScatterChart, false);
        mScatterChart.animateY(1000);
        setData();
    }
//    //设置数据
    float val;
    private void setData() {
        ArrayList<Entry> yVals2 = new ArrayList<Entry>();
        for (int i = 0; i < 10; i++) {
            if(i%2==0){
                 val = 5;
            }else {
                 val = 6;
            }

            yVals2.add(new Entry(i, val,"开机"));
        }
        //创建一个数据集,并给它一个类型
        ScatterDataSet set2 = new ScatterDataSet(yVals2, "");
        set2.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
        set2.setScatterShapeHoleColor(ColorTemplate.VORDIPLOM_COLORS[3]);
        set2.setScatterShapeHoleRadius(5f);
        set2.setScatterShapeSize(5f);
        ArrayList<IScatterDataSet> dataSets = new ArrayList<IScatterDataSet>();
        dataSets.add(set2);
        //创建一个数据集的数据对象
        ScatterData data = new ScatterData(dataSets);
        mScatterChart.setData(data);
        mScatterChart.invalidate();
    }

}
