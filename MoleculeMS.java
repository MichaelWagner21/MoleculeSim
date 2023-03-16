import java.awt.Color;

public class MoleculeMS {
    int molXPos;
    int molYPos;

    private double moleculeMass = 100;

    private double moleculeRotationDisplacement = 0;

    private double molXForce = 0;
    private double molYForce = 0;

    private double molAccel = 0;
    private double molXAccel = 0;
    private double molYAccel = 0;

    private double molVelocity = 0;
    private double molXVelocity = 0;
    private double molYVelocity = 0;

    private double molDisplacement = 0;
    private double molXDisplacement = 0;
    private double molYDisplacement = 0;


    AtomMS oxygen = new AtomMS(6,Color.RED);
    AtomMS hydrogen1 = new AtomMS(3, Color.WHITE);
    AtomMS hydrogen2 = new AtomMS(3, Color.WHITE);


    public MoleculeMS(int x, int y){
        molXPos = x;
        molYPos = y;

    }

    public void updateMolecule(){

        //If on edge, bounce
        if ((oxygen.atomXPos+oxygen.atomRadius>MainMS.XBOUND)){
        }
        if(hydrogen1.atomXPos+hydrogen1.atomRadius>MainMS.XBOUND){
        }
        if (hydrogen2.atomXPos+hydrogen2.atomRadius>MainMS.XBOUND){
        }

        if ((oxygen.atomXPos+oxygen.atomRadius<0)){
        }
        if(hydrogen1.atomXPos+hydrogen1.atomRadius<0){
        }
        if (hydrogen2.atomXPos+hydrogen2.atomRadius<0){
        }


        //Attribute Calculation
        molXAccel = molXForce/moleculeMass;
        molYAccel = molYForce/moleculeMass;

        molXVelocity = molXAccel*MainMS.TIME;
        molYVelocity = molYAccel*MainMS.TIME;

        molXDisplacement = molXVelocity*MainMS.TIME;
        molYDisplacement = molYVelocity*MainMS.TIME;


        molXPos+=molXDisplacement;
        molYPos+=molYDisplacement;




        //Below: Sets oxygen as the center of the molecule
        oxygen.atomXPos = molXPos;
        oxygen.atomYPos = molYPos;

        //below: Sets the hydrogen atoms a certain distance, 30 in this case, away from the center, or oxygen atom
        hydrogen1.atomXPos = (int)Math.round(molXPos+  -1*30*Math.sin(moleculeRotationDisplacement));
        hydrogen1.atomYPos = (int)Math.round(molYPos+     30*Math.cos(moleculeRotationDisplacement));

        
        hydrogen2.atomXPos = (int)Math.round(molXPos+    30*Math.cos(moleculeRotationDisplacement));
        hydrogen2.atomYPos = (int)Math.round(molYPos+    30*Math.sin(moleculeRotationDisplacement));


        //Draws lines between atoms of the same moleclue
        MainMS.thisPanel.drawLine(Color.GRAY, oxygen.atomXPos, oxygen.atomYPos, hydrogen1.atomXPos, hydrogen1.atomYPos);
        MainMS.thisPanel.drawLine(Color.GRAY, oxygen.atomXPos, oxygen.atomYPos, hydrogen2.atomXPos, hydrogen2.atomYPos);


        //Draws Atoms
        oxygen.drawOn(MainMS.thisPanel);
        hydrogen1.drawOn(MainMS.thisPanel);
        hydrogen2.drawOn(MainMS.thisPanel);

    }

}