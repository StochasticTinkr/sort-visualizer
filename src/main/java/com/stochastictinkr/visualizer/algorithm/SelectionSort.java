package com.stochastictinkr.visualizer.algorithm;

import com.stochastictinkr.visualizer.*;
import lombok.NonNull;

public class SelectionSort extends Algorithm {
    public SelectionSort() {
        super(BigO.N2, "Selection Sort");
    }

    @Override
    public void run(@NonNull SortState state) {
        final VisualizerList list = state.getPrimaryList();
        for (int i = 0; i < list.size(); ++i) {
            VisualizerListElement lowest = list.get(i);
            for (int j = i+1; j < list.size(); ++j) {
                final VisualizerListElement current = list.get(j);
                if (current.isValueLessThan(lowest)) {
                    lowest = current;
                }
            }
            lowest.swapWith(list.get(i));
        }
    }
}
