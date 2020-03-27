package com.stochastictinkr.visualizer.algorithm;

import com.stochastictinkr.visualizer.Algorithm;
import com.stochastictinkr.visualizer.BigO;
import com.stochastictinkr.visualizer.SortState;
import com.stochastictinkr.visualizer.VisualizerList;

public class BubbleSort extends Algorithm {
    public BubbleSort() {
        super(BigO.N2, "Bubble Sort");
    }

    @Override
    public void run(SortState state) {
        final VisualizerList list = state.getPrimaryList();
        int end = list.size();
        int swaps;
        do {
            swaps = 0;
            for (int i = 0; i < end-1; ++i) {
                if (list.get(i).isValueGreaterThan(list.get(i+1))) {
                    list.swap(i, i+1);
                    ++swaps;
                }
            }
            --end;
        } while (swaps > 0);
    }
}
