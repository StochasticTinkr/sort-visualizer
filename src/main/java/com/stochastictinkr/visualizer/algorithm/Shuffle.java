package com.stochastictinkr.visualizer.algorithm;

import com.stochastictinkr.visualizer.Algorithm;
import com.stochastictinkr.visualizer.BigO;
import com.stochastictinkr.visualizer.SortState;
import com.stochastictinkr.visualizer.VisualizerList;
import lombok.NonNull;

import java.util.Random;

public class Shuffle extends Algorithm {
    private final Random random = new Random();

    public Shuffle() {
        super(BigO.N, "Shuffle");
    }

    @Override
    public void run(@NonNull SortState state) {
        final VisualizerList list = state.getPrimaryList();
        for (int i = list.size(); i > 0; --i) {
            list.swap(i-1, random.nextInt(i));
        }
    }
}
