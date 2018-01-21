/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space_shooter;

import java.awt.Graphics;



/**
 *
 * @author Garttox
 */
public class Scout extends Enemy{
    
    public Scout(int width, int height) {
        super(width, height,"scout.png",false);
        this.setSpeed(6);
        this.setHP(3);
    }
    
    
    
    public void paint(Graphics g){
        super.paint(g);
        if(this.move()){
            this.generateRandomMoveTarget();
        }
    }
    
}
