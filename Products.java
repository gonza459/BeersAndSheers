import java.util.*;

public class Products {


    private String productName;
    private int productID, productPrice;

    Random rand = new Random();

    Products(){
        int[] productID = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        String[] productName = {"Men's Shampoo"};

        int[] prices = {15};

    }

    int getServiceID(){
        int[] ServiceID = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        return ServiceID[rand.nextInt(ServiceID.length)];
    }

    String getName(){
        String[] products = {"Man's Haircut"};
        productName =  products[rand.nextInt(products.length)];
        return productName;
    }

    int getPrice() {
        int[] prices = {15};
        productPrice = prices[rand.nextInt(prices.length)];
        return productPrice;
    }


}
