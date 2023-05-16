import java.util.*;
public class Inventory implements Logger{ //inventory class demonstrates encapsulation of the whole inventory
    //Inventory class also has good cohesion as it holds all objects and acts like a real inventory
    ArrayList<Item> items = new ArrayList<Item>();//holds all in store items
    ArrayList<Order> orders = new ArrayList<Order>();//holds orders that have been placed
    ArrayList<Item> soldItems = new ArrayList<Item>();//keeps track of sold items
    String[] itemName = new String[10];
    
    Inventory(){
        for(int i = 0; i < 3; i++){                         //intializes three of everything for starting inventory
            ItemFactory factory = new ItemFactory();        //factory to create Items
            Item item = factory.createItem("dog");      //creates a dog from factory
            items.add(item);
            item.setArrivalDate(1);
            Item item1 = factory.createItem("bird");
            items.add(item1);
            item1.setArrivalDate(1);
            Item item2 = factory.createItem("cat");
            items.add(item2);
            item2.setArrivalDate(1);
            Item item3 = factory.createItem("ferret");
            items.add(item3);
            item3.setArrivalDate(1);
            Item item4 = factory.createItem("snake");
            items.add(item4);
            item4.setArrivalDate(1);
            Item item5 = factory.createItem("toy");
            items.add(item5);
            item5.setArrivalDate(1);
            Item item6 = factory.createItem("litter");
            items.add(item6);
            item6.setArrivalDate(1);
            Item item7 = factory.createItem("food");
            items.add(item7);
            item7.setArrivalDate(1);
            Item item8 = factory.createItem("leash");
            items.add(item8);
            item8.setArrivalDate(1);
            Item item9 = factory.createItem("treats");
            items.add(item9);
            item9.setArrivalDate(1);
        }
        itemName[0] = "dog";
        itemName[1] = "cat";
        itemName[2] = "bird";
        itemName[3] = "ferret";
        itemName[4] = "snake";
        itemName[5] = "leash";
        itemName[6] = "toy";
        itemName[7] = "treats";
        itemName[8] = "food";
        itemName[9] = "litter";
    }
    
    void items(){//test to see items
        for(int i = 0; i < items.size(); i++){
            Items item = items.get(i);
            Item obj = (Item) item;
            System.out.println(obj.name + " " + obj.dayArrived);
        }
    }
    
    float addValue(){//returns purchasePrice total of all items
        float sum = 0;
        for(int i = 0; i < items.size(); i++){
            Items a = items.get(i);
            Item item = (Item) a;
            sum += item.purchasePrice;
        }
        return sum;
    }
    
    void summary(Register R, int day){//checks the ending inventory
        float value = 0;
        float profit = 0;
        int count = 0;
        sumout("After " + day + " days the following items are left in inventory.\n", day);
        for(int i = 0; i < items.size(); i++){//counts value of remaining inventory
            Items a = items.get(i);
            Item item = (Item) a;
            if(item.name == "pet"){
                Pet pet = (Pet) item;
                sumout(pet.breed + ": $" + String.format("%.2f", pet.purchasePrice) + "\n", day);
                value += pet.purchasePrice;
            }
            else{
                sumout(item.name + ": $" + String.format("%.2f", item.purchasePrice) + "\n", day);
                value += item.purchasePrice;
            }
        }
        sumout("Value of remaining inventory: $" + String.format("%.2f", value) + "\n", day);
        sumout("Over " + day + " days the following items were sold.\n", day);
        for(int i = 0; i < soldItems.size(); i++){//counts value of sold items
            Item item = soldItems.get(i);
            if(item.name == "pet"){
                Pet pet = (Pet) item;
                sumout(pet.breed + ": sold on day " + pet.daySold + " for $" + String.format("%.2f", pet.salePrice) + "\n", day);
                profit += pet.salePrice;
            }
            else{
                sumout(item.name + ": sold on day " + item.daySold + " for $" + String.format("%.2f", item.salePrice) + "\n", day);
                profit += item.salePrice;
            }

        }
        sumout("Total money from sales: $" + String.format("%.2f", profit) + "\n", day);
        for(int i = 0; i < items.size(); i++){//counts sick pets
            Items a = items.get(i);
            Item item = (Item) a;
            if(item.name == "pet"){
                Pet pet = (Pet) item;
                if(!pet.health){
                    count++;
                }
            }
        }
        sumout("There are " + count + " sick pets remaining in inventory.\n", day);
        float cash = R.getAmount();
        float total = R.getAmountAdded();
        sumout("There is $" + String.format("%.2f", cash) + " left in the register after " + day + " days.\n", day);
        sumout("$" + String.format("%.2f", total) + " was added to the register over " + day + " days.\n", day);
    }
}