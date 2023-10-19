package it.unibs.pajc;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PanelGraphics extends JPanel {
    private JPanel panel1;
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

        for (int xc = r; xc <= (w+r); xc += 2 * r) {
            for (int yc = r; xc <= (h+r); yc += 2 * r) {
                //fillCircle(g2, xc, yc, r);
            }
        }

    }

    protected void fillCircle(Graphics2D g2, int xc, int yc, int r){
        int x = (xc - r);
        int y = (yc - r);
        int d = r * 2;
        g2.fillOval(x, y, d, d);
    }
}
