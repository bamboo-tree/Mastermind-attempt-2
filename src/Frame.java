import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Frame{

    JFrame frame;
    final Color green = new Color(0x37FF8B);
    final Color blue = new Color(0x00A6FB);
    final Color white = new Color(0xFAF9F9);
    final Color black = new Color(0x131200);
    final int width = 800;
    final int height = 600;

    public Frame(){
        frame = new JFrame();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setVisible(true);
        frame.setLocation(dim.width/2 - this.width/2, dim.height/2 - this.height/2);
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon("./img/icon.png").getImage());
        frame.setTitle("Mastermind");
    }

    private boolean checkUserName(String input){
        char[] arr = input.toCharArray();
        for(char i : arr){
            if((i < 65 || i > 90) && ( i < 97 || i > 122)){
                return false;
            }
        }
        return true;
    }

    public boolean welcomeScreen(){
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        container.setBackground(white);

        // mastermind title
        JLabel title = new JLabel();
        title.setPreferredSize(new Dimension(width, 200));
        title.setText("Mastermind");
        title.setFont(new Font("Century Gothic", Font.BOLD, 46));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setOpaque(true);
        title.setBackground(green);
        title.setForeground(black);
        container.add(title, BorderLayout.NORTH);

        // author info
        JLabel info = new JLabel();
        info.setPreferredSize(new Dimension(width, 50));
        info.setText("Maciej Kamiński 2023 ©");
        info.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        info.setVerticalAlignment(SwingConstants.CENTER);
        info.setHorizontalAlignment(SwingConstants.CENTER);
        info.setOpaque(true);
        info.setBackground(black);
        info.setForeground(white);
        container.add(info, BorderLayout.SOUTH);


        // username input
        JPanel inputSection = new JPanel();
        inputSection.setLayout(new GridLayout(3,1));

        // text label
        JLabel text = new JLabel();
        text.setText("Enter username");
        text.setFont(new Font("Century Gothic", Font.BOLD, 28));
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setOpaque(true);
        text.setBackground(white);
        text.setForeground(black);
        inputSection.add(text);

        // text field for username
        JTextField username = new JTextField();
        username.setFont(new Font("Century Gothic", Font.BOLD, 24));
        username.setHorizontalAlignment(SwingConstants.CENTER);
        username.setBackground(white);
        username.setForeground(black);
        username.setToolTipText("username should be created from letters A-Z, a-z with no spaces");
        username.setBorder(null);

        // accept button
        JButton button = new JButton();
        button.setBackground(blue);
        button.setForeground(black);
        button.setFont(new Font("Century Gothic", Font.BOLD, 18));
        button.setText("ACCEPT");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkUserName(username.getText())){
                    text.setForeground(Color.GREEN);
                    if(User.userExist(username.getText())){
                        System.out.println("User was previously created, welcome back!");
                        text.setText("User " + username.getText() + " already exists, welcome back!");
                    }
                    else{
                        try {
                            User user = new User(username.getText());
                            user.createUser();
                            System.out.println("User " + username.getText() + " has been created.");
                            text.setText("User " + username.getText() + " has been created.");
                            user.fillUser();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                else{
                    System.out.println("Username is incorrect, try something else.");
                    text.setText("Username is incorrect, try something else.");
                    text.setForeground(Color.RED);
                }
            }
        });

        // adding created components
        inputSection.add(username);
        inputSection.add(button);
        container.add(inputSection, BorderLayout.CENTER);
        frame.add(container, BorderLayout.CENTER);
        frame.setVisible(true);

        // setting default cursor position in text field
        username.requestFocusInWindow();
        return false;
    }

}
