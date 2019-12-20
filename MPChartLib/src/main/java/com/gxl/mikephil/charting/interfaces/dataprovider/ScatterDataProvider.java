package com.gxl.mikephil.charting.interfaces.dataprovider;

import com.gxl.mikephil.charting.data.ScatterData;

public interface ScatterDataProvider extends BarLineScatterCandleBubbleDataProvider {

    ScatterData getScatterData();
}
