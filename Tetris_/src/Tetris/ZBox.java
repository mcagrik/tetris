
package Tetris;

public class ZBox extends ShapesSet{

    public ZBox() {
        b1=new Box();
        b1.shapColor=6;
        b2=new Box(7*20,-40);
        b2.shapColor=6;
        b3=new Box(6*20,-60);
        b3.shapColor=6;
        b4=new Box(8*20,-40);
        b4.shapColor =6;
        BoxListAdd();
    }

    @Override
    public void Rotate1() {
        if (b1.getY()>=0&&Control.X[b3.getX()/20][b3.getY()/20+1]==Control.empty&&
                Control.X[b3.getX()/20][b3.getY()/20+2]==Control.empty) {
            int x=b2.getX();
            int y=b2.getY();
            b1.setBounds(x, y-20, 20, 20);
            b2.setBounds(x-20, y+20, 20, 20);
            b3.setBounds(x-20, y, 20, 20);
            b4.setBounds(x, y, 20, 20);
            rotate++;
        }
        
    }

    @Override
    public void Rotate2() {
        if (b4.getX()<280&&Control.X[b4.getX()/20+1][b4.getY()/20]==Control.empty&&
                Control.X[b1.getX()/20-1][b1.getY()/20]==Control.empty) {
            int x=b4.getX();
            int y=b4.getY();
            b1.setBounds(x, y-20, 20, 20);
            b2.setBounds(x, y, 20, 20);
            b3.setBounds(x-20, y-20, 20, 20);
            b4.setBounds(x+20, y, 20, 20);
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

    @Override
    public void swit(int ran) {
    }
    
}
