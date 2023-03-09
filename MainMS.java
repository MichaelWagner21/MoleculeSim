//x: 0-775
//y: 0-750

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class MainMS {
    
    
    final static int XBOUND = 775;
    final static int YBOUND = 750;
    
    
    final static int TIME = 10;

    public static PanelMS thisPanel = new PanelMS(XBOUND, YBOUND);



    
    public static void main(String[] args){

        System.out.print("\033[H\033[2J");


        JFrame appFrame = new JFrame("Molecule Simulator");


        appFrame.add(thisPanel);
        appFrame.pack();
        appFrame.setVisible(true);
        appFrame.setResizable(false);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        

        MoleculeMS water1 = new MoleculeMS(100, 100);
        
        while (true){
            water1.updateMolecule();
            wait(TIME);
            thisPanel.fillCanvas(Color.BLACK);

        }
        


        

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
    