import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {


    /*
    enter - 10


     */

    private void displayInfo(KeyEvent e){
        System.out.println(e.getKeyChar() + " - " + e.getKeyCode());
    }


    @Override
    public void keyTyped(KeyEvent e) {
//        System.out.print("Key typed : ");
//        displayInfo(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 10){
            System.out.println("enter");
            Game.enterHit = true;
        }
//        System.out.print("Key pressed : ");
//        displayInfo(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        System.out.print("Key released  : ");
//        displayInfo(e);
    }
}
