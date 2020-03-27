package com.stochastictinkr.visualizer;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SortState {
    private final VisualizerList primaryList;
    private final List<VisualizerList> auxiliaryLists = new ArrayList<>();

    public SortState(int size, VisualizerListener listener) {
        this.primaryList = new VisualizerList(listener, size);
    }

    public void cleanUp() {
        auxiliaryLists.clear();
    }
}
