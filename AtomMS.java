import java.awt.Color;

public class AtomMS {
    int atomXPos;
    int atomYPos;
    int atomRadius;
    Color atomColor;

    double atomXForce;
    double atomYForce;

    public AtomMS(int x, int y, int radius, Color c){
        atomXPos = x;
        atomYPos = y;
        atomRadius = radius;
        atomColor = c;
    }

    public AtomMS(int radius, Color c){
        atomRadius = radius;
        atomColor = c;
    }

    public void drawOn(PanelMS panel){
        panel.drawCircle(atomColor, atomXPos, atomYPos, atomRadius);
    }
}
