/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classeditor;

/**
 *
 * @author Garttox
 */
public class Mage extends Character{

    
    private static int[] defaultStats={1,2,2,1,5};
    
    private int strength;
    private int charisma;
    private int dexterity;
    private int vitality;
    private int visdom;
    
    public Mage(String firtname, String surname, Sex sex, Father father,int id) {
        super(firtname, surname, sex, father,id);
        setDefaultStats();
    }
    public Mage(String firtname, String surname, Sex sex, Father father) {
        super(firtname, surname, sex, father,0);
        setDefaultStats();
    }
    
    public Mage(){
        setDefaultStats();
    }
    
    private void setDefaultStats(){
        strength=defaultStats[0];
        charisma=defaultStats[1];
        dexterity=defaultStats[2];
        vitality=defaultStats[3];
        visdom=defaultStats[4];
    }
    
    public static String getDescription(){
        return "strength: "+defaultStats[0]+"\ncharisma: "+defaultStats[1]+"\ndexterity: "+defaultStats[2]+"\nvitality: "+defaultStats[3]+"\nvisdom: "+defaultStats[4];
    }
    public String getStats(){
        return "strength: "+strength+"\ncharisma: "+charisma+"\ndexterity: "+dexterity+"\nvitality: "+vitality+"\nvisdom: "+visdom;
    }
}
