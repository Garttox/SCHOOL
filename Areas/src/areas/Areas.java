package areas;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Areas {
    Scanner sc= new Scanner(System.in, "UTF-8");
    enum Options{
        S,R,T,C,X;
    }
    
    float readNumber(String text){
        float input = -1;
        do {
            try{
                System.out.printf(text + ": ");
                input = sc.nextFloat();
                if(input <0){
                    System.out.println("Číslo nesmí být záporné");
                }
            } catch(InputMismatchException e){
                System.out.println("Nesprávně zadané číslo");
            }
        }while(input < 0);
        return input;
    }
    
    double getSquareArea(float a){
        return Math.pow(a, 2);
    }
    
    double getRectangleArea(float a, float b){
        return a*b;
    }
    
    double getTriangleArea(float a, float v){
        return (a*v)/2;
    }
    
    double getRingArea(float r){
        return Math.PI*Math.pow(r, 2);
    }
    
    void menu(){
        float a;
        float b;
        float r;
        float v;
        String optChar = "";
        do{
            System.out.println("Výpočet plochy geometrických útvarů");
            System.out.println("-------------------------------------");
            System.out.println("S - čtverec, R - obdelník, T - trojúhelník, C - kruh, X - konce");
            System.out.println("Zadej volbu: ");
            optChar = sc.nextLine();
            try{
                Options option = Options.valueOf(optChar.toUpperCase());
                switch(option){
                    case S:
                        System.out.println("Čtverec");
                        a = this.readNumber("Zadej stranu a");
                        System.out.printf("Plocha čtverce o straně %.2f je %.3f", a, this.getSquareArea(a));
                        System.out.println("");
                        break;
                    case R:
                        System.out.println("Obdelník");
                        a = this.readNumber("Zadej stranu a");
                        b = this.readNumber("Zadej stranu b");
                        System.out.printf("Plocha obdelník o stranach %.2f a %.2f je %.3f", a,b, this.getRectangleArea(a,b));
                        System.out.println("");
                        break;
                    case T:
                        System.out.println("Obdelník");
                        a = this.readNumber("Zadej stranu a");
                        v = this.readNumber("Zadej výšku v na stranu a");
                        System.out.printf("Plocha trojuhelnik o straně %.2f a výšce na stranu %.2f je %.3f", a,v, this.getTriangleArea(a,v));
                        System.out.println("");
                        break;
                    case C:
                        System.out.println("Obdelník");
                        r = this.readNumber("Zadej poloměr a");
                        System.out.printf("Plocha čtverce o poloměru %.2f je %.3f", r, this.getRingArea(r));
                        System.out.println("");
                        break;
                }
            }catch(Exception e){
                
            }
        }while(!optChar.equalsIgnoreCase("X"));
    }
    
    public static void main(String[] args){
        Areas areas = new Areas();
        areas.menu();
    }
    
}
