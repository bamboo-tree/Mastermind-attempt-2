import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class User {
    private final String NAME;
    private final static String PATH = ".\\users\\";

    User(String name){
        this.NAME = name;
    }

    public static boolean userExist(String name){
        File temp = new File(PATH + name + ".txt");
        return temp.exists() && !temp.isDirectory();
    }

    public void createUser() throws IOException {
        try{
            File user = new File(PATH + this.NAME + ".txt");
            user.createNewFile();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void fillUser() throws IOException {
        FileWriter writer = new FileWriter(PATH + this.NAME + ".txt");
        writer.write("bsc0");    // best score
        writer.write("bst0");    // best time
        writer.write("gmp0");    // games played
        writer.close();
    }


}
