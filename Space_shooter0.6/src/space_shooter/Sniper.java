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
public class Sniper extends Enemy{
    
    public Sniper(int width, int height) {
        super(width, height, "sniper.png",false);
        this.setShootProperties(15, 20, Color.CYAN,30);
        this.setShootDelay(60);
        this.setImageSize(50, 50);
        this.setSpeed(5);
        this.setHP(2);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        if(this.move()){
            this.generateRandomMoveTarget();
        }
    }
}
