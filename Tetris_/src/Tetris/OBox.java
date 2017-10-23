/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tetris;

/**
 *
 * @author Yusuf
 */
public class OBox extends ShapesSet{

    public OBox() {
        b1=new Box();
        b1.shapColor=4;
        b2=new Box(8*20,-40);
        b2.shapColor=4;
        b3=new Box(7*20,-40);
        b3.shapColor=4;
        b4=new Box(8*20,-60);
        b4.shapColor=4;
        BoxListAdd();
    }
    
    @Override
    public void Rotate1() {
    }

    @Override
    public void Rotate2() {
    }

    @Override
    public void Rotate3() {
    }

    @Override
    public void Rotate4() {
    }

    @Override
    public void swit(int ran) {
    }
    
}
