/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space_shooter;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author Garttox
 */
public class ImageContainer extends JComponent{
    private Image image;
    private int width;
    private int height;
    public ImageContainer(String imageName, int width, int height) {
        this.width=width;
        this.height=height;
        try{
            this.image = ImageIO.read(this.getClass().getResource("pictures/"+imageName));
        } catch(IOException ex){
            
        }
        this.repaint();
        ;
    }
    
    public void paint(Graphics g){
        g.drawImage(this.image, 0, 0, this.width, this.height, null);
    }
    
}
