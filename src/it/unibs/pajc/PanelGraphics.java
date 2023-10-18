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

        int width = getWidth();
        int height = getHeight();

        g.drawLine(0, 0, width, height);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.printf("Mouse Moved: %d, %d\n", e.getX(), e.getY());
    }
}
