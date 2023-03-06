import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class PanelMS extends JPanel {

    private BufferedImage canvas;

    private int width;
    private int height;

    public PanelMS(int w, int h) {
        canvas = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        width = w;
        height = h;
        fillCanvas(Color.BLACK);
        
    }

    public Dimension getPreferredSize() {
        return new Dimension(canvas.getWidth(), canvas.getHeight());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canvas, null, null);
    }


    public void fillCanvas(Color c) {
        int color = c.getRGB();
        for (int x = 0; x < canvas.getWidth(); x++) {
            for (int y = 0; y < canvas.getHeight(); y++) {
                canvas.setRGB(x, y, color);
            }
        }
        repaint();
    }


    public void drawLine(Color c, int x1, int y1In, int x2, int y2In) {
        int color = c.getRGB();
        int y2=height-y2In;
        int y1=height-y1In;

        double m = (y2-y1)/(x2-x1);

        if (x1<=x2){
            for (int x = x1; x<=x2; x++){
                int y = (int)Math.round(m*(x-x1)+y1);
                canvas.setRGB(x, y, color);
            }
        }
        else{
            for (int x = x2; x<=x1; x++){
                int y = (int)Math.round(m*(x-x2)+y2);
                canvas.setRGB(x, y, color);
            }
        }

        repaint();
    }

    public void drawRect(Color c, int x1, int y1In, int width, int height) {
        int color = c.getRGB();
        int y1=height-y1In;
        for (int x = x1; x < x1 + width; x++) {
            for (int y = y1; y < y1 + height; y++) {
                canvas.setRGB(x, y, color);
            }
        }
        repaint();
    }

    public void drawCircle(Color c, int x1, int y1In, int radius) {
        int color = c.getRGB();
        int y1=height-y1In;

        for (int radIterator = 0; radIterator<=radius; radIterator++){
            if (radIterator !=0){
                double angleIterator = Math.PI/radIterator;
                for (double theta = 0; theta<=Math.PI; theta+=angleIterator){
                    int tempY = (int)Math.round(Math.sin(theta)*radIterator);
                    int tempX = (int)Math.round(Math.cos(theta)*radIterator);
                    canvas.setRGB(tempX,tempY,color);
                }
            }
            else {
                canvas.setRGB(0,0,color);
            }
            
        }

        repaint();
    }


}