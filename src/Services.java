import java.util.*;

public class Services {

    private String ServiceName, ServiceMaterials, ServiceDuration;
    private int ServiceID, ServicePrice;

    Random rand = new Random();

    Services(){

    }

    int getServiceID(){
        int[] ServiceID = {1, 2, 3, 4, 5, 6, 7, 9};

        return ServiceID[rand.nextInt(ServiceID.length)];
    }

    String getName(){
        String[] services = {"Men's Haircut", "Haircut & Beard Trim", "Kid's Haircut", "Head Shave", "Hot Towel Shave"};
        ServiceName =  services[rand.nextInt(services.length)];
        return ServiceName;
    }

    String getMaterials(){
        String[] materials = {"Clippers & Scissors", "Clippers & Razor", "Clippers & Scissors", "Razor"};
        ServiceMaterials = materials[rand.nextInt(materials.length)];
        return ServiceMaterials;
    }

    int getPrice(){
        int[] prices = {25, 30, 15, 20, 20};
        ServicePrice = prices[rand.nextInt(prices.length)];
        return ServicePrice;
    }

    String getDuration(){
        String[] durations = {"35 mins", "45 mins", "15 mins", "20 mins", "30 mins"};
        ServiceDuration = durations[rand.nextInt(durations.length)];
        return ServiceDuration;
    }

    void getFullService(){

    }


}
