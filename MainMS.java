import java.util.Random;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.Color;


public class MainMS {
    
    
    final static int XBOUND = 775;
    final static int YBOUND = 750;
    
    
    final static double TIME = 10;


    
    public static void main(String[] args){

        System.out.print("\033[H\033[2J");


        JFrame appFrame = new JFrame("Direct draw demo");

        PanelMS panel = new PanelMS(XBOUND, YBOUND);

        appFrame.add(panel);
        appFrame.pack();
        appFrame.setVisible(true);
        appFrame.setResizable(false);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel.drawRect(Color.RED, 0, 0, XBOUND/2, YBOUND/2);


        

    }






    public static void wait(int t){
        try {
            Thread.sleep(t);
          } 
        catch (InterruptedException ex) {
    
            Thread.currentThread().interrupt();
          }
    }

    public static void update(PanelMS w){
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
    