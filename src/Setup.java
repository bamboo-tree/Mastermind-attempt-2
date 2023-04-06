import java.util.Arrays;
import java.util.Random;

public class Setup {

    private int boardWidth = 4;
    private int boardHeight = 10;
    private boolean canRepeat = false;
    private int[] colors;
    private int allColors = 8;
    private int[] guessColors;

    public Setup(){
        System.out.println("Default setting.");
    }

    public Setup(int boardWidth, int boardHeight, boolean canRepeat, int allColors){
        System.out.println("Custom setting :\nwidth - " + boardWidth + "\nheight - " + boardHeight + "\nall - " + allColors + "\nrepeat - " + canRepeat);
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.canRepeat = canRepeat;
        this.allColors = allColors;
    }



    private void printArray(int[] array){
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //creates a new color pallet
    private void initPallet(){
        colors = new int[allColors];
        for(int i = 0; i < allColors; i++){
            colors[i] = i;
        }
    }

    public void generateColors(){ //generates random colors to be guessed
        initPallet();
        int[] tempArray = colors;
        Random random = new Random();

        for(int i = 0; i < 3*tempArray.length; i++){
            int randomIndex = random.nextInt(tempArray.length);
            int tempValue = tempArray[randomIndex];
            tempArray[randomIndex] = tempArray[i % tempArray.length];
            tempArray[i % tempArray.length] = tempValue;
        }

        guessColors = Arrays.copyOfRange(tempArray, 0, boardWidth);
        printArray(guessColors);
    }

}
