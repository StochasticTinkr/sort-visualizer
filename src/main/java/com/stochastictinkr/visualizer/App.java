package com.stochastictinkr.visualizer;

import com.stochastictinkr.visualizer.algorithm.BubbleSort;
import com.stochastictinkr.visualizer.algorithm.SelectionSort;
import com.stochastictinkr.visualizer.algorithm.Shuffle;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;


public class App {
    private final Arguments arguments;
    private final JFrame mainFrame;
    private final VisualizerModel model = new VisualizerModel(this::repaintVisualizer);
    private final Visualizer visualizer;

    public App(Arguments arguments) {
        this.arguments = arguments;
        mainFrame = new JFrame("Sort Visualizer");
        mainFrame.setLocationByPlatform(true);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        visualizer = new Visualizer(model);
        mainFrame.add(visualizer);
    }

    private void repaintVisualizer() {
        visualizer.render();
    }

    public void start() {
        mainFrame.setVisible(true);
        new Thread(new RunAlgorithms()).start();
    }


    private int getAppropriateSize(BigO bigO) {
        switch (bigO) {
            case N:
            case NLOGN:
                return 256;
            case N2:
            case EXP:
            default:
                return 64;
        }
    }

    private class RunAlgorithms implements Runnable {
        private final Algorithm shuffle = new Shuffle();

        @Override
        public void run() {
            List<Supplier<Algorithm>> algorithms = Arrays.asList(
//                    QuickSort::new, // QuickSort is currently broken
                    BubbleSort::new,
                    SelectionSort::new
            );

            for (Supplier<Algorithm> algorithmSupplier : algorithms) {
                final Algorithm algorithm = algorithmSupplier.get();
                final int appropriateSize = getAppropriateSize(algorithm.getBigO());
                model.setSize(appropriateSize);
                runAlgorithm(shuffle);
                runAlgorithm(algorithm);
            }
            model.finished();
        }

        private void runAlgorithm(Algorithm algorithm) {
            System.out.println("Starting: " + algorithm.getName() + "--" + algorithm.getBigO().getDescription());
            setAlgorithm(algorithm);
            System.out.println("Running...");
            algorithm.run(model.getSortState());
            System.out.println("Completed...");
        }

        @SneakyThrows
        private void setAlgorithm(Algorithm algorithm) {
            model.setAlgorithm(algorithm);
        }
    }

}
