/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

/**
 *
 * @author hcorrea
 */
public class Background implements Border{
    
    public BufferedImage back;

    public Background() throws IOException{
        URL imagen = new URL(getClass().getResource("/Images/fondo.png").toString());
        back = ImageIO.read(imagen);
    }
    
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int heigth) {
        g.drawImage(back, x, y, width, heigth, c);
    }

    @Override
    public Insets getBorderInsets(Component cmpnt) {
        return new Insets(0, 0, 0, 0);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }  
}
