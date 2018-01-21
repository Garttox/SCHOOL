/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space_shooter;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Garttox
 */
public class BernyBoss extends Enemy{
    public String shootImage="nulu.png";
    
    public BernyBoss(int width, int height) {
        super(width, height, "berny.png",true);
        this.setImageSize(140, 100);
        this.setShootProperties(100, 30, Color.white,6);
        this.setImageProjectiles(shootImage);
        this.setHP(49);
        this.setShootDelay(65);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        if(this.move()){
            this.generateRandomMoveTarget();
        }
        
    }
    
    public void setHP(int d){
        super.setHP(d);
        if(this.getHp()==20){
            this.changeImage("bernyFazeDva.png");
            this.setImageProjectiles("nuluBlesk.png");
            this.setShootProperties(100, 30, Color.white, 10);
            this.setShootDelay(55);
        }
    }
}
