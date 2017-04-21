
package Multithreading;

import java.util.Random;
public class Tv extends Thread {
    private final Thread husband;
    public Tv(Thread husband) { 
         this.husband = husband; 
    } 
     @Override     
     public void run() { 
         husband.start(); 
         System.out.println("The TV is on."); 
         int i; 
         try { 
            synchronized (this) { 
                 while (true) { 
                    i = (new Random()).nextInt(TvShows.values().length); 
                     System.out.println("The show begins: " + TvShows.values()[i]); 
                     if (TvShows.values()[i].equals(((Husband) husband).getWifeFavouriteShow())) { 
                         notifyAll(); 
                        throw new InterruptedException(); 
                     } 
                } 
             } 
         } catch (InterruptedException e) { 
             husband.interrupt(); 
         } 
     } 
 
 
 } 


    

