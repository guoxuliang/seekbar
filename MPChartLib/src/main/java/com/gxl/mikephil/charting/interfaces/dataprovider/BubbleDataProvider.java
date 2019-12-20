package com.gxl.mikephil.charting.interfaces.dataprovider;

import com.gxl.mikephil.charting.data.BubbleData;

public interface BubbleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    BubbleData getBubbleData();
}
