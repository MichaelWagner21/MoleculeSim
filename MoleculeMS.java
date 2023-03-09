import java.awt.Color;

public class MoleculeMS {
    int molXPos;
    int molYPos;

    private double moleculeMass = 100;

    private double moleculeRotation = 0;

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
        //Delete Below
        oxygen.atomXForce = 3;
        molXPos = x;
        molYPos = y;

    }

    public void updateMolecule(){

        //If on edge, bounce
        if ((oxygen.atomXPos+oxygen.atomRadius>MainMS.XBOUND)){
            oxygen.atomXForce =    -1*Math.abs(molXForce);
        }
        if(hydrogen1.atomXPos+hydrogen1.atomRadius>MainMS.XBOUND){
            hydrogen1.atomXForce = -1*Math.abs(molXForce);
        }
        if (hydrogen2.atomXPos+hydrogen2.atomRadius>MainMS.XBOUND){
            hydrogen2.atomXForce = -1*Math.abs(molXForce);
        }

        if ((oxygen.atomXPos+oxygen.atomRadius<0)){
            oxygen.atomXForce =    Math.abs(molXForce);
        }
        if(hydrogen1.atomXPos+hydrogen1.atomRadius<0){
            hydrogen1.atomXForce = Math.abs(molXForce);
        }
        if (hydrogen2.atomXPos+hydrogen2.atomRadius<0){
            hydrogen2.atomXForce = Math.abs(molXForce);
        }

        //Sum of atom forces
        molXForce = oxygen.atomXForce+hydrogen1.atomXForce+hydrogen2.atomXForce;
        molYForce = oxygen.atomYForce+hydrogen1.atomYForce+hydrogen2.atomYForce;

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
        hydrogen1.atomXPos = (int)Math.round(molXPos+  -1*30*Math.sin(moleculeRotation));
        hydrogen1.atomYPos = (int)Math.round(molYPos+     30*Math.cos(moleculeRotation));

        
        hydrogen2.atomXPos = (int)Math.round(molXPos+    30*Math.cos(moleculeRotation));
        hydrogen2.atomYPos = (int)Math.round(molYPos+    30*Math.sin(moleculeRotation));


        //Draws lines between atoms of the same moleclue
        MainMS.thisPanel.drawLine(Color.GRAY, oxygen.atomXPos, oxygen.atomYPos, hydrogen1.atomXPos, hydrogen1.atomYPos);
        MainMS.thisPanel.drawLine(Color.GRAY, oxygen.atomXPos, oxygen.atomYPos, hydrogen2.atomXPos, hydrogen2.atomYPos);


        //Draws Atoms
        oxygen.drawOn(MainMS.thisPanel);
        hydrogen1.drawOn(MainMS.thisPanel);
        hydrogen2.drawOn(MainMS.thisPanel);

    }

}