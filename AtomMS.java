import java.awt.Color;

public class AtomMS {
    int atomXPos;
    int atomYPos;
    int atomRadius;
    Color atomColor;
    public AtomMS(int x, int y, int radius, Color c){
        atomXPos = x;
        atomYPos = y;
        atomRadius = radius;
        atomColor = c;
    }
    public void refreshOn(PanelMS panel){
        panel.drawCircle(atomColor, atomXPos, atomYPos, atomRadius);
    }
}
