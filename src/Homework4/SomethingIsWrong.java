
package Homework4;

public class SomethingIsWrong {
     public static void main(String[] args) {
        Rectangle myRect;
/*In this code has not created a Rectangle object, the compiler will generate a error.
In another situation myRect can be initialized as zero.
In this case the program will run smoothly but will generate NullPointerException.*/
        myRect.width = 40;
        myRect.height = 50;
        System.out.println("myRect's area is " + myRect.area());
    }

    
}
