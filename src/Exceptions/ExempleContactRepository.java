
package Exceptions;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
public class ExempleContactRepository {
   static class ContactRepository {
String file;
ContactRepository(String file) { this.file = file; }
void saveContact(String name, String email){
String row = name + "," + email + "\n";
writeRow(row);
}
void writeRow(String row) {
try {
BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
out.write(row);
} catch (IOException e) {
throw new RuntimeException(e);
}
}
}
public static void main(String[] args) {
ContactRepository repo = new ContactRepository("C:\\Users\\Marius\\Desktop\\file.txt");
repo.saveContact("Adrian" , "123");
}
    
}
