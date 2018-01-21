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
 * @author student
 */
public class Grussmanus extends Enemy{
    public String shootImage="ubuntu.png";
    
    public Grussmanus(int width, int height) {
        super(width, height, "grus.jpg",true);
        this.setShootProperties(30, 30, Color.CYAN,10);
        this.setImageProjectiles(shootImage);
        this.setHP(1);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        if(this.move()){
            this.generateRandomMoveTarget();
        }
    }
}
