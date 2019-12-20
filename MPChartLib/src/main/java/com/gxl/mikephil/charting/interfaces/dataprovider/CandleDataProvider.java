package com.gxl.mikephil.charting.interfaces.dataprovider;

import com.gxl.mikephil.charting.data.CandleData;

public interface CandleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    CandleData getCandleData();
}
