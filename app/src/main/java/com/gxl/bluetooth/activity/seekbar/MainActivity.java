package com.gxl.bluetooth.activity.seekbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.gxl.bluetooth.activity.R;
import com.gxl.bluetooth.activity.scatterchart.ScatterActivity;
import com.gxl.bluetooth.activity.seekbar.barchart.BarChartActivity;
import com.gxl.bluetooth.activity.seekbar.barchart.LineChart3Activity;
import com.gxl.bluetooth.utils.chart.BarCharts;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    private BarChart mBarChart;
    private BarCharts mBarCharts;
//    private String[] color = {"#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD"};
    boolean sex = true;
    ArrayList<String> xValues;
    private Button linebtn,jieya,zhexian,qipao,sandain,zhuzhuangtu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBarCharts = new BarCharts();
        xValues = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            xValues.add("" + (i + 1) + "");// 设置每个柱壮图的文字描述
        }
        // 创建多张图表
        mBarChart = (BarChart) findViewById(R.id.mBarChart);
if(xValues.size()<=5){
    sex = false;
}
        mBarCharts.showBarChart(mBarChart, getBarData(xValues.size(), 199), sex);
        linebtn = findViewById(R.id.linebtn);
        linebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LineChartActivity.class);
                startActivity(intent);
            }
        });
        jieya = findViewById(R.id.jieya);
        jieya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initYS();
            }
        });
        zhexian = findViewById(R.id.zhexian);
        zhexian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LineChart2Activity.class);
                startActivity(intent);
            }
        });
        qipao = findViewById(R.id.qipao);
        qipao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, LineChart3Activity.class);
                startActivity(intent);
            }
        });
        sandain = findViewById(R.id.sandian);
        sandain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ScatterActivity.class);
                startActivity(intent);
                double c = 3;
                String myformat= new DecimalFormat("0.00").format(c);
//                String str = myformat.format(c);
                double i=1*25;
                Toast.makeText(MainActivity.this,"str:"+myformat+"i:::"+new java.text.DecimalFormat("0.00").format(i),Toast.LENGTH_LONG).show();
            }
        });
        zhuzhuangtu = findViewById(R.id.zhuzhuangtu);
        zhuzhuangtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, BarChartActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 这个方法是初始化数据的
     * @param count X 轴的个数
     * @param range Y 轴的数据
     */
    public BarData getBarData(int count, float range) {
        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i <13; i++) {
            xValues.add("2019-12-04 14:13" + (i + 1) + "");// 设置每个柱壮图的文字描述
        }

        ArrayList<BarEntry> yValues = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            float value = (float) (Math.random() * range/*100以内的随机数*/) + 3;
            yValues.add(new BarEntry(value, i));
        }
        // y轴的数据集合
        BarDataSet barDataSet = new BarDataSet(yValues, "测试图");
        // 设置栏阴影颜色
        barDataSet.setBarShadowColor(Color.parseColor("#01000000"));
        ArrayList<BarDataSet> barDataSets = new ArrayList<>();
        barDataSets.add(barDataSet);
        barDataSet.setValueTextColor(Color.parseColor("#FF8F9D"));
        // 绘制值
        barDataSet.setDrawValues(true);
//        barDataSet.setBarSpacePercent(50f);
        BarData barData = new BarData(barDataSet);
        return barData;
    }


    private void initYS() {
        char[] Date_Msg = new char[5];
        char[] ReadDate = new char[8];
        //测试数据
        Date_Msg[0]=0x66;
        Date_Msg[1]=0xA9;
        Date_Msg[2]=0x9D;
        Date_Msg[3]=0xCC;
        Date_Msg[4]=0x4E;

        Log.i("ReadDate:::","ReadDate:::"+ReadDate);
        for(int i=0;i<ReadDate.length;i++){
            System.out.println(ReadDate[i]+0);
            ReadDate=Decompress_Times(Date_Msg);
        }
    }
    public static char[] Decompress_Times(char[] Src_Msg){
        char[] Dst_Msg = new char[8];
        //年 0-63
        Dst_Msg[0]= (char)((Src_Msg[4]>>2)&0x3f);
        //月
        Dst_Msg[1]= (char)((((Src_Msg[4]<<2)&0x0c)|((Src_Msg[3]>>6)&0x03))&0x0f);
        //日
        Dst_Msg[2]= (char)((Src_Msg[3]>>1)&0x1f);
        //年
        Dst_Msg[3]=(char)((((Src_Msg[3]<<5)&0x20)|((Src_Msg[2]>>3)&0x1f))&0x3f);
        //月
        Dst_Msg[4]=(char)((((Src_Msg[2]<<1)&0x0e)|((Src_Msg[1]>>7)&0x01))&0x0f);
        //年
        Dst_Msg[5]=(char)((Src_Msg[1]>>1)&0x3f);
        //月
        Dst_Msg[6]=(char)((((Src_Msg[1]<<3)&0x08)|((Src_Msg[0]>>5)&0x07))&0x0f);
        //日
        Dst_Msg[7]=(char)(Src_Msg[0]&0x1f);
        return Dst_Msg;
    }

}