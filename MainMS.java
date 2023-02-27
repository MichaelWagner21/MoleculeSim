import javax.swing.SwingUtilities;
import java.util.Random;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import java.awt.Color;


public class MainMS {
    static WindowMS appFrame = new WindowMS();
    
    
    final static int XBOUND = 775;
    final static int YBOUND = 750;
    
    
    final static double TIME = 10;


    
    public static void main(String[] args){

        System.out.print("\033[H\033[2J");



        

    }






    public static void wait(int t){
        try {
            Thread.sleep(t);
          } 
        catch (InterruptedException ex) {
    
            Thread.currentThread().interrupt();
          }
    }

    public static void refresh(WindowMS w){
        SwingUtilities.updateComponentTreeUI(w);
    }

    public static int randNum(double min, double max){
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }

    public static double randNumDouble(double min, double max){
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }

}
    