package Funktionalitet;

import java.nio.charset.Charset;
import java.util.*;
public class PasswordGenerator {


    // this method should take the given user as parameter, create a password, and prompt the setPassword under Data
    public static char[] generatePassword(){


        Random rand = new Random();

        final char[] upper = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','X','Y','Z'};
        final char[] lower = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','x','y','z'};
        final char[] digits = {'0','1','2','3','4','5','6','7','8','9'};
        final char[] symbols = {'!','?','$'};

        int length = rand.nextInt(15)+1; // This will create between 2 and 5 of each character (min 6 and max 15)
        char[] password = new char[length];

        for(int i = 0; i<length-2;i++){
            int chooseType = rand.nextInt(2)+1;
            switch (chooseType){
                case 1: password[i] = upper[rand.nextInt(25)];
                    break;
                case 2: password[i] = lower[rand.nextInt(25)];
                    break;
            }
        }
        password[length-2] = symbols[rand.nextInt(2)];
        password[length-1] = digits[rand.nextInt(9)];
        return password;
    }

}