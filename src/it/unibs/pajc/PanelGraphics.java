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
            red = (xc / (2 * r) % 2 == 0 ? true : false);

            for (int yc = r; yc <= (h+r); yc += 2 * r) {
                g2.setColor(red ? Color.red : Color.blue);
                fillCircle(g2, xc, yc, r);
                red = !red;
            }
        }

        g2.setColor(Color.black);
        g2.drawString(String.format("[%3d]", mouse_moved_counter),10, 10);

        g2.setColor(Color.yellow);
        fillCircle(g2, mouse_current_x, mouse_current_y, r);

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

    private int mouse_moved_counter;
    private int mouse_current_x;
    private int mouse_current_y;
    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.printf("Mouse Moved[%d]: %d, %d\n",mouse_moved_counter++, e.getX(), e.getY());
        mouse_current_x = e.getX();
        mouse_current_y = e.getY();
        this.repaint();
    }
}
