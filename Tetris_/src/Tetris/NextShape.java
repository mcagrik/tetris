/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tetris;


public class NextShape extends ShapesSet{

    public NextShape() {
        b1=new Box();           //kutuları tanımlıyoruz. Konumlarına göre...
        b2=new Box(7*20,20);
        b3=new Box(6*20,20);
        b4=new Box(8*20,20);
        BoxListAdd();
    }
    @Override
    public void swit(int ran){
        switch(ran){
                        case 0:b1.shapColor=0;
                               b1.setBounds(338, 50, 20, 20);
                               b2.shapColor=0;
                               b2.setBounds(358, 50, 20, 20);
                               b3.shapColor=0;
                               b3.setBounds(318, 70, 20, 20);
                               b4.shapColor=0;
                               b4.setBounds(338, 70, 20, 20);
                            break;
                        case 1:b1.shapColor=1;
                               b1.setBounds(338, 30, 20, 20);
                               b2.shapColor=1;
                               b2.setBounds(338, 50, 20, 20);
                               b3.shapColor=1;
                               b3.setBounds(338, 70, 20, 20);
                               b4.shapColor=1;
                               b4.setBounds(338, 90, 20, 20);
                            break;
                        case 2:b1.shapColor=2;
                               b1.setBounds(348, 40, 20, 20);
                               b2.shapColor=2;
                               b2.setBounds(348, 60, 20, 20);
                               b3.shapColor=2;
                               b3.setBounds(348, 80, 20, 20);
                               b4.shapColor=2;
                               b4.setBounds(328, 80, 20, 20);
                            break;
                        case 3:b1.shapColor=3;
                               b1.setBounds(328, 40, 20, 20);
                               b2.shapColor=3;
                               b2.setBounds(328, 60, 20, 20);
                               b3.shapColor=3;
                               b3.setBounds(328, 80, 20, 20);
                               b4.shapColor=3;
                               b4.setBounds(348, 80, 20, 20);
                            break;
                        case 4:b1.shapColor=4;
                               b1.setBounds(328, 50, 20, 20);
                               b2.shapColor=4;
                               b2.setBounds(328, 70, 20, 20);
                               b3.shapColor=4;
                               b3.setBounds(348, 50, 20, 20);
                               b4.shapColor=4;
                               b4.setBounds(348, 70, 20, 20);
                            break;
                        case 5:b1.shapColor=5;
                               b1.setBounds(338, 50, 20, 20);
                               b2.shapColor=5;
                               b2.setBounds(318, 70, 20, 20);
                               b3.shapColor=5;
                               b3.setBounds(338, 70, 20, 20);
                               b4.shapColor=5;
                               b4.setBounds(358, 70, 20, 20);
                            break;
                        case 6:b1.shapColor=6;
                               b1.setBounds(318, 50, 20, 20);
                               b2.shapColor=6;
                               b2.setBounds(338, 50, 20, 20);
                               b3.shapColor=6;
                               b3.setBounds(338, 70, 20, 20);
                               b4.shapColor=6;
                               b4.setBounds(358, 70, 20, 20);
                            break;
                    }
    
    }

    @Override
    public void Rotate1() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Rotate2() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Rotate3() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Rotate4() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
