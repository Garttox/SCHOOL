/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space_shooter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Garttox
 */
public class Canvas extends JComponent implements ActionListener{
    private Ship playerShip;
    private ArrayList<Enemy> enemy;
    private Timer timer;
    private int height;
    private int width;
    private JLabel label;
    private Space_shooter menu;
    private int score=0;
    private final int[][] squadrons={{2,1,0},{1,1,1},{1,2,0},{0,0,3},{3,0,0}};
    private boolean spawnBoss=false;
    
    public Canvas(int height, int width, JLabel label, Space_shooter menu){
        this.enemy=new ArrayList();
        playerShip=new Ship(width,height);
        this.height=height;
        this.width=width;
        this.label=label;
        this.menu=menu;
    }
    
    public void addEnemy() {
        int i = (int) Math.floor(Math.random() * 5);
        int spacing=(int)height/(squadrons[i][0]+squadrons[i][1]+squadrons[i][2]);
        int position=1;
        System.out.println(i);
        for (int scouts = 0; scouts < squadrons[i][0]; scouts++) {
            Scout scout = new Scout(this.width, this.height);
            scout.setY(this.height-spacing*position);
            enemy.add(scout);
            position++;
        }

        for (int snipers = 0; snipers < squadrons[i][1]; snipers++) {
            Sniper sniper = new Sniper(this.width, this.height);
            sniper.setY(this.height-spacing*position);
            enemy.add(sniper);
            position++;
        }

        for (int grussmanns = 0; grussmanns < squadrons[i][2]; grussmanns++) {
            Grussmanus grussmanus = new Grussmanus(this.width, this.height);
            grussmanus.setY(this.height-spacing*position);
            enemy.add(grussmanus);
            position++;
        }
    }
    
    public void init(){
        this.addEnemy();
        this.addKeyListener(playerShip);
        this.setFocusable(true);
        timer = new Timer(16, this);
        timer.start();
    }
    
    
    public void paint(Graphics g) {
        g.setColor(Color.black);
        Dimension size = this.getSize();
        g.fillRect(0, 0, size.width, size.height);
        this.playerShip.paint(g);
        Iterator<Enemy> enemies = this.enemy.iterator();
        while(enemies.hasNext())
            enemies.next().paint(g);
        this.label.setText("HP: "+this.playerShip.getHp()+"           Score: "+this.score+"                             Pohyb nahoru \"W\"  Pohyb dolů \"S\"  Střelba \"L\"            Za každých 50 score +1 HP");
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        ArrayList<PewLaser> projectilesPlayer= this.playerShip.getProjectiles();
        Iterator<PewLaser> itr = projectilesPlayer.iterator();
        while(itr.hasNext()) {
         if (itr.next().moveR())
            itr.remove();
        }
        
        ArrayList<PewLaser> projectilesPlayerHit= this.playerShip.getProjectiles();
        
        Iterator<Enemy> enemies = this.enemy.iterator();
        
        while(enemies.hasNext()){
            Enemy currentEnemy=enemies.next();
            Iterator<PewLaser> itr2 = projectilesPlayerHit.iterator();
            while (itr2.hasNext()) {
                if (itr2.next().hitDetect(currentEnemy.getX(), currentEnemy.getY(), currentEnemy.getImageX(), currentEnemy.getImageY())) {
                    itr2.remove();
                    currentEnemy.setHP(-1);
                }
            }
        }

        enemies = this.enemy.iterator();
        while (enemies.hasNext()) {
            Enemy currentEnemy=enemies.next();
            ArrayList<PewLaser> projectilesEnemy = currentEnemy.getProjectiles();
            Iterator<PewLaser> itrE = projectilesEnemy.iterator();
            while (itrE.hasNext()) {
                if (itrE.next().moveL())
                    itrE.remove();
            }
        }
        
        enemies = this.enemy.iterator();  
        while (enemies.hasNext()) {
            Enemy currentEnemy=enemies.next();
            ArrayList<PewLaser> projectilesEnemy2 = currentEnemy.getProjectiles();
            Iterator<PewLaser> itrE2 = projectilesEnemy2.iterator();
            while (itrE2.hasNext()) {
                if (itrE2.next().hitDetect(this.playerShip.getX(), this.playerShip.getY(), this.playerShip.getImageX(), this.playerShip.getImageY())) {
                    itrE2.remove();
                    this.playerShip.setHP(-1);
                }

            }
        }


        if(this.playerShip.getHp()<=0){
                this.menu.gameOver(this.score);
            this.timer.stop();
        }
        
        enemies = this.enemy.iterator();  
        while (enemies.hasNext()){
            Enemy currentEnemy=enemies.next();
            if(currentEnemy.getHp()<=0){
                if(currentEnemy.getClass().getSimpleName().equals("BernyBoss")){
                    this.score+=15;
                }
                else{
                    this.score+=5;
                }
                
                if(this.score%50==0){
                    this.playerShip.setHP(1);
                    this.spawnBoss=true;
                }
                enemies.remove();
            }
        }
        if(this.enemy.isEmpty()){
            if(this.spawnBoss){
                this.enemy.add(new BernyBoss(this.width, this.height));
                this.spawnBoss=false;
            }
            else{
                this.addEnemy();
            }
        }
        
        this.repaint();
    }
    
}
