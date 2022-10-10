package org.camunda.run.jasypt;

import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/**
 * Hello world!
 *
 */
public class Encrypt 
{
    public static void main( String[] args )
    {
        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the text to encrypt");
        String textToEncrypt = in.nextLine();
 
        System.out.println("Enter a password to encrypt the text with");
        String password= in.nextLine();
 
        System.out.println("Re-enter your password to encrypt the text with");
        String password2= in.nextLine();
        if(!password.equals(password2)){
            System.out.println("Password did not match, please start again");
            System.exit(-1);
        }
 
        encrypt(textToEncrypt, password);

        in.close();
    }
    
    
    private static void encrypt(String text, String password) {
        System.out.println( "Encrypting text now ..." );
        StandardPBEStringEncryptor encryptor =new StandardPBEStringEncryptor();
        encryptor.setAlgorithm("PBEWithMD5AndTripleDES");
        encryptor.setPassword(password);
        String encryptedText = encryptor.encrypt(text);
        System.out.println("Result " + encryptedText);
    }
}
