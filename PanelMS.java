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
        repaint();
    }

    public void drawRect(Color c, int x1, int y1, int width, int height) {
        int color = c.getRGB();
        // Implement rectangle drawing
        for (int x = x1; x < x1 + width; x++) {
            for (int y = y1; y < y1 + height; y++) {
                canvas.setRGB(x, y, color);
            }
        }
        repaint();
    }

    public void drawOval(Color c, int x1, int y1, int width, int height) {
        // Implement oval drawing
        repaint();
    }


}