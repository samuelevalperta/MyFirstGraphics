package it.unibs.pajc;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PanelGraphics extends JPanel implements MouseMotionListener {

    public PanelGraphics() {
        this.addMouseMotionListener(this);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        g.drawLine(0, 0, w, h);
        g.drawLine(0, h, w, 0);

        g.setColor(Color.blue);

        int d = 60;
        int r = d/2;

        boolean red;
        for (int xc = r; xc <= (w+r); xc += 2 * r) {
            // this will make the first circle of every column to be different from the first of the previous column
            red = (xc / (2 * r) % 2 == 0);

            for (int yc = r; yc <= (h+r); yc += 2 * r) {
                g2.setColor(red ? Color.red : Color.blue);
                fillCircle(g2, xc, yc, r);

                // Highlight if mouse hover
                if ((Math.abs(mouseCurrentPosition.x - xc) <= r) && (Math.abs(mouseCurrentPosition.y - yc) <= r)) {
                    g2.setStroke(new BasicStroke(2));
                    g2.setColor(Color.YELLOW);
                    emptyCircle(g2, xc, yc, r);
                    g2.setStroke(new BasicStroke(1));
                }

                red = !red;
            }
        }

        g2.setColor(Color.black);
        g2.drawString(String.format("[%3d]", repaintCounter++),10, 10);

        g2.setColor(Color.yellow);
        if (mouseCurrentPosition != null) {
            fillCircle(g2, mouseCurrentPosition.x, mouseCurrentPosition.y, 10);
        }

    }

    protected void fillCircle(Graphics2D g2, int xc, int yc, int r){
        int x = (xc - r);
        int y = (yc - r);
        int d = r * 2;
        g2.fillOval(x, y, d, d);
    }

    protected void emptyCircle(Graphics2D g2, int xc, int yc, int r){
        int x = (xc - r);
        int y = (yc - r);
        int d = r * 2;
        g2.drawOval(x, y, d, d);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    private int repaintCounter;
    private Point mouseCurrentPosition = null;
    @Override
    public void mouseMoved(MouseEvent e) {
        mouseCurrentPosition = e.getPoint();
        this.repaint();
    }
}
