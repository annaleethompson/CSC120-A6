/** 
 * Filename: Cafe.java
 * Decription: Cafe class extentded from Building with attributes nCoffeeOunces, nSugarPackets, nCreams, and nCups. Contains functions sellCoffee, and restock.
 * A part of CSC 120-02: Object-Oriented Programming, Smith College Spring 2023, A6: Use What Your Parent (Class) Gave You
 * @author Anna-Lee Thompson (@annaleethompson)
 * Date: March 19, 2023
 */

/* This is a stub for the Cafe class */
public class Cafe extends Building {

    /**Stores integers for the number of coffee ounces, sugar packets, creams, and cups in stock. */
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**Constructor */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**Manupulator to sell coffee if sufficient stock is available which decrease the stock of all attributes. 
     * @param size the number of coffee ounces used when making the coffee
     * @param nSugarPackets the number of sugar packets used in this order
     * @param nCreams the number of creams used in this order
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces<size || this.nSugarPackets<nSugarPackets || this.nCreams<nCreams || this.nCups == 0) {
            System.out.println("Insufficient stock -> Restocking");
            restock(size, nSugarPackets, nCreams, 1);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Coffee succesfully sold!");
    }

    /**Manipulator to restock supplies.
     * @param nCoffeeOunces the number of coffee ounces to be added to the current stock
     * @param nSugarPackets the number of sugar packets to be added to the current stock
     * @param nCreams the number of creams to be added to the current stock
     * @param nCups the number of cups to be added to the current stock
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }
    
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Compass", "Neilson", 1, 50, 30, 20, 0);
        myCafe.sellCoffee(10, 5, 3);
        System.out.println(myCafe.nCoffeeOunces);
        System.out.println(myCafe.nSugarPackets);
        System.out.println(myCafe.nCreams);
        System.out.println(myCafe.nCups);
        
    }
    
}

//## Phase 3: The `Cafe` class
//Finally, my personal favorite type of building within walking distance of any college campus, the `Cafe`:

//<img src="https://cdn-icons-png.flaticon.com/512/1839/1839053.png" alt="Cafe icon created by Freepik - Flaticon" width="200"/>

//Unlike the `House` and the `Library`, the `Cafe` doesn't need to keep track of a large number of individual things. Instead, it needs to keep track of its inventory, which in this simplified world is just three ingredients and the cups to put them in:

//```
//private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
//private int nSugarPackets; // The number of sugar packets remaining in inventory
//private int nCreams; // The number of "splashes" of cream remaining in inventory
//private int nCups; // The number of cups remaining in inventory
//```

//---
//1. Make the `Cafe` class `extend` the `Building` class, add the attributes listed above, and modify the `Cafe` constructor to set the starting values of each of the stocked items (coffee, sugar, cream, and cups).

//---
//2. Write a method to decrease the remaining inventory when the `Cafe` sells a cup of coffee:
//```
//public void sellCoffee(int size, int nSugarPackets, int nCreams);
//```
//Each time this method is called, the inventory should decrease in each category according to the given parameters, e.g. calling `myCafe.sellCoffee(12, 2, 3);`
//should decrease the `myCafe` object's `nCoffeeOunces` by 12, `nSugarPackets` by 2, and `nCreams` by 3 (and of course, `nCups` by 1).

//---
//3. And of course, a `Cafe` can't sell what it doesn't have in stock, so let's also write a method to restock when necessary:
//```
//private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups); 
//```
//This method will be `private` (since we don't want some random person forcefully restocking the shelves!) - we'll call it from **inside** the `sellCoffee(...)` method, in the event that we don't have enough ingredients in stock to make the requested drink.

