package com.stochastictinkr.visualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;

public class Visualizer extends JComponent {
    private final VisualizerModel model;

    public Visualizer(VisualizerModel model) {
        this.model = model;
    }

    @Override
    protected void paintComponent(Graphics g) {
        render((Graphics2D) g);
    }

    public void render() {
        if (getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        final Image image = createImage(getWidth(), getHeight());
        final Graphics2D g2d = (Graphics2D) image.getGraphics();
        render(g2d);
        g2d.dispose();
        getGraphics().drawImage(image, 0, 0, null);
    }

    private void render(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(Color.GREEN);
        final FontMetrics fontMetrics = g2d.getFontMetrics();
        g2d.drawString(model.getName(), 10f, fontMetrics.getHeight() + 10f);
        g2d.drawString(model.getBigO().getDescription(), 10f, fontMetrics.getHeight()*2 + 10f);
        final VisualizerList primaryList = model.getSortState().getPrimaryList();
        int[] currentListState = primaryList.toIntArray();
        int length = currentListState.length;
        double barWidth = getWidth() / (double)length;
        double heightPer = getHeight() / (double)length;
        for (int i = 0; i < length; ++i) {
            Rectangle2D rectangle2D = new Rectangle2D.Double();
            final int value = currentListState[i];
            float delta = Math.abs(value - i);
            delta /= length;
            g2d.setColor(new Color(delta, 0f, 1-delta));
            final double height = heightPer * value;
            rectangle2D.setFrame(i * barWidth, getHeight() - height, barWidth-1, height);
            g2d.fill(rectangle2D);
        }
    }
}
