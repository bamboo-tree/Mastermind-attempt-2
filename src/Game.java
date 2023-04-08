import java.util.concurrent.TimeUnit;

public class Game {

    String name = "empty";
    static boolean enterHit = false;
    boolean gameRunning = true;
    boolean welcomeScreenSection = true;


    Window window = new Window();



    public void start() throws InterruptedException {

        window.showWelcomeScreen();

        while (gameRunning){
            TimeUnit.MILLISECONDS.sleep(100);

            if(enterHit){
                System.out.println(window.getTextFieldInput());
                if(User.checkSpelling(window.getTextFieldInput())){
                    System.out.println("Correct username.");
                    window.setUserInfo("Correct username.", window.getGREEN());
                    TimeUnit.MILLISECONDS.sleep(1000);
                }
                window.killWelcomeScreen();
                enterHit = false;
                gameRunning = false;
            }

        }

        System.out.println("went through");
        window.testPanel();

    }

}
