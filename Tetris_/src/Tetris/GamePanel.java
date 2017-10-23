/*
 * Oyunun oynanacağı alan için panel oluşturacağız.
 * Oyun alanımız 15*25 şeklinde yapacağız.
 * Her bir birim 20*20 lik alan olacak.
 * 05.04.2012 23:42 de başlandı.
 */
package Tetris;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Muhammet Çağrı KARAKAYA
 */
public final class GamePanel extends JPanel{          
    //<editor-fold defaultstate="collapsed" desc="variables">
    Label difLb=new Label();
    Label ScorLb=new Label();
    Label GameOver=new Label();
    Label pausedResume=new Label();
    Label hint=new Label("Sağ ok : Sağ");
    Label hint2=new Label("Sol ok : Sol");
    Label hint3=new Label("Alt ok : Aşağı");
    Label hint4=new Label("Shift : Aşağı direk indir");
    Label hint5=new Label("a : Zorluk arttır");
    Label hint6=new Label("s :Zorluk azalt");
    
    Button bt=new Button();
    private int x=0,y=0, width=15*20, height=25*20;
    
    int ran;
    int Scor=0;
    int time=500;
    int diff=1;
    ShapesSet S;
    ShapesSet S1;
    ShapesSet S2;
    int shapColor=0;
    TBox T=new TBox();
    OBox O=new OBox();
    ZBox Z=new ZBox();
    IBox I=new IBox();
    SBox Sb=new SBox();
    LBox L=new LBox();
    JBox J= new JBox();
    NextShape Ns=new NextShape();
    javax.swing.Timer timeSet = new javax.swing.Timer(time,new TimeMove());
    //</editor-fold>
    public GamePanel(){
        GameOver.setBounds(70, 230, 160,40);
        GameOver.setText("GameOver");
        GameOver.setFont(new Font("Calibri", Font.BOLD, 30));
        GameOver.setEnabled(false);
        GameOver.setBackground(Color.decode("#000000"));
        GameOver.setForeground(Color.LIGHT_GRAY);
        GameOver.setVisible(false);
        hint.setBounds(70, 280, 130, 20);
        hint2.setBounds(70, 300, 130, 20);
        hint3.setBounds(70, 320, 130, 20);
        hint4.setBounds(70, 340, 130, 20);
        hint5.setBounds(70, 360, 130, 20);
        hint6.setBounds(70, 380, 130, 20);
        hint.setForeground(Color.LIGHT_GRAY);
        hint2.setForeground(Color.LIGHT_GRAY);
        hint3.setForeground(Color.LIGHT_GRAY);
        hint4.setForeground(Color.LIGHT_GRAY);
        hint5.setForeground(Color.LIGHT_GRAY);
        hint6.setForeground(Color.LIGHT_GRAY);
        hint.setFont(new Font("Calibri", Font.ITALIC, 12));
        hint2.setFont(new Font("Calibri", Font.ITALIC, 12));
        hint3.setFont(new Font("Calibri", Font.ITALIC, 12));
        hint4.setFont(new Font("Calibri", Font.ITALIC, 12));
        hint5.setFont(new Font("Calibri", Font.ITALIC, 12));
        hint6.setFont(new Font("Calibri", Font.ITALIC, 12));
        hint.setBackground(Color.decode("#000000"));
        hint2.setBackground(Color.decode("#000000"));
        hint3.setBackground(Color.decode("#000000"));
        hint4.setBackground(Color.decode("#000000"));
        hint5.setBackground(Color.decode("#000000"));
        hint6.setBackground(Color.decode("#000000"));
        hint.setEnabled(false);
        hint2.setEnabled(false);
        hint3.setEnabled(false);
        hint4.setEnabled(false);
        hint5.setEnabled(false);
        hint6.setEnabled(false);
        
        
        add(hint);
        add(hint2);
        add(hint3);
        add(hint4);
        add(hint5);
        add(hint6);
        
        
        pausedResume.setFont(new Font("Calibri", Font.BOLD, 30));
        pausedResume.setEnabled(false);
        pausedResume.setText("Press Start");
        pausedResume.setBackground(Color.decode("#000000"));
        pausedResume.setForeground(Color.LIGHT_GRAY);
        pausedResume.setVisible(true);
        pausedResume.setBounds(70, 230, 170, 40);
        add(pausedResume);
        bt.setBounds(305, 220, 85, 30);
        bt.setLabel("START");
        bt.setBackground(Color.red);
        bt.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                switch (bt.getLabel()) {
                    case "START":
                        hint.setVisible(false);
                        hint2.setVisible(false);
                        hint3.setVisible(false);
                        hint4.setVisible(false);
                        hint5.setVisible(false);
                        hint6.setVisible(false);
                        diff=1;
                        Scor=0;
                        ScorLb.setText("Puan :"+Scor);
                        difLb.setText("Zorluk :"+diff);
                        pausedResume.setVisible(false);
                        pausedResume.setText("PAUSED");
                        GameOver.setVisible(false);
                        for (int i = 0; i < 15; i++) {
                            for (int j = 0; j < 25; j++) {
                                Control.X[i][j]=Control.empty;
                            }
                        }
                        repaint();
                        firstGame();
                        bt.setLabel("PAUSE");
                        timeSet.setDelay(time);
                        timeSet.start();
                        requestFocusInWindow();
                        break;
                    case "RESUME":
                        bt.setLabel("PAUSE");
                        timeSet.start();
                        pausedResume.setVisible(false);
                        requestFocusInWindow();
                        break;
                    case "PAUSE":
                        pausedResume.setVisible(true);
                        bt.setLabel("RESUME");
                        timeSet.stop();
                        break;
                }
                    
                }
            });
        
        setFocusable(true);
        add(bt);
        add(GameOver);
        ScorLb.setText("Puan :"+Scor);
        difLb.setText("Zorluk :"+diff);
        ScorLb.setForeground(Color.white);
        difLb.setForeground(Color.white);
        ScorLb.setBounds(305, 160, 85 , 30);
        ScorLb.setBackground(Color.darkGray);
        difLb.setBounds(305, 180, 85 , 30);
        difLb.setBackground(Color.darkGray);
        add(difLb);
        add(ScorLb);
        addKeyListener(new KeyboardController());
        setBounds(x, y, width+100, height);         //panelimizn boyutunu ayarladık.
        setLayout(null);
        
        
    }
    public void firstGame(){
        Random R=new Random();
            ran=R.nextInt(7);
            switch(ran){
                case 0:S1=Sb;
                    break;
                case 1:S1=I;
                    break;
                case 2:S1=J;
                    break;
                case 3:S1=L;
                    break;
                case 4:S1=O;
                    break;
                case 5:S1=T;
                    break;
                case 6:S1=Z;
                    break;
            }
            newshapes();
            randomer();
            for (int i = 0; i < 4; i++) {           
                add(S.BoxList.get(i));
            }
            for (int i = 0; i < 15; i++) {
                Control.X[i][25]=1;
            }
    }
    public void newshapes(){
        T=new TBox();
        O=new OBox();
        Z=new ZBox();
        I=new IBox();
        Sb=new SBox();
        L=new LBox();
        J=new JBox();
        Ns=new NextShape();
        
    }
    public void randomer(){
        S=S1;
        S2=Ns;
        Random R=new Random();
        shapColor=ran;
        ran=R.nextInt(7);
        switch(ran){
            case 0:S1=Sb;
                break;
            case 1:S1=I;
                break;
            case 2:S1=J;
                break;
            case 3:S1=L;
                break;
            case 4:S1=O;
                break;
            case 5:S1=T;
                break;
            case 6: S1=Z;
                break;
        }
        S2.swit(ran);
        for (int i = 0; i < 4; i++) {
            add(S2.BoxList.get(i));
        }
    }

    @Override
    protected void paintComponent(Graphics g) { //panelimizn bulunduğu alanı çiziyoruz.
        super.paintComponent(g);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 25; j++) {
                if (Control.X[i][j]!=Control.empty) {
                    switch(Control.X[i][j]){
                        case Control.Sbox:g.setColor(Color.BLUE);
                            break;
                        case Control.Ibox:g.setColor(Color.RED);
                            break;
                        case Control.Jbox:g.setColor(Color.MAGENTA);
                            break;
                        case Control.Lbox:g.setColor(Color.YELLOW);
                            break;
                        case Control.Obox:g.setColor(Color.CYAN);
                            break;
                        case Control.Tbox:g.setColor(Color.LIGHT_GRAY);
                            break;
                        case Control.Zbox:g.setColor(Color.GREEN);
                            break;
                    }
                    g.fillRect(i*20, j*20, 20-1, 20-1);
                    g.setColor(Color.WHITE);
                    g.drawRect(i*20+1,j*20+1, 20-4, 20-4);
                }
                if (Control.X[i][j]==Control.empty) {
                    g.setColor(Color.BLACK);
                    g.fillRect(i*20, j*20, 20, 20);
                }
            }
        }
        
        g.setColor(Color.darkGray);
        g.fillRect(301, 0, width, height);
        g.setColor(Color.BLACK);
        g.fillRect(308, 10, 80, 120);
        
    }

    class TimeMove implements ActionListener{

        
        @Override
        public void actionPerformed(ActionEvent e) {
            paintControl();
            downMoveController();
            
        }
        
    }
    
    class KeyboardController implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode())
            {
        	case KeyEvent.VK_LEFT  : leftMoveController();
        	                         break;
        	case KeyEvent.VK_RIGHT : rightMoveController();
        	                         break;
        	case KeyEvent.VK_DOWN  : downMoveController();
                                         paintControl();
        	                         break;
                case KeyEvent.VK_UP  : switch(S.rotate){
                                        case 0: S.Rotate1();
                                            break;
                                        case 1: S.Rotate2();
                                            break;
                                        case 2: S.Rotate3();
                                            break;
                                        case 3: S.Rotate4();
                                            break;
                                        }
        	                         break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode()==KeyEvent.VK_SHIFT) {
                boolean a=true;
                while(a){
                        downMoveController();
                        a=paintControl();
                }
            }
            if (e.getKeyCode()==KeyEvent.VK_A) {
                if (diff<10) {
                    diff++;
                    timeSet.setDelay(time-50*(diff-1));
                    difLb.setText("Zorluk :"+diff);
                }
                
            }
            if (e.getKeyCode()==KeyEvent.VK_S){
                if (diff>1) {
                    diff--;
                    timeSet.setDelay(time-50*(diff-1));
                    difLb.setText("Zorluk :"+diff);
                }
                
            }
        }
    
    }
    
    public void downMoveController(){
        int count=0;
        for (int i = 0; i < 4; i++) {
            if (S.BoxList.get(i).getY()<0) {
                count++;
            }
            else if (Control.X[S.BoxList.get(i).getX()/20][S.BoxList.get(i).getY()/20+1]==Control.empty) {
                count++;
            }
        }
        if (count==4) {
            S.down();
        }
    }
    
    public void rightMoveController(){
        int count=0;
        for (int i = 0; i < 4; i++) {
            if (S.BoxList.get(i).getY()<0) {
                count++;
            }
            else if (Control.X[S.BoxList.get(i).getX()/20+1][S.BoxList.get(i).getY()/20]==Control.empty&&S.BoxList.get(i).getX()<20*14) {
            count++;
            }
        }
        if (count==4) {
            S.right();
        }
        
    }
    
    public void leftMoveController(){
        int count=0;
        for (int i = 0; i < 4; i++) {
            if (S.BoxList.get(2).getX()>0) {
                if (S.BoxList.get(i).getY()<0) {
                    count++;
                }
                else if (Control.X[S.BoxList.get(i).getX()/20-1][S.BoxList.get(i).getY()/20]==Control.empty&&S.BoxList.get(i).getX()>0) {
                    count++;
                }
            }
        }
        if (count==4) {
            S.left();
        }
        
    }   

    public void lineDefeat(){                              //satırın yok edilip edilmemesi gerektiği burda kontrol ediliyor.
        int count=0;
        int _count=0;
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 15; j++) {
                if (Control.X[j][i]!=Control.empty) {
                    count++;
                }
                if (count==15) {
                    defeat(i);
                    _count++;
                }
            }
            count=0;
        }
        if (_count>0) {
            int temp=Scor;
            Scor+=diff*100*Math.pow(2, _count-1);
            ScorLb.setText("Puan :"+Scor);
            if (10>diff) {
                diff+=Scor/1000-temp/1000;
                if (diff>10) {
                    diff=10;
                }
                timeSet.setDelay(time-50*(diff-1));
                difLb.setText("Zorluk :"+diff);
            }
            
            
        }
        
        
    }
    
    public void defeat(int i){                              //Yok edilecek olan satır burada siliniyor.
        for (int j = 0; j < 15; j++) {
            for (int k = i; k > 0; k--) {
                Control.X[j][k]=Control.X[j][k-1];
            }
        }
        
        repaint();
    }
    
    public void isOver(){                                   //Oyunun bitip bitmediğini bu fonksiyondan kontrol ediyoruz.
       if(Control.X[6][0]!=Control.empty||Control.X[7][0]!=Control.empty||    //Oyun bitmesi gerekiyorsa oyunu bitiriyoruz.
               Control.X[8][0]!=Control.empty){
           timeSet.stop();
           GameOver.setVisible(true);
           bt.setLabel("START");
       }
       else{                                                //Oyun henüz bitmemişse burada yeni şekillerimizi oluşturuyoruz.
           newshapes();
           randomer();
           for (int j = 0; j < 4; j++){
               add(S.BoxList.get(j));
           }
       }
    }
    
    public boolean paintControl(){
        boolean a=true;
        for (int i = 0; i < 4; i++) {
            if (S.BoxList.get(i).getY()<0) {
                    
                }
            else if (Control.X[S.BoxList.get(i).getX()/20][S.BoxList.get(i).getY()/20+1]!=Control.empty||S.BoxList.get(i).getY()/20+1==25) {
                for (int j = 0; j < 4; j++) {
                    if (S.BoxList.get(j).getY()>=0) {
                        switch(shapColor){
                            case 0:Control.X[S.BoxList.get(j).getX()/20][S.BoxList.get(j).getY()/20]=Control.Sbox;
                                break;
                            case 1:Control.X[S.BoxList.get(j).getX()/20][S.BoxList.get(j).getY()/20]=Control.Ibox;
                                break;
                            case 2:Control.X[S.BoxList.get(j).getX()/20][S.BoxList.get(j).getY()/20]=Control.Jbox;
                                break;
                            case 3:Control.X[S.BoxList.get(j).getX()/20][S.BoxList.get(j).getY()/20]=Control.Lbox;
                                break;
                            case 4:Control.X[S.BoxList.get(j).getX()/20][S.BoxList.get(j).getY()/20]=Control.Obox;
                                break;
                            case 5:Control.X[S.BoxList.get(j).getX()/20][S.BoxList.get(j).getY()/20]=Control.Tbox;
                                break;
                            case 6:Control.X[S.BoxList.get(j).getX()/20][S.BoxList.get(j).getY()/20]=Control.Zbox;
                                break;
                        }
                    }
                    
                }
                repaint();
                for (int j = 0; j < 4; j++) {
                    remove(S2.BoxList.get(j));
                }
                for (int j = 0; j < 4; j++) {
                    remove(S.BoxList.get(j));
                }
                a=false;
                
                lineDefeat();
                isOver();
            }
        }
        return a;
    }
}
