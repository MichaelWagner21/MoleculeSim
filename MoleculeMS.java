import java.awt.Color;

public class MoleculeMS {
    int molCOMXPos;
    int molCOMYPos;

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


    AtomMS oxygen = new AtomMS((int)Math.round(14.4),Color.RED);
    AtomMS hydrogen1 = new AtomMS((int)Math.round(15.87), Color.WHITE);
    AtomMS hydrogen2 = new AtomMS((int)Math.round(15.87), Color.WHITE);


    public MoleculeMS(int x, int y){
        molCOMXPos = x;
        molCOMYPos = y;

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


        molCOMXPos+=molXDisplacement;
        molCOMYPos+=molYDisplacement;




        //Below: Sets oxygen relative to center of mass
        oxygen.atomXPos = (int)(Math.round((-1.31098)*Math.cos(moleculeRotationDisplacement)-(-1.31098)*Math.sin(moleculeRotationDisplacement))+molCOMXPos);
        oxygen.atomYPos = (int)(Math.round((-1.31098)*Math.sin(moleculeRotationDisplacement)+(-1.31098)*Math.cos(moleculeRotationDisplacement))+molCOMYPos);

        //below: Sets the hydrogen atoms a certain distance, 30 in this case, away from the center, or oxygen atom
        hydrogen1.atomXPos = (int)(Math.round(("x")*Math.cos(moleculeRotationDisplacement)-("y")*Math.sin(moleculeRotationDisplacement))+molCOMXPos);
        hydrogen1.atomYPos = (int)(Math.round(("x")*Math.sin(moleculeRotationDisplacement)+("y")*Math.cos(moleculeRotationDisplacement))+molCOMYPos);

        
        hydrogen2.atomXPos = (int)(Math.round(("x")*Math.cos(moleculeRotationDisplacement)-("y")*Math.sin(moleculeRotationDisplacement))+molCOMXPos);
        hydrogen2.atomYPos = (int)(Math.round(("x")*Math.sin(moleculeRotationDisplacement)+("y")*Math.cos(moleculeRotationDisplacement))+molCOMYPos);


        //Draws lines between atoms of the same moleclue
        MainMS.thisPanel.drawLine(Color.GRAY, oxygen.atomXPos, oxygen.atomYPos, hydrogen1.atomXPos, hydrogen1.atomYPos);
        MainMS.thisPanel.drawLine(Color.GRAY, oxygen.atomXPos, oxygen.atomYPos, hydrogen2.atomXPos, hydrogen2.atomYPos);


        //Draws Atoms
        hydrogen1.drawOn(MainMS.thisPanel);
        hydrogen2.drawOn(MainMS.thisPanel);
        oxygen.drawOn(MainMS.thisPanel);

    }

}