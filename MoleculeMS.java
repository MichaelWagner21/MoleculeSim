import java.awt.Color;

public class MoleculeMS {
    int moleculeXPos;
    int moleculeYPos;

    AtomMS oxygen = new AtomMS(6,Color.RED);
    AtomMS hydrogen1 = new AtomMS(3, Color.WHITE);
    AtomMS hydrogen2 = new AtomMS(3, Color.WHITE);


    public MoleculeMS(int x, int y){
        moleculeXPos = x;
        moleculeYPos = y;

    }

    public void updateMolecule(){
        oxygen.atomXPos = moleculeXPos;
        oxygen.atomYPos = moleculeYPos;

        hydrogen1.atomXPos = moleculeXPos;
        hydrogen1.atomYPos = moleculeYPos+30;

        hydrogen2.atomXPos = moleculeXPos+30;
        hydrogen2.atomYPos = moleculeYPos;



        MainMS.thisPanel.drawLine(Color.GRAY, oxygen.atomXPos, oxygen.atomYPos, hydrogen1.atomXPos, hydrogen1.atomYPos);
        MainMS.thisPanel.drawLine(Color.GRAY, oxygen.atomXPos, oxygen.atomYPos, hydrogen2.atomXPos, hydrogen2.atomYPos);



        oxygen.drawOn(MainMS.thisPanel);
        hydrogen1.drawOn(MainMS.thisPanel);
        hydrogen2.drawOn(MainMS.thisPanel);

    }

}