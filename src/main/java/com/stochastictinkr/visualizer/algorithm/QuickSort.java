package com.stochastictinkr.visualizer.algorithm;

import com.stochastictinkr.visualizer.*;

// Broken
public class QuickSort extends Algorithm {
    public QuickSort() {
        super(BigO.NLOGN, "Quick Sort");
    }

    public void run(SortState state) {
        final VisualizerList primaryList = state.getPrimaryList();
        quickSort(primaryList, 0, primaryList.size());
    }

    /**
     * Sort the sublist that is in the range [lowIndex, highIndex)
     *
     * @param list      the list to sort
     * @param lowIndex  the inclusive low index
     * @param highIndex the exclusive high index
     */
    protected void quickSort(VisualizerList list, int lowIndex, int highIndex) {
        if (highIndex - lowIndex < 2) {
            return;
        }

        final int pivotIndex = partition(list, lowIndex, highIndex);
        quickSort(list, lowIndex, pivotIndex);
        quickSort(list, pivotIndex+1, highIndex);
    }

    protected int partition(VisualizerList list, int lowIndex, int highIndex) {
        final VisualizerListElement pivot = list.get(lowIndex);
        int lesserValueIndex = lowIndex + 1;
        int greaterValueIndex = highIndex - 1;
        while (lesserValueIndex < greaterValueIndex) {
            while (lesserValueIndex < greaterValueIndex && list.get(lesserValueIndex).isValueLessThan(pivot)) {
                ++lesserValueIndex;
            }
            while (lesserValueIndex < greaterValueIndex && list.get(greaterValueIndex).isValueGreaterThanOrEqualTo(pivot)) {
                --greaterValueIndex;
            }
            if (lesserValueIndex != greaterValueIndex) {
                list.swap(lesserValueIndex, greaterValueIndex);
            }
        }

        list.swap(lowIndex, lesserValueIndex);

        return lesserValueIndex;
    }
}
