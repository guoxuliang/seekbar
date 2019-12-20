package com.gxl.mikephil.charting.interfaces.dataprovider;

import com.gxl.mikephil.charting.components.YAxis;
import com.gxl.mikephil.charting.data.LineData;

public interface LineDataProvider extends BarLineScatterCandleBubbleDataProvider {

    LineData getLineData();

    YAxis getAxis(YAxis.AxisDependency dependency);
}
