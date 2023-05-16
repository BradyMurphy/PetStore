public class Simulation implements Logger{
    Simulation(){}
    
    void run(){
        Employees staff = new Employees();      //initializes a staff object
        Inventory stock = new Inventory();      //initializes Inventory with 3 of every subclass
        Register r = new Register();            //initializes a register with $0
        staff.hire();                           //Hires staff; 3 clerks, 3 trainers 
        
        int daysOpen = 6;                      // Changes days open to log and simulate (Add one more than desired # of days)

        for(int i = 1; i < daysOpen; i++){
            //stock.items();
            clear(i);
            sumclear(daysOpen-1);
            staff.ArriveAtStore(i);             //method in employees class
            Clerk c = staff.getClerk();
            Trainer t = staff.getTrainer();
            c.processDeliveries(c, stock, i);   //method in clerk class
            t.feedAnimals(stock, t, i);         //method in trainer class
            c.checkRegister(c, r, i);
            c.doInventory(c, stock, r, i);
            t.trainAnimals(stock, i);

            //staff.interact(stock, staff);     //Allows you to interact with simulation (WORK IN PROGRESS)

            staff.openStore(stock,c,t,r,i);     //method in employees class
            staff.cleanStore(stock, c, t, i);
            staff.leaveStore(c,t, i);
        }

        sumout("       -------End Simulation-------\n", daysOpen-1);
        stock.summary(r, daysOpen-1);           //method in Inventory class
    }
}