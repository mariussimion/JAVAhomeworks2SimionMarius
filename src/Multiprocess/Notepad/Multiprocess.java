
package Multiprocess.Notepad;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Multiprocess {

    
    public static void main(String[] args) {
      try {
          ProcessBuilder pb;
          pb = new ProcessBuilder("Notepad");
          Process p1 = pb.start();
          Process p2 = pb.start();
          Process p3 = pb.start();
           } catch (IOException ex) {
               Logger.getLogger(NotepadMultiprocess.class.getName()).log(Level.SEVERE, "An IO exception is here!", ex);
      }
    }
    
}
