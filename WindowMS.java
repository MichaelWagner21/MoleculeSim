import javax.swing.JFrame;
import java.awt.Color;


public class WindowMS extends JFrame{
    public WindowMS(){


        this.setTitle("Molecule Simulator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(MainMS.XBOUND+25,MainMS.YBOUND+50);
        this.setVisible(true);
        this.setLayout(null);

        this.getContentPane().setBackground(new Color(0,0,0));

    }
}
