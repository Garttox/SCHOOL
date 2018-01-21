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
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Garttox
 */
public class Enemy {
    private Image image;
    private int ImageX;
    private int ImageY;
    private int speed;
    private int y;
    private int x;
    private int shootDelay=30;
    private int shootDelayCounter;
    private ArrayList<PewLaser> projectiles;
    private int screenWidth;
    private int screenHeight;
    
    private int targetX=500;
    private int targetY=500;
    
    private String imageProjectileName;
    private boolean ImageProjectiles=false;
    private int shootWidth = 10;
    private int shootHeight = 5;
    private Color shootColor = Color.RED;
    private int shootSpeed = 10;
    private int hp=1;
    
    public Enemy(int width,int height,String image,boolean ImageProjectiles){
        this.ImageProjectiles=ImageProjectiles;
        this.screenWidth=width;
        this.screenHeight=height;
        this.y=100;
        this.x=(int)Math.floor(Math.random()*500)+800;
        this.speed=5;
        this.ImageX=46;
        this.ImageY=50;
        this.projectiles = new ArrayList();
        this.shootDelayCounter=0;
        
        try{
            this.image = ImageIO.read(this.getClass().getResource("pictures/"+image));
        } catch(IOException ex){
            
        }
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setImageProjectiles(String imageProjectileName) {
        this.imageProjectileName=imageProjectileName;
    }
    
    
    
    public void setImageSize(int width, int height){
        this.ImageX=width;
        this.ImageY=height;
    }
    
    public void setShootProperties(int shootWidth,int shootHeight, Color shootColor, int speed){
        this.shootWidth=shootWidth;
        this.shootHeight=shootHeight;
        this.shootColor=shootColor;
        this.shootSpeed=speed;
    }
    
    public void createPew(){
        int pewX=this.x-this.ImageX;
        int pewY=this.y+(this.ImageY)/2;
        PewLaser pew=new PewLaser(shootColor,shootSpeed,shootWidth,shootHeight,pewX,pewY,screenWidth,screenHeight);
        projectiles.add(pew);
    }
    
    public void createImagePew(String imageName){
        int pewX=this.x-this.ImageX;
        int pewY=this.y+(this.ImageY)/2;
        PewLaser pew=new PewLaser(shootColor,shootSpeed,shootWidth,shootHeight,pewX,pewY,screenWidth,screenHeight);
        pew.setImage(imageName);
        pew.setUseImage(true);
        projectiles.add(pew);
    }
    
    public void paint(Graphics g){
        if(this.shootDelayCounter==this.shootDelay){
            if(ImageProjectiles)
                this.createImagePew(imageProjectileName);
            else
                this.createPew();
            this.shootDelayCounter=0;
        }
        this.projectiles.forEach((i) -> {
            i.paint(g);
        });
        g.drawImage(this.image, x, y, ImageX, ImageY, null);
        this.shootDelayCounter++;
    }
    
    public void generateRandomMoveTarget(){
        this.targetX=(int)(Math.random()*(this.screenWidth-200)+250);
        this.targetY=(int)(Math.random()*(this.screenHeight-150)+100);
    }
    
    public boolean move(){
        if(this.x <= this.targetX+this.speed && this.x >= this.targetX-this.speed && this.y <= this.targetY+this.speed && this.y >= this.targetY-this.speed){
            return true;
        }
        else{
            double z = Math.sqrt(Math.pow(this.targetX-this.x,2)+Math.pow(this.targetY-this.y,2));
            double cosX=(this.targetX-this.x)/(z);
            double cosY=(this.targetY-this.y)/(z);
            int shiftX =(int)(cosX*this.speed);
            int shiftY =(int)(cosY*this.speed);
            this.x+=shiftX;
            this.y+=shiftY;
            return false;
        }
    }

    public ArrayList<PewLaser> getProjectiles() {
        return projectiles;
    }

    public int getImageX() {
        return ImageX;
    }

    public int getImageY() {
        return ImageY;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setShootDelay(int shootDelay) {
        this.shootDelay = shootDelay;
    }
    public void setHP(int d){
        this.hp+=d;
    }
    
    public int getHp(){
        return this.hp;
    }
    
    public void changeImage(String image){
        try{
            this.image = ImageIO.read(this.getClass().getResource("pictures/"+image));
        } catch(IOException ex){
            
        }
    }
}



