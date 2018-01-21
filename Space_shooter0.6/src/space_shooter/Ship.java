/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space_shooter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;



/**
 *
 * @author Garttox
 */
public class Ship implements KeyListener {
    private int speed;
    private Image image;
    private int ImageX;
    private int ImageY;
    private int y;
    private final int x=5;
    boolean wKey,sKey,lKey;
    private final int shootDelay=15;
    private int shootDelayCounter;
    private ArrayList<PewLaser> projectiles;
    private boolean pew;
    private int screenWidth;
    private int screenHeight;
    private int hp;
    
    public Ship(int width,int height){
        this.screenWidth=width;
        this.screenHeight=height;
        this.pew=true;
        this.speed=8;
        this.y=0;
        this.ImageX=85;
        this.ImageY=65;
        this.projectiles = new ArrayList();
        this.hp=5;
        
        try{
            this.image = ImageIO.read(this.getClass().getResource("pictures/ShipImageRotate.png"));
        } catch(IOException ex){
            
        }
    }
    
    public void paint(Graphics g){
        if(this.shootDelayCounter == this.shootDelay){
            this.pew=true;
            this.shootDelayCounter=0;
        }
        g.drawImage(this.image, x, y, ImageX, ImageY, null);
        this.projectiles.forEach((i) -> {
            i.paint(g);
        });
        if (wKey) {
            //System.out.println("up " + this.getY());
            this.moveUp();
        }
        if (sKey) {
            //System.out.println("down " + this.getY());
            this.moveDown();
        }
        if (lKey) {
            //System.out.println("pew");
            if (pew) {
                this.createPew();
                pew = false;
            }

        }
        shootDelayCounter++;
    }
    
    public void moveUp(){
        if(!(this.y <=0))
            this.y -=speed;
    }
    
    public void moveDown(){
        if(this.y <=(this.screenHeight-(this.ImageY*1.5)))
            this.y +=speed;
    }
    
    public void createPew(){
        int pewX=this.x+this.ImageX;
        int pewY=this.y+(this.ImageY)/2;
        PewLaser pew=new PewLaser(Color.BLUE,10,10,5,pewX,pewY,screenWidth,screenHeight);
        projectiles.add(pew);
    }
    
    public ArrayList<PewLaser> getProjectiles() {
        return projectiles;
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch(ke.getKeyCode()){
            case KeyEvent.VK_W:
                wKey=true;
                break;
            case KeyEvent.VK_S:
                sKey=true;
                break;
            case KeyEvent.VK_L:
                lKey=true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        switch(ke.getKeyCode()){
            case KeyEvent.VK_W:
                wKey=false;
                break;
            case KeyEvent.VK_S:
                sKey=false;
                break;
            case KeyEvent.VK_L:
                lKey=false;
                break;
        }
    }

    public int getImageX() {
        return ImageX;
    }

    public int getImageY() {
        return ImageY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setHP(int d){
        this.hp+=d;
    }

    public int getHp() {
        return hp;
    }
    
}
