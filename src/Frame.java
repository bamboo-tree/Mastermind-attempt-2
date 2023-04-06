import javax.swing.*;
import java.awt.*;

public class Frame {

    JFrame frame;
    final int width = 800;
    final int height = 600;

    public Frame(){
        frame = new JFrame();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(0x02182B));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setLocation(dim.width/2 - this.width/2, dim.height/2 - this.height/2);
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon("./img/icon.png").getImage());
        frame.setTitle("Mastermind");

    }
}
