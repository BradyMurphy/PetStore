import java.util.*;
public class Leash extends Supplies{
    String animal;
    Leash(){
        super("leash");
        Random rand = new Random();
        int num = rand.nextInt(3);
        int num1 = rand.nextInt(30);
        String[] animals = new String[3];
        animals[0] = "dog";
        animals[1] = "cat";
        animals[2] = "bird";
        animal = animals[num];
        purchasePrice = num1;
        listPrice = purchasePrice*2;
    }
    Leash(String a){
        super("leash");
        Random rand = new Random();
        int num1 = rand.nextInt(30);
        animal = a;
        purchasePrice = num1;
        listPrice = purchasePrice*2;
    }
}