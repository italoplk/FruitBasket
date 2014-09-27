package lab5;

/**
 * Created by OzzY on 9/23/2014.
 */
public class Fruit {

    float maxWeight = 0.75f;
    float minWeight = 0.25f;
    static float weight;
    boolean peel = true;
//    static float priceW = 0.10f;
    float price;
    boolean bitten = false;


    public Fruit(){


            weight = (float) (Math.random() * maxWeight - minWeight) + minWeight;

    }


    public void takeBite(){

        if (weight > 0.030 && bitten == false){

            this.weight -= 0.03;
            this.bitten = true;

            System.out.println("Congratulations!! You have bited this fruit!");

        }else System.out.println("Sorry you can't bite this fruit! ");



    }




}

