package lab5;

/**
 * Created by OzzY on 9/23/2014.
 */
public class Pear extends Fruit {

   float maxWeight = 0.75f;
   float  minWeight = 0.5f;
   boolean peel = false;
    static float priceW = 0.10f;
    
    public Pear(){

        super();
        price = weight * priceW;
    }

    public static float getPriceW() {
        return priceW;
    }

    public static void setPriceW(float priceW) {
        Apple.priceW = priceW;
    }
}