
package Multithreading;


public class Husband extends Thread { 
private final Thread vacuumCleaner;
private final Thread wife;
public Husband(Thread wife, Thread vacuumCleaner) {
    super("Husband");
    this.wife = wife;
    this.vacuumCleaner = vacuumCleaner;
}
@Override
 public void run() {
     System.out.println("The husband enters the scene. ");
      wife.start();
      vacuumCleaner.start();
      while (true) {
          synchronized (this) {
              try {
                  System.out.println("The husband is vacuuming.");
                  sleep(1000);
                  } catch (InterruptedException e) {
                       vacuumCleaner.interrupt();
                       System.out.println("The husband tells his wife to wake up.");
                       wife.interrupt();
                       break;
              }
          }
      }
 }
    public TvShows getWifeFavouriteShow() {
        return ((Wife) wife).getHerFavouriteShow();
    }
}
