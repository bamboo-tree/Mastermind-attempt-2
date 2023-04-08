public class User{


    public static boolean checkSpelling(String name){
        char[] array = name.toCharArray();
        for(char c : array){
            if((c < 48 || c > 57) && (c < 65 || c > 90) && (c < 97 || c > 122)){
                return false;
            }
        }
        return true;
    }

}