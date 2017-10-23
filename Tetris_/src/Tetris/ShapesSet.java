
package Tetris;

import java.util.ArrayList;

public abstract class ShapesSet {
    ArrayList<Box> BoxList=new ArrayList<>();
    Box b1,b2,b3,b4; //her şeklimiz 4 kutudan oluşur bizde 4 tane kutu tanımladık.
    int rotate=0;
    public ShapesSet() {

    }
    public void BoxListAdd(){
        BoxList.add(b1);
        BoxList.add(b2);
        BoxList.add(b3);
        BoxList.add(b4);
    }
    public abstract void swit(int ran);
    public abstract void Rotate1();
    public abstract void Rotate2();
    public abstract void Rotate3();
    public abstract void Rotate4();
    public void down(){
        for (int i = 0; i < 4; i++) {
            BoxList.get(i).downMove();
        }
    }
    public void left(){
        if (b1.getY()>=0) {
            for (int i = 0; i < 4; i++) {
                BoxList.get(i).leftMove();
            }
        }
        
    }
    public void right(){
        if (b1.getY()>=0) {
            for (int i = 0; i < 4; i++) {
                BoxList.get(i).rightMove();
            }
        }
        
    }
    
}
