/*
 * Şekillerimizi oluşturacağımız kutular burdan oluşacak.
 * kutularımız 20*20 lik olacaklar.
 * 06.04.2012 00:09 da başlandı.
 */
package Tetris;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Muhammet Çağrı KARAKAYA
 */
public class Box extends JPanel{ //kutularımızı panellerden oluşturacağımız 
                                 //için JPanelden kalıtım aldık.
    private int x=7*20, y=-60, width=20;
    
    int shapColor=0;
    
    public Box() {
        setBounds(x, y, width, width); //kutumuzun boyutlarını ayar.
    }
    public Box(int x, int y){
        setBounds(x, y, width, width);
    }

    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        switch(shapColor){
            case 0:g.setColor(Color.BLUE); 
                break;
            case 1:g.setColor(Color.RED); 
                break;
            case 2:g.setColor(Color.MAGENTA); 
                break;
            case 3:g.setColor(Color.YELLOW); 
                break;
            case 4:g.setColor(Color.CYAN); 
                break;
            case 5:g.setColor(Color.LIGHT_GRAY); 
                break;
            case 6:g.setColor(Color.GREEN); 
                break;
        }
        
        g.fillRect(0, 0, width-1, width-1);//kutumuzun içini boyar
        g.setColor(Color.WHITE);
        g.drawRect(1, 1, width-4, width-4); //kutumuzun içinde bir dörgen çizer.
    }
    public void downMove(){
        setBounds(getX(), getY()+width, width, width);
    }
    public void leftMove(){
        setBounds(getX()-width, getY(), width, width);
    }
    public void rightMove(){
        setBounds(getX()+width, getY(), width, width);
    }    
    
                                 
    
}
