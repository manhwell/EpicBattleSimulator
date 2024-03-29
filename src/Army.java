/**
 * Army() provides the generation and manipulation of an army of Combatants().
 * @author C2C Manuel Riolo
 */
public class Army {

    // Initializing variables.
    private Combatant[] Army;
    private int armySize;

    /**
     * Generates a new Army class based on default values.
     */
    public Army(){
        Army = new Combatant[10]; // Allocate space for an army of 10
        for(int i = 0; i < 10; i++){
            int combatantClass = (int) (Math.random() * 2) + 1; // Random variable to choose what to put in the army.
            if(combatantClass == 1){
                this.Army[i] = new Combatant(); // Create a combatant.
            }
            else {
                this.Army[i] = new Archer(); // Create a knight
            }
        }
        this.armySize = 10;
    }

    /**
     * Generates a new Army class based on passed variables.
     * @param team The team # of the army.
     * @param armySize The size of as army.
     */
    public Army(int team, int armySize){
        Army = new Combatant[armySize]; // Allocate space for a proper army
        for(int i = 0; i < armySize; i++){
            int combatantClass = (int) (Math.random() * 2) + 1; // Random variable to choose what to put in the army.
            if(combatantClass == 1){  // Generate a melee class
                int meleeClass = (int) (Math.random() * 2) + 1; // Random variable to choose what melee class to put in the army
                if(meleeClass == 1) { // Create a combatant.
                    this.Army[i] = new Combatant(team);
                }
                else{ // Create a knight
                    this.Army[i] = new Knight(team);
                }
            }
            else { // Create a ranger class
                this.Army[i] = new Archer(team);
            }
        }
        this.armySize = armySize;
    }

    /**
     * Gets the members of an army
     * @return The array containing the members of an Army.
     */
    public Combatant[] getArmy(){
        return this.Army;
    }

    /**
     * Gets the soldier in a Combatant[]
     * @param indexNum The index number of the soldier to get.
     * @return The Combatant found at the index.
     */
    public Combatant getSoldier(int indexNum){
        return this.Army[indexNum];
    }

    /**
     * Gets the size of a army.
     * @return The integer value of an Army's size.
     */
    public int getArmySize(){
        return this.armySize;
    }

    /**
     * Draws an entire Army to a graphics window.
     */
    public void drawArmy(){
        // Go through the Combatant array and draw each combatant.
        for(int i = 0; i < this.armySize; i++){
            this.Army[i].draw();
        }
    }

    /**
     * Counts the number of dead Combatants in an Army.
     * @return The integer number of dead Combatants in an Army.
     */
    public int checkDead(){
        int numDead = 0;
        // Go through the Combatant array and if a combatants health is 0, increase dead count.
        for(int i = 0; i < this.armySize; i++){
            if(this.Army[i].getHealth() <= 0){
                numDead++;
            }
        }
        return numDead;
    }
}
