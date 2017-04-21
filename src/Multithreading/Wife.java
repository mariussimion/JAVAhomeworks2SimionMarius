
package Multithreading;

import java.util.Random;

    
public class Wife extends Thread { 

 
     private final Thread womanCigar; 
     private final TvShows herFavouriteShow; 
 
 
     public Wife(Thread cigar) { 
         super("Wife"); 
         this.womanCigar = cigar; 
         this.herFavouriteShow = TvShows.values()[(new Random()).nextInt(TvShows.values().length)]; 
     } 
 
 
    @Override 
    public void run() { 
         System.out.println("The wife enters the scene. . "); 
         womanCigar.start(); 
         while (true) { 
             synchronized (this) { 
                try { 
                     System.out.println("The wife is sleeping."); 
                     wait(); 
                 } catch (InterruptedException e) { 
                     System.out.println("The wife is awake"); 
                     System.out.println("The woman has a cigarette in her hand "); 
                     womanCigar.interrupt(); 
                     System.out.println(" The woman follows her favorite show:  " 
                             + herFavouriteShow); 
                     break; 
                 } 
             } 
         } 
     } 
 
 
    public TvShows getHerFavouriteShow() { 
         return herFavouriteShow; 
     } 
 
 
 } 

