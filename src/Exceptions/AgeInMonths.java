
package Exceptions;


public class AgeInMonths {
    public static void main(String[] args) {

try {
    System.out.println(ageInMonths(Integer.parseInt(args[0])));
    } catch (NumberFormatException e) {
         System.out.println("first program argument needs to be an int");
         } catch (IllegalArgumentException e) {
             System.out.println(e.getMessage());
         }
    }
    static int ageInMonths(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("age should be >= 0");
        }
        return age * 12;
    }
}
