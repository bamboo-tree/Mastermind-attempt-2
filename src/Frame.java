import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Frame {

    JFrame frame;
    Font font = new Font(Font.DIALOG, Font.BOLD, 20);
    Border border = BorderFactory.createLineBorder(Color.BLUE, 10, true);
    final int width = 800;
    final int height = 600;

    public Frame(){
        frame = new JFrame();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        frame.getContentPane().setBackground(new Color(0x02182B));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setVisible(true);
        frame.setLocation(dim.width/2 - this.width/2, dim.height/2 - this.height/2);
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon("./img/icon.png").getImage());
        frame.setTitle("Mastermind");
    }

    public void welcomeScreen(){
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        container.setBackground(new Color(0xF7F7FF));

        // mastermind title
        JLabel title = new JLabel();
        title.setPreferredSize(new Dimension(width, 200));
        title.setText("Mastermind");
        title.setFont(new Font("Century Gothic", Font.BOLD, 46));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setOpaque(true);
        title.setBackground(new Color(0x37FF8B));
        title.setForeground(new Color(0x0F1108));
        container.add(title, BorderLayout.NORTH);

        JLabel info = new JLabel();
        info.setPreferredSize(new Dimension(width, 50));
        info.setText("Maciej Kamiński 2023 ©");
        info.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        info.setVerticalAlignment(SwingConstants.CENTER);
        info.setHorizontalAlignment(SwingConstants.CENTER);
        info.setOpaque(true);
        info.setBackground(new Color(0x0F1108));
        info.setForeground(new Color(0xF7F7FF));
        container.add(info, BorderLayout.SOUTH);


        frame.add(container, BorderLayout.CENTER);
        frame.setVisible(true);
    }

}
