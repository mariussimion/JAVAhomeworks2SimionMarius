
package Exceptions;

import java.io.*;
import static java.lang.System.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class FileManagement {

    private static String str;
    
    
    public static void WriteInFile(){
      
      try{
          
          FileWriter fw = new FileWriter("C:\\Users\\Marius\\Desktop\\Credits.txt");
          PrintWriter  pw = new PrintWriter(fw);
          
          pw.println("Course: 30 credits");
          pw.println("Year: 120 credits");
          pw.println("Degree: 360 credits");
          
          pw.close();
      }catch (IOException e){
          out.println("ERORR");
      }
      }
    
    public static void ReadInFile(){
        FileReader fr = null;
        try {
            fr = new FileReader("C:\\Users\\Marius\\Desktop\\Credits.txt");
            } catch (FileNotFoundException ex) {
                System.out.println("File does not exist");
}
        BufferedReader br = new BufferedReader (fr);
        String str;
        try {
        while ((str = br.readLine()) != null){
            System.out.println(str + "\n");
        }
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void WriteInEmpyFile(){
        try {
            FileWriter fw = new FileWriter ("C:\\Users\\Marius\\Desktop\\Empy_file.txt");
            PrintWriter pw = new PrintWriter (fw);
          pw.println("Hello!");
          pw.println("Hello!");
          fw.close();
           } catch (IOException ex) {
               Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void DeleteEmpyFile(){
        try {
            FileWriter fw = new FileWriter ("C:\\Users\\Marius\\Desktop\\Empy_file.txt");
            PrintWriter pw = new PrintWriter (fw);
             pw.println("");
             fw.close();
             } catch (IOException ex) {
                 Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
    
    

    