
package Tetris;


public class IBox extends ShapesSet{

    public IBox() {
        b1=new Box(); 
        b1.shapColor=1;
        b2=new Box(7*20,0);
        b2.shapColor=1;
        b3=new Box(7*20,-40);
        b3.shapColor=1;
        b4=new Box(7*20,-20);
        b4.shapColor=1;
        BoxListAdd();
    }

    @Override
    public void Rotate1() {
        if(b1.getX()>20&&b1.getX()<261&&Control.X[b4.getX()/20-1][b4.getY()/20]==Control.empty
                &&Control.X[b4.getX()/20-2][b4.getY()/20]==Control.empty
                &&Control.X[b4.getX()/20+1][b4.getY()/20]==Control.empty
                &&Control.X[b4.getX()/20+2][b4.getY()/20]==Control.empty){
            int x=b4.getX();
            int y=b4.getY();
            b1.setBounds(x-20, y, 20, 20);
            b2.setBounds(x, y, 20, 20);
            b3.setBounds(x-40, y, 20, 20);
            b4.setBounds(x+20, y, 20, 20);
            rotate++;
        }
    }

    @Override
    public void Rotate2() {
        if (Control.X[b1.getX()/20][b1.getY()/20+1]==Control.empty) {
            int x=b2.getX();
            int y=b2.getY();
            b1.setBounds(x, y-40, 20, 20);
            b2.setBounds(x, y+20, 20, 20);
            b3.setBounds(x, y-20, 20, 20);
            b4.setBounds(x, y, 20, 20);
            rotate++;
        }
    }

    @Override
    public void Rotate3() {
        if(b1.getX()>20&&b1.getX()<261){
            Rotate1();
        }
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
