import java.util.*;

public class Services {

    private String ServiceName, ServiceMaterials, ServiceDuration;
    private int ServiceID, ServicePrice;

    Random rand = new Random();

    Services(){
        int[] ServiceID = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        String[] services = {"Men's Haircut"};

        String[] materials = {"Scissors"};

        int[] prices = {15};

        String[] durations = {"20 min"};

    }

    int getServiceID(){
        int[] ServiceID = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        return ServiceID[rand.nextInt(ServiceID.length)];
    }

    String getName(){
        String[] services = {"Man's Haircut"};
        ServiceName =  services[rand.nextInt(services.length)];
        return ServiceName;
    }

    String getMaterials(){
        String[] materials = {"Scissors"};
        ServiceMaterials = materials[rand.nextInt(materials.length)];
        return ServiceMaterials;
    }

    int getPrice(){
        int[] prices = {15};
        ServicePrice = prices[rand.nextInt(prices.length)];
        return ServicePrice;
    }

    String getDuration(){
        String[] durations = {"20 min"};
        ServiceDuration = durations[rand.nextInt(durations.length)];
        return ServiceDuration;
    }


}
