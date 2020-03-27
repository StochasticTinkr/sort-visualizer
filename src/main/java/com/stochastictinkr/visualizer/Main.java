package com.stochastictinkr.visualizer;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        final Arguments arguments = Arguments.parse(args);

        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException | ClassNotFoundException ignore) {
            };
            final App app = new App(arguments);
            app.start();
        });
    }
}
