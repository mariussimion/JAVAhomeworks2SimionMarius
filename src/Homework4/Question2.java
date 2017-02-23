
package Homework4;

public class Question2 {
    ...
String[] students = new String[10];
String studentName = "Peter Smith";
students[0] = studentName;
studentName = null;
...
/* There is one reference to the students array and that array has one reference to the string Peter Smith. 
Neither object is eligible for garbage collection. 
The array students is not eligible for garbage collection because it has one reference to the object studentName even though that object has been assigned the value null. 
The object studentName is not eligible either because students[0] still refers to it.*/

    
}
