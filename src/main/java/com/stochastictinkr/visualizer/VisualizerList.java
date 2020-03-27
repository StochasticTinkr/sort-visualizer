package com.stochastictinkr.visualizer;

import java.util.ArrayList;
import java.util.List;

public class VisualizerList {
    final VisualizerListener listener;
    private final List<VisualizerListElement> elements;

    public VisualizerList(VisualizerListener listener, int size) {
        this.listener = listener;
        elements = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
            elements.add(new VisualizerListElement(i, this));
        }
    }

    public VisualizerListElement get(int index) {
        return elements.get(index);
    }

    public void set(int index, VisualizerListElement element) {
        elements.get(index).copyValueFrom(element);
    }

    public int size() {
        return elements.size();
    }

    public void swap(int left, int right) {
        if (left != right) {
            get(left).swapWith(get(right));
        }
    }

    int[] toIntArray() {
        return elements.stream().mapToInt(VisualizerListElement::getValue).toArray();
    }
}
