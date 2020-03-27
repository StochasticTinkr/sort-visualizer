package com.stochastictinkr.visualizer;

public interface VisualizerListener {
    void compared(VisualizerListElement left, VisualizerListElement right);
    void copied(VisualizerListElement from, VisualizerListElement to);
    void swapped(VisualizerListElement a, VisualizerListElement b);
}
