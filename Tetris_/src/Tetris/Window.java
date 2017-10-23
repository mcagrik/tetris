/*
 * Tetris Oyunu için açılacak olan 
 * pence bu sınıfta oluşturuluyor.
 * 05.04.2012 23:22 de başlandı.
 */
package Tetris;


import javax.swing.JFrame;

/**
 *
 * @author Muhammet Çağrı KARAKAYA
 */
public class Window extends JFrame { //JFrameden kalıtım alıyoruz.
                                     //JFrame pencere işlemlerinde kullanacağız.
    private int x=500, y=50, width=400, height=528; //Penceremizin boyutları.
    public Window()  {
        super("Hello Tetris");   //Oyunun başlığına vereceğimiz isim.
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setVisible(true);
        setResizable(false);
        setBounds(x, y, width, height); //Boyutlar burada giriliyor.
        GamePanel gp=new GamePanel();
        add(gp);
        gp.requestFocusInWindow();
    }
    
}
