/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tetris;

/**
 *
 * @author Yusuf
 */
public class SBox extends ShapesSet{

    public SBox() {
        b1=new Box();           //kutuları tanımlıyoruz. Konumlarına göre...
        b2=new Box(7*20,-40);
        b3=new Box(6*20,-40);
        b4=new Box(8*20,-60);
        BoxListAdd();
    }

    @Override
    public void swit(int ran) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Rotate1() {
        if (b1.getY()>0&&Control.X[b4.getX()/20][b4.getY()/20+1]==Control.empty
                &&Control.X[b1.getX()/20][b1.getY()/20-1]==Control.empty) {
            int x=b2.getX()+20;
            int y=b2.getY();
            b1.setBounds(x-20, y-40, 20, 20);
            b2.setBounds(x, y, 20, 20);
            b3.setBounds(x-20, y-20, 20, 20);
            b4.setBounds(x, y-20, 20, 20);
            rotate++;
        }
        
    }

    @Override
    public void Rotate2() {
        if (b3.getX()>=20&&Control.X[b3.getX()/20][b3.getY()/20+1]==Control.empty
                &&Control.X[b3.getX()/20-1][b3.getY()/20+1]==Control.empty) {
            int x=b2.getX();
            int y=b2.getY();
            b1.setBounds(x-20, y-20, 20, 20);
            b2.setBounds(x-20, y, 20, 20);
            b3.setBounds(x-40, y, 20, 20);
            b4.setBounds(x, y-20, 20, 20);
            rotate++;
        }
        
    }

    @Override
    public void Rotate3() {
        Rotate1();
    }

    @Override
    public void Rotate4() {
        Rotate2();
        rotate=0;
    }
    
}
