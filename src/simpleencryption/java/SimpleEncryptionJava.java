/*
 * Kaia Mac
 * encrypt a plaintext message using the simple encryption algorithm to create 
 * the ciphertext. Allow the user to enter the rotation amount that the 
 * algorithm moves the letters. This amount should be a value from 1 to 25.
 * 25/02/2020
 */

package simpleencryption.java;

import javax.swing.*;

/**
 *
 * @author kamac8665
 */
public class SimpleEncryptionJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String phrase;              //phrase entered by user
        String encryptedPhrase;     //the encrypted phrase
        String rotAmountStr;
        String encOrDecStr;
        int rotationAmount;         //rotation amount
        int pos;                    //loop counter
        int charValue;              //unicode value of character

        phrase = JOptionPane.showInputDialog("This program will encrypt or decrypt a phrase using the\n"
                + "simple encryption method of rotating the letters.\n\n"
                + "Please enter a phrase");

        rotAmountStr = JOptionPane.showInputDialog("Enter the rotation amount (1 - 25)");
        //Convert rotAmountStr to an integer
        rotationAmount = Integer.parseInt(rotAmountStr);

        encOrDecStr = JOptionPane.showInputDialog("1 - Encryption\n2 - Decryption");

        //Convert phrase to uppercase
        phrase = phrase.toUpperCase();

        if (encOrDecStr.equals("1")) {
            //Encryption
            if (rotationAmount >= 1 && rotationAmount <= 25) {
                encryptedPhrase = "";
                for (pos = 0; pos < phrase.length(); pos++) {
                    charValue = (int) phrase.charAt(pos);
                    if (charValue >= 65 && charValue <= 90) {
                        charValue += rotationAmount;
                        if (charValue > 90) {
                            charValue -= 26;
                        }
                    }
                    encryptedPhrase += (char) charValue;
                }
                System.out.println("The original phrase is: " + phrase);
                System.out.println("The encrypted phrase is: " + encryptedPhrase);
            } else {
                //Invalid
                System.out.println("Invalid rotation amount");
            }
        } else if (encOrDecStr.equals("2")) {
            //Decryption
            if (rotationAmount >= 1 && rotationAmount <= 25) {
                encryptedPhrase = "";
                for (pos = 0; pos < phrase.length(); pos++) {
                    charValue = (int) phrase.charAt(pos);
                    if (charValue >= 65 && charValue <= 90) {
                        charValue -= rotationAmount;
                        if (charValue < 65) {
                            charValue += 26;
                        }
                    }
                    encryptedPhrase += (char) charValue;
                }
                System.out.println("The original phrase is: " + phrase);
                System.out.println("The decrypted phrase is: " + encryptedPhrase);
            } else {
                //Invalid
                System.out.println("Invalid rotation amount");
            }
        } else {
            //Invalid selection
            System.out.println("Invalid selection");
        }
    }
}
