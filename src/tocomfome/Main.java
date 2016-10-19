
package tocomfome;


import java.awt.EventQueue;
import tocomfome.gui.UserLoginJFrame;


public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                final UserLoginJFrame userLoginJFrame = new UserLoginJFrame();
                userLoginJFrame.setVisible(true);
            }
        });
    }
}
