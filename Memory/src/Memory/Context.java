/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memory;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Miguel
 */
public class Context extends JFrame {
    
    /**
     Control de la ventana FullScreen 
     
     */

    GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    private fondo panel;

    public Context() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setTitle("Memory");
        ImageIcon fondo = new ImageIcon(this.getClass().getResource("/Resources/fondo.png"));
        panel = new fondo(fondo.getImage());
        getContentPane().add(panel, BorderLayout.CENTER);//agrega y ubica el fondo!
        this.pack();
        this.setVisible(true);
        device.setFullScreenWindow(this);
    }

}

class fondo extends JPanel {

    private Image img;

    public fondo(Image img) {
        this.img = img;
        Dimension dimension = new Dimension(400, 660);
        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);
        this.setMaximumSize(dimension);
        this.setSize(dimension);
        this.setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
