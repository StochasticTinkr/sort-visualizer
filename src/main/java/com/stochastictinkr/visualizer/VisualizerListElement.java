package com.stochastictinkr.visualizer;


public class VisualizerListElement {
    private VisualizerList parent;
    private int index;
    private int value;

    public VisualizerListElement(int index, VisualizerList parent) {
        this.index = index;
        this.value = index;
        this.parent = parent;
    }

    public int getIndex() {
        return index;
    }

    private int compareTo(VisualizerListElement that) {
        parent.listener.compared(this, that);
        return Integer.compare(value, that.value);
    }

    public boolean isValueLessThan(VisualizerListElement that) {
        return compareTo(that) < 0;
    }

    public boolean isValueEqualTo(VisualizerListElement that) {
        return compareTo(that) == 0;
    }

    public boolean isValueGreaterThan(VisualizerListElement that) {
        return compareTo(that) > 0;
    }

    public boolean isValueLessThanOrEqualTo(VisualizerListElement that) {
        return compareTo(that) <= 0;
    }

    public boolean isValueGreaterThanOrEqualTo(VisualizerListElement that) {
        return compareTo(that) >= 0;
    }

    public void copyValueFrom(VisualizerListElement element) {
        parent.listener.copied(element, this);
        value = element.value;
    }

    public void swapWith(VisualizerListElement that) {
        parent.listener.swapped(this, that);
        int oldValue = this.value;
        this.value = that.value;
        that.value = oldValue;
    }

    int getValue() {
        return value;
    }
}
