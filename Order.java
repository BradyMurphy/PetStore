public class Order implements Logger{
    
    //////////////////////////////
    Item item1;
    Item item2;
    Item item3;
    int dayArriving = 0;
    float orderTotal = 0;
    /////////////////////////////

    Order(){}

    void addToOrder(Item a, Item b, Item c, int day){
        item1 = a;
        item2 = b;
        item3 = c;
        dayArriving = day;
    }

    void getOrderCost(int i){
        orderTotal = item1.purchasePrice + item2.purchasePrice + item3.purchasePrice;
        out("The order will cost $" + orderTotal +"\n", i);
    }

    void addToInventory(Clerk c, Inventory I, int i){
        if(item1.name == "pet"){
            Pet pet1 = (Pet) item1;
            out(c.name + " says a new " + pet1.breed + " has arrived on " + i + ". It will be added to inventory.\n", i);
            I.items.add(pet1);
        }
        else{
            out(c.name + " says a new " + item1.name + " has arrived on " + i + ". It will be added to inventory.\n", i);
            I.items.add(item1);
        }
        if(item2.name == "pet"){
            Pet pet2 = (Pet) item2;
            out(c.name + " says a new " + pet2.breed + " has arrived on " + i + ". It will be added to inventory.\n", i);
            I.items.add(pet2);
        }
        else{
            out(c.name + " says a new " + item2.name + " has arrived on " + i + ". It will be added to inventory.\n", i);
            I.items.add(item2);
        }
        if(item3.name == "pet"){
            Pet pet3 = (Pet) item3;
            out(c.name + " says a new " + pet3.breed + " has arrived on " + i + ". It will be added to inventory.\n", i);
            I.items.add(pet3);
        }
        else{
            out(c.name + " says a new " + item3.name + " has arrived on " + i + ". It will be added to inventory.\n", i);
            I.items.add(item3);
        }
    }
}