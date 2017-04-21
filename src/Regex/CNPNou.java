
package Regex;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.regex.Matcher;        import java.util.regex.Pattern;


public class CNPNou {

    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String CNP ;
        
        String CNPReg = "[1-2]"
                  + "[0-9]{2}" 
                + "("
                + "(0[13578]|1[02])" 
                + "(0[1-9]|[12]\\d|3[01])"
                + "|"
                + "(0[469]|11)" 
                + "(0[1-9]|[12]\\d|30)" 
                + "|"
                + "02"
                 + "(0[1-9]|[12]\\d)" 
                + ")"
                 + "(0[1-9]|[1-3]\\d|4[0-6]|5[12])" 
                + "((00[1-9])|(0[1-9][0-9])|([1-9][0-9][0-9]))" 
                + "[0-9]"; 
        System.out.println("Introdu CNP-ul:"); 
       try { 
            CNP = sc.nextLine(); 
         } catch (InputMismatchException e) { 
             System.out.println("\nInvalid data!"); 
            CNP = ""; 
        } 
 Pattern pattern = Pattern.compile(CNP); 
        Matcher matcher = pattern.matcher((CharSequence) CNPReg); 

 
        System.out.print("\n" + CNP);  
 
         if (matcher.matches()) { 
            System.out.println(" CNP-ul este valid"); 
         } else { 
            System.out.println(" CNP-ul nu este valid"); 

    }
    
}
}
