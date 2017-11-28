/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classeditor;

/**
 *
 * @author student
 */
public class Character {
    private String firstname;
    private String surname;
    private Sex sex;
    private Father father;
    private int id;
    
    public enum Sex {
        MAN, WOMAN, NON_BINARY
    }
    
    public enum Father {
        MERCHANT, KNIGHT, MERCENARY, BLACKSMITH
    }

    public Character(){
        
    }
    
    public Character(String firtname, String surname, Sex sex, Father father,int id) {
        this.id = id;
        this.firstname = firtname;
        this.surname = surname;
        this.sex = sex;
        this.father = father;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }
    @Override
    public String toString(){
        String output = this.getFirstname() +" "+ this.getSurname();
        return output;
    }
}
