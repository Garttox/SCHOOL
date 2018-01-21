/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space_shooter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author student
 */
class PewLaser {
    private final Color color;
    private final int speed;
    private final int width;
    private final int height;
    private int x;
    private int y;
    private int screenWidth;
    private int screenHeight;
    private boolean useImage;
    private Image image;
    
    public PewLaser(Color color, int speed, int width, int height, int x, int y,int screenWidth, int screenHeight) {
        this.useImage=false;
        this.color=color;
        this.speed=speed;
        this.width=width;
        this.height=height;
        this.x=x;
        this.y=y;
        this.screenHeight=screenHeight;
        this.screenWidth=screenWidth;
    }

    public void setImage(String image) {
        try{
            this.image = ImageIO.read(this.getClass().getResource("pictures/"+image));
        } catch(IOException ex){
            
        }
    }
    
    
    
    public void paint(Graphics g){
        if(useImage){
            g.drawImage(this.image, x, y, this.width, this.height, null);
        }
        else{
            g.setColor(color);
            g.fillRect(this.x, this.y, this.width, this.height);
        }
    }
    
    public boolean moveR(){
        if(!(this.x > this.screenWidth)){
            this.x+=speed;
            return false;
        }
        else{
            return true;
        }

    }
    
    public boolean moveL(){
        if(!(this.x < 0)){
            this.x-=speed;
            return false;
        }
        else{
            return true;
        }
    }
    
    public boolean hitDetect(int objX, int objY, int sizeX, int sizeY){
        if((this.x <= objX+sizeX && this.x >= objX && this.y <= objY+sizeY && this.y >= objY) || (this.x+this.width <= objX+sizeX && this.x+this.width >= objX && this.y+this.height <= objY+sizeY && this.y+this.height>=objY ) )
            return true;
        else{
            return false;
        }
    }

    public void setUseImage(boolean useImage) {
        this.useImage = useImage;
    }
    
    
}

