package com.gxl.bluetooth.activity.seekbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.data.BarEntry;
import com.gxl.bluetooth.activity.R;
import com.gxl.bluetooth.utils.chart.MBarChart;
import com.gxl.bluetooth.activity.seekbar.barchart.MyHistoryViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineChartActivity extends AppCompatActivity {
    private MBarChart barChart,mBarChart1,mBarChart2,mBarChart3;
    private boolean isSlither=true;
    List<String> listX = new ArrayList<>();
    private MyHistoryViewPager mViewPage;
    private View view1,view2,view3;
    private List<View> viewList = new ArrayList<View>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linechart);
        initPage();
    }



       /**切换page*/
    private void initPage() {
        //对Viewpage
        mViewPage = findViewById(R.id.viewpage);
        LayoutInflater mInflater = getLayoutInflater();
        view1 = mInflater.inflate(R.layout.viewpage_one,null);
        view2 = mInflater.inflate(R.layout.viewpage_two,null);
        view3 = mInflater.inflate(R.layout.viewpage_three,null);
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        mViewPage.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //TODO 滑动按下后的位移
            }
            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    mBarChart1=findViewById(R.id.mBarChart1);
                    Random random=new Random();
                    List<BarEntry> list=new ArrayList<>();
                    for (int i=0;i<4;i++){
                        BarEntry barEntry=new BarEntry(i,i+random.nextInt(100));
                        list.add(barEntry);
                    }

                    for (int i=0;i<4;i++){
                        listX.add("2019-12-05 :09:58"+i);
                    }
                    if(listX.size()<10){
                        isSlither = false;
                    }
                    mBarChart1.setBarDataSet(mBarChart1,Color.BLUE,list.size(),list,listX,isSlither);

                }else if(position==1){
                    mBarChart2=findViewById(R.id.mBarChart2);
                    Random random=new Random();
                    List<BarEntry> list=new ArrayList<>();
                    for (int i=0;i<10;i++){
                        BarEntry barEntry=new BarEntry(i,i+random.nextInt(100));
                        list.add(barEntry);
                    }

                    for (int i=0;i<10;i++){
                        listX.add("2019-12-05 :09:58"+i);
                    }
                    if(listX.size()<10){
                        isSlither = false;
                    }
                    mBarChart2.setBarDataSet(mBarChart2,Color.BLUE,list.size(),list,listX,isSlither);
                }else if(position==2) {
                    mBarChart3=findViewById(R.id.mBarChart3);

                    Random random=new Random();
                    List<BarEntry> list=new ArrayList<>();
                    for (int i=0;i<27;i++){
                        BarEntry barEntry=new BarEntry(i,i+random.nextInt(100));
                        list.add(barEntry);
                    }

                    for (int i=0;i<27;i++){
                        listX.add("2019-12-05 :09:58"+i);
                    }
                    if(listX.size()<10){
                        isSlither = false;
                    }
                    mBarChart3.setBarDataSet(mBarChart3,Color.BLUE,list.size(),list,listX,isSlither);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                //TODO 滑动按下、滑动、结束的过程
            }
        });
        PagerAdapter pagerAdapter = new PagerAdapter() {
            //返回要滑动的VIew的个数
            @Override
            public int getCount() {
                return viewList.size();
            }
            //视图View和键对象 o是否一致
            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return view==o;
            }
            //从当前container中删除指定位置（position）的View;
            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView(viewList.get(position));
            }
            //初始化item,做了两件事，第一：将当前视图添加到container中，第二：返回当前View作为键
            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                container.addView(viewList.get(position));
                return viewList.get(position);
            }
        };
        mViewPage.setAdapter(pagerAdapter);
    }
}
