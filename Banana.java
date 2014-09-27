package lab5;

/**
 * Created by OzzY on 9/23/2014.
 */
public class Banana extends Fruit {

    float maxWeight = 0.75f;
    float minWeight = 0.25f;
    boolean peel = true;
    static float priceW = 0.10f;


    public Banana() {
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