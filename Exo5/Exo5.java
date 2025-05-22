package Exo5;

public class Exo5 {

    public String upsideDown(String word) {
        StringBuilder newWord = new StringBuilder();
        for ( int i = word.length() - 1; i >= 0; i--) {      
            newWord.append(word.charAt(i));

        }
        return newWord.toString();

    }
    
}
