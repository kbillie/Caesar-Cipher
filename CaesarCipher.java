/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caesarcipher;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kailabillie
 */
public class CaesarCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String encodedString = Encode("-1:some text");
        System.out.println(encodedString);

    }

    static String Encode(String word) {

        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "1234567890";
        
        String [] words = word.split(":");
        
        
        
        int letterShift = Integer.parseInt(words[0]);
        String encodeWord = words[1];
        
        System.out.println(encodeWord);
        
        String newWord = "";
        
        for (int i = 0; i<encodeWord.length(); i++) {
            if (String.valueOf(encodeWord.charAt(i)).equals(" ")) {
                    newWord += " ";
                }
            if (uppercase.contains(String.valueOf(encodeWord.charAt(i)))) { 
                int index = uppercase.indexOf(encodeWord.charAt(i));
                int newIndex = (letterShift + index) % 26;
                char letter = uppercase.charAt(newIndex);
                newWord += letter;
            }
            else if (lowercase.contains(String.valueOf(encodeWord.charAt(i)))) {
                int index = lowercase.indexOf(encodeWord.charAt(i));
                int newIndex = (letterShift + index) % 26;
                char letter = lowercase.charAt(newIndex);
                newWord += letter;
            }
            else if (digits.contains(String.valueOf(encodeWord.charAt(i)))) {  
                int index = digits.indexOf(encodeWord.charAt(i));
                int newIndex = (letterShift + index) % 10;
                char letter = digits.charAt(newIndex);
                newWord += letter;
            }
        }
        return newWord;
    }

}
