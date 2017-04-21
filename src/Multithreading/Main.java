
package Multithreading;


public class Main {

   
    public static void main(String[] args) {
               Thread tv = new Tv(new Husband(new Wife(new Cigar()), new VacuumCleaner())); 
        tv.start(); 
    } 
 } 

   
    
