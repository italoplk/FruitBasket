package lab5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by OzzY on 9/23/2014.
 */
public class FruitBasket {

    static int maxWeight = 5;
    static float totalCost = 0;
    static float weight = 0;
    static Scanner in = new Scanner(System.in);


    static List<Fruit>  content = new ArrayList<Fruit>();



    public static void takeBite(int i){

        weight -= content.get(i).weight;
        content.get(i).takeBite();
        weight += content.get(i).weight;


    }
    public static void bite() {

        int whichFruit;

        System.out.println("You want to bite which fruit?");
        System.out.println("1. Apple");
        System.out.println("2. Banana");
        System.out.println("3. Pear");
        System.out.println("4. Orange");
        System.out.println("5. Exit");

        whichFruit = in.nextInt();


        //System.out.println(i+". "+content[i].toString())


        // I didn't know if we were needed to check if the fruit needs to be peeled or not. So i left the boolean peel and check it in the method.
        //But I found unecessary calling the method since we already know that oranges and bananas will never be bitten.

        switch (whichFruit) {
            case 1:
                for (int i = 0; i < content.size(); i++) {
                    if (content.get(i) instanceof Apple) {
                        takeBite(i);
                        break;
                    }
                }

                break;

            case 2:


                System.out.println("Sorry, you cannot bite Bananas");
                break;

            case 3:

                for (int i = 0; i < content.size(); i++) {
                    if (content.get(i) instanceof Pear) {

                        takeBite(i);
                        break;
                    }
                }


                break;

            case 4:

                System.out.println("Sorry, you cannot bite Oranges");

                break;

            case 5:

                break;

            default:
                System.out.println("Invalid option!");


        }

    }


    public static void add() {

        int whichFruit;

        System.out.println("Which fruit do you want to add?");
        System.out.println("1. Apple");
        System.out.println("2. Banana");
        System.out.println("3. Pear");
        System.out.println("4. Orange");


        whichFruit = in.nextInt();

        switch (whichFruit) {
            case 1:

                content.add(new Apple());

                break;

            case 2:

                content.add(new Banana());

                break;
            case 3:

                content.add(new Pear());

                break;
            case 4:

                content.add(new Orange());

                break;
            default:
                System.out.println("Sorry, we do NOT work with this kind of fruit!");


        }

        FruitBasket.weight += content.get(content.size() - 1).weight;

        if (FruitBasket.weight <= 5) {


            FruitBasket.totalCost += content.get(content.size() - 1).price;

            printBasket();
        }else {

            FruitBasket.weight -= content.get(content.size() - 1).weight;
            content.remove(content.size() - 1);
            System.out.println("The fruit was too heavy to be added!");

        }

    }

    public static void remove() {

        int index;
        System.out.println("what position do you want to remove? Please insert a number from 0 to " + (content.size()-1) + ".");
        index = in.nextInt();

        if (index <= content.size()-1) {


            try {

                totalCost -= content.get(index).price;
                weight -= content.get(index).weight;

                content.remove(index);


                System.out.println("Fruit Removed");
            } catch (NumberFormatException e) {
                System.out.println("Fruit Not Removed");

            }

        } else System.out.println("Invalid position");


    }

    public static void updatePrices() {

        float newPrice;
        int menu = 0;


        while (menu != 5) {

            System.out.println("You want to update the price of which fruit?");
            System.out.println("1. Apple");
            System.out.println("2. Banana");
            System.out.println("3. Pear");
            System.out.println("4. Orange");
            System.out.println("5. Back");

            menu = in.nextInt();


            switch (menu) {
                case 1:
                    System.out.println("What is the new price for the apple?");

                    newPrice = in.nextFloat();

                    Apple.priceW = newPrice;

                    for (int i = 0; i < content.size(); i++) {
                        if (content.get(i) instanceof Apple) {


                            content.get(i).price = newPrice * content.get(i).weight;
                            break;
                        }
                    }

                    break;

                case 2:

                    System.out.println("What is the new price for the banana?");

                    newPrice = in.nextFloat();

                    Banana.priceW = newPrice;


                    for (int i = 0; i < content.size(); i++) {
                        if (content.get(i) instanceof Banana) {


                            content.get(i).price = newPrice * content.get(i).weight;
                            break;
                        }
                    }

                    break;

                case 3:

                    System.out.println("What is the new price for the Pear?");

                    newPrice = in.nextFloat();

                    Pear.priceW = newPrice;


                    for (int i = 0; i < content.size(); i++) {
                        if (content.get(i) instanceof Pear) {


                            content.get(i).price = newPrice * content.get(i).weight;
                            break;
                        }
                    }
                    break;

                case 4:

                    System.out.println("What is the new price for the Orange?");

                    newPrice = in.nextFloat();

                    Orange.priceW = newPrice;


                    for (int i = 0; i < content.size(); i++) {
                        if (content.get(i) instanceof Orange) {


                            content.get(i).price = newPrice * content.get(i).weight;
                            break;
                        }
                    }

                    break;

                case 5: break;

                default:
                    System.out.println("Invalid Option!");
            }


        }
    }

   public static void printBasket(){

       int numApples = 0, numBananas = 0, numPears = 0, numOranges = 0;

       for (int i = 0; i < content.size(); i++) {

           if (content.get(i) instanceof Apple) {

               numApples++;

           }else if (content.get(i) instanceof Banana) {

               numBananas++;

           }else if (content.get(i) instanceof Pear) {

               numPears++;

           }else if (content.get(i) instanceof Orange) {

               numOranges++;

           }

       }

      System.out.println("You have " + numBananas + " Bananas, " + numApples + " Apples, " + numPears + " Pears and " + numOranges + " Oranges.");
      System.out.println("Total weight: " + FruitBasket.weight);
      System.out.println("Total Cost: " + FruitBasket.totalCost);

   }





    public static void main(String[] arguments){
        Scanner scanner = new Scanner(System.in);
        int menu = 0;



        while( menu != 5 ){



            System.out.println("1. Add");
            System.out.println("2. Remove");
            System.out.println("3. Bite");
            System.out.println("4. Update Prices");
            System.out.println("5. Exit");

            menu = scanner.nextInt();

            switch (menu) {


                case 1:

                    FruitBasket.add();
                break;

                case 2:

                    remove();

                break;

                case 3:

                    bite();

                break;

                case 4:

                    updatePrices();

                break;

                case 5:  break;

                default: System.out.println("Invalid Option!");
            }
        }





    }


}