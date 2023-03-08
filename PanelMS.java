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


    public void drawLine(Color c, int x1, int y1, int x2, int y2) {

        int minX = Math.min(x1,x2);
        int maxX = Math.max(x1,x2);

        int minY = Math.min(y1,y2);
        int maxY = Math.max(y1,y2);

        double m = ((double)(y2-y1)/(double)(x2-x1));

        int y = y1;
        int xIt = x1;
        setPixel(x1,y1,c);
        setPixel(x2,y2,c);

            if (Math.abs(m)>1){
                for (int yIt = y1; (minX<=xIt&xIt<=maxX)&(minY<=yIt&yIt<=maxY); yIt+=Math.signum(y2-y1)){
                    xIt = (int)(((yIt-y1)/m)+x1);
                    setPixel(xIt,yIt,c);
                }
            }
            else{
                for (int x = x1; (minX<=x&x<=maxX)&(minY<=y&y<=maxY); x+=Math.signum(x2-x1)){
                    y= (int)(m*(x-x1)+y1);
                    setPixel(x,y,c);
                }
            }
            
        
    

        repaint();
    }

    public void drawRect(Color c, int x1, int y1, int width, int height) {
   
        for (int x = x1; x < x1 + width; x++) {
            for (int y = y1; y < y1 + height; y++) {
                setPixel(x, y, c);
            }
        }
        repaint();
    }

    public void drawCircle(Color c, int x1, int y1, int radius) {

        for (int row = y1-radius; row<= y1+radius; row++){
            for (int col = x1-radius; col<=x1+radius;col++){
                if (twoDimDistance(x1,y1,col,row)<=radius){
                    setPixel(col,row,c);
                }
            }
        }

        

        repaint();
    }


    public static double twoDimDistance(double x1, double y1, double x2, double y2){
        double verDis = y2-y1;
        double horDis = x2-x1;
        double diagDis = Math.sqrt(verDis*verDis+horDis*horDis);
        return diagDis;
    }


    public void setPixel(int x, int yIn, Color c){
        int y = MainMS.YBOUND-yIn;
        if ((x>0&y>0)&(x<MainMS.XBOUND&y<MainMS.YBOUND)){
            canvas.setRGB(x,y,c.getRGB());
        }
    }


}