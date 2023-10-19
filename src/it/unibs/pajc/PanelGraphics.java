package it.unibs.pajc;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PanelGraphics extends JPanel implements MouseMotionListener {
    private JPanel panel1;

    public PanelGraphics() {
        this.addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        g.drawLine(0, 0, width, height);
        g.drawLine(0, height, width, 0);

        g.setColor(Color.blue);

        int d = 60;
        int r = d/2;

        fillCircle(g2, width/2, height/2, r);

    }

    protected void fillCircle(Graphics2D g2, int xc, int yc, int r){
        int x = (xc - r);
        int y = (yc - r);
        int d = r * 2;
        g2.fillOval(x, y, d, d);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.printf("Mouse Moved: %d, %d\n", e.getX(), e.getY());
    }
}
