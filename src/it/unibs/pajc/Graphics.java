package it.unibs.pajc;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.EventQueue;

public class Graphics extends JFrame {

    public Graphics() {
        setTitle("Title");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        PanelGraphics panelGraphics = new PanelGraphics();

        add(panelGraphics);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Graphics frame = new Graphics();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
