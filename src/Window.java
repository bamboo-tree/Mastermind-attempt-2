import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Window {
    // window size
    final private int WIDTH = 800;
    final private int HEIGHT = 600;

    // custom colors
    final private Color RED = new Color(0xD00000);
    final private Color GREEN = new Color(0x37FF8B);
    final private Color BLUE = new Color(0x00A6FB);
    final private Color WHITE = new Color(0xFAF9F9);
    final private Color BLACK = new Color(0x131200);

    // window components
    private JFrame frame;
    private JPanel welcomeScreen;
    private JTextField usernameInput;
    private JLabel userInfo;
    private JPanel test;



    // default constructor
    public Window(){
        frame = new JFrame();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); // object used to center game window

        // setting up window parameters
        frame.getContentPane().setBackground(BLUE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(dim.width/2 - WIDTH/2, dim.height/2 - HEIGHT/2);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("Mastermind");
        frame.setIconImage(new ImageIcon("./img/icon.png").getImage());
    }

    public void showWelcomeScreen() throws InterruptedException {

        welcomeScreen = new JPanel();
        welcomeScreen.setLayout(new BorderLayout());


        // mastermind title
        JLabel title = new JLabel();
        title.setPreferredSize(new Dimension(WIDTH, 300));
        title.setText("Mastermind");
        title.setFont(new Font("Century Gothic", Font.BOLD, 52));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setOpaque(true);
        title.setBackground(GREEN);
        title.setForeground(BLACK);
        welcomeScreen.add(title, BorderLayout.NORTH);

        // author info
        JLabel info = new JLabel();
        info.setPreferredSize(new Dimension(WIDTH, 50));
        info.setText("Maciej Kamiński 2023 ©");
        info.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        info.setHorizontalAlignment(JLabel.CENTER);
        info.setOpaque(true);
        info.setBackground(BLACK);
        info.setForeground(WHITE);
        welcomeScreen.add(info, BorderLayout.SOUTH);


        // input section
        JPanel inputSection = new JPanel();
        inputSection.setOpaque(true);
        inputSection.setBackground(WHITE);
        inputSection.setLayout(new GridLayout(3,1));

        // text label
        JLabel text = new JLabel();
        text.setText("◄ Enter username ►");
        text.setFont(new Font("Century Gothic", Font.BOLD, 32));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setOpaque(true);
        text.setBackground(WHITE);
        text.setForeground(BLACK);
        inputSection.add(text);

        // text field for username
        usernameInput = new JTextField();
        usernameInput.setToolTipText("username should be created from letters and/or numbers A-Z, a-z, 0-9 with no spaces");
        usernameInput.setFont(new Font("Century Gothic", Font.BOLD, 24));
        usernameInput.setHorizontalAlignment(SwingConstants.CENTER);
        usernameInput.setBackground(WHITE);
        usernameInput.setForeground(BLACK);
        usernameInput.setBorder(null);
        // adding custom key listener
        usernameInput.addKeyListener(new MyKeyListener());
        inputSection.add(usernameInput);

        // information to user about their username
        userInfo = new JLabel();
        userInfo.setText("remember to make it pretty :D");
        userInfo.setFont(new Font("Century Gothic", Font.BOLD, 14));
        userInfo.setHorizontalAlignment(JLabel.CENTER);
        userInfo.setOpaque(true);
        userInfo.setBackground(WHITE);
        userInfo.setForeground(BLACK);
        inputSection.add(userInfo);


        welcomeScreen.add(inputSection, BorderLayout.CENTER);
        frame.add(welcomeScreen, BorderLayout.CENTER);
        frame.setVisible(true);

        // setting default cursor position in the text field
        usernameInput.requestFocusInWindow();
    }

    public void killWelcomeScreen(){
        frame.getContentPane().remove(welcomeScreen);
        frame.invalidate();
        frame.validate();
        frame.setVisible(true);
    }

    public void testPanel(){
        test = new JPanel();
        test.setOpaque(true);
        test.setBackground(BLUE);
        frame.add(test, BorderLayout.CENTER);
        frame.setVisible(true);

    }

    public void setUserInfo(String text, Color color){
        userInfo.setText(text);
        userInfo.setForeground(color);
    }

    public Color getRED(){
        return  RED;
    }

    public Color getGREEN() {
        return GREEN;
    }

    public void killWindow(){
        frame = null;
    }

    public JTextField getUsernameInput(){
        return usernameInput;
    }

    public String getTextFieldInput(){
        return usernameInput.getText();
    }

}
