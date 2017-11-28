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
public class Warrior extends Character{
    
    private static int[] defaultStats={4,2,1,3,1};
    
    private int strength=defaultStats[0];
    private int charisma=defaultStats[1];
    private int dexterity=defaultStats[2];
    private int vitality=defaultStats[3];
    private int visdom=defaultStats[4];
    
    public Warrior(String firtname, String surname, Sex sex, Father father,int id) {
        super(firtname, surname, sex, father,id);
    }
    public Warrior(String firtname, String surname, Sex sex, Father father) {
        super(firtname, surname, sex, father,0);
    }
    public Warrior() {
       
    } 
    
    public static String getDescription(){
        return "strength: "+defaultStats[0]+"\ncharisma: "+defaultStats[1]+"\ndexterity: "+defaultStats[2]+"\nvitality: "+defaultStats[3]+"\nvisdom: "+defaultStats[4];
    }
    public String getStats(){
        return "strength: "+strength+"\ncharisma: "+charisma+"\ndexterity: "+dexterity+"\nvitality: "+vitality+"\nvisdom: "+visdom;
    }

}
