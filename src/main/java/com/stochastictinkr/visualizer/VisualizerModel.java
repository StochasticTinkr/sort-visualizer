package com.stochastictinkr.visualizer;

import jdk.jfr.Event;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.awt.*;

public class VisualizerModel {
    private SortState sortState = null;
    private int sortStateSize = 0;
    private Algorithm algorithm;
    private final Runnable onUpdate;

    public VisualizerModel(Runnable onUpdate) {
        this.onUpdate = onUpdate;
    }

    public void setSize(int size) {
        if (size != sortStateSize || sortState == null) {
            sortState = new SortState(size, new MyVisualizerListener());
            sortStateSize = size;
            onUpdate.run();
        } else {
            sortState.cleanUp();
        }
    }

    @SneakyThrows
    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
        EventQueue.invokeAndWait(onUpdate);
    }

    @NonNull
    public String getName() {
        return algorithm == null ? "none" : algorithm.getName();
    }

    @NonNull
    public BigO getBigO() {
        return algorithm == null ?  BigO.CONST : algorithm.getBigO();
    }

    public SortState getSortState() {
        return sortState;
    }

    @SneakyThrows
    public void finished() {
        EventQueue.invokeAndWait(onUpdate);
    }

    private class MyVisualizerListener implements VisualizerListener {
        @Override
        public void compared(VisualizerListElement left, VisualizerListElement right) {
        }

        @Override
        @SneakyThrows
        public void copied(VisualizerListElement from, VisualizerListElement to) {
            EventQueue.invokeAndWait(onUpdate);
        }

        @Override
        @SneakyThrows
        public void swapped(VisualizerListElement a, VisualizerListElement b) {
            EventQueue.invokeAndWait(onUpdate);
        }
    }
}
