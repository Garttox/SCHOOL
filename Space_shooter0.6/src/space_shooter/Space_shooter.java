/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space_shooter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author Garttox
 */
public class Space_shooter implements ActionListener{
    private JFrame window;
    private JLabel label;
    private Canvas canvas;
    private Container pane;
    private Timer timer;
    private int width;
    private int height;
    private int gameScore;
    
    public Space_shooter(int width, int height){
        this.width=width;
        this.height=height;
        window= new JFrame("Space shooter");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(width, height);
        window.setResizable(false);
        
        label = new JLabel("HP:");
        
        canvas = new Canvas(height-44,width,this.label,this);
        canvas.init();
        
        int style = Font.BOLD | Font.ITALIC;
        Font font = new Font("Arial", style , 20);
        label.setFont(font);
        // Nastavení barvy pozadí a písma
        label.setBackground(Color.BLACK);
        label.setOpaque(true);
        label.setForeground(Color.white);
        // Nastavení zarovnání a odsazení
        label.setBorder(new EmptyBorder(10, 0, 10, 0));
        label.setHorizontalAlignment(JLabel.LEFT); 
        pane = window.getContentPane();
        pane.add(label,BorderLayout.PAGE_END);
        pane.add(canvas, BorderLayout.CENTER);
        
        window.setVisible(true);
    }
    
    public void reset(int width, int height){
        window.dispose();
        window= new JFrame("Space shooter");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(width, height);
        window.setResizable(false);
        
        label = new JLabel("HP:");
        
        canvas = new Canvas(height-44,width,this.label,this);
        canvas.init();
        
        int style = Font.BOLD | Font.ITALIC;
        Font font = new Font("Arial", style , 20);
        label.setFont(font);
        // Nastavení barvy pozadí a písma
        label.setBackground(Color.BLACK);
        label.setOpaque(true);
        label.setForeground(Color.white);
        // Nastavení zarovnání a odsazení
        label.setBorder(new EmptyBorder(10, 0, 10, 0));
        label.setHorizontalAlignment(JLabel.LEFT); 
        pane = window.getContentPane();
        pane.add(label,BorderLayout.PAGE_END);
        pane.add(canvas, BorderLayout.CENTER);
        
        window.setVisible(true);
    }
    
    public void gameOver(int scoreCount){
        
    
        JLabel gameOverText = new JLabel("YOU DIED");
        JLabel score = new JLabel("Score: "+scoreCount);
        ImageContainer image=new ImageContainer("youDied.jpg",this.width,this.height);

        
        int style = Font.BOLD | Font.ITALIC;
        Font font = new Font("Arial", style , 50);
        gameOverText.setFont(font);
        gameOverText.setBackground(Color.BLACK);
        gameOverText.setOpaque(true);
        gameOverText.setForeground(Color.RED);
        gameOverText.setHorizontalAlignment(JLabel.CENTER);
        
        Font font2 = new Font("Arial", Font.BOLD , 40);
        score.setBackground(Color.BLACK);
        score.setOpaque(true);
        score.setForeground(Color.white);
        score.setFont(font2);
        score.setHorizontalAlignment(JLabel.CENTER);
        
        
        JButton buttonForPicture = new JButton();
        buttonForPicture.setBorder(new EmptyBorder(0, 0, 0, 0));
        buttonForPicture.setOpaque(false);
        buttonForPicture.setIcon(new ImageIcon("pictures/sniper.png"));
        
        
        pane.removeAll();
        //sspane.add(gameOverText, BorderLayout.PAGE_START);
        pane.add(image, BorderLayout.CENTER);
        pane.add(score, BorderLayout.PAGE_END);
        pane.repaint();
        window.setVisible(true);
        timer = new Timer(5000, this);
        timer.start();
        
    }
    
    public static void main(String[] args) {
        new Space_shooter(1500,800);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.timer.stop();
        this.reset(1500,800);
    }
    
}
