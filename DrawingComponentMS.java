import java.awt.Component;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class DrawingComponentMS extends Component{
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.CYAN);
        int x = 25;
        int y = 32;
        g.drawLine(x,y,x,y);
    }
}
