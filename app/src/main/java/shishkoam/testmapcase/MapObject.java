package shishkoam.testmapcase;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by ав on 12.06.2016
 */
public class MapObject {
    LatLng position;
    String address;
    String name;
    double distance;
    double price;
    int time;

    public MapObject(LatLng position, String address, String name, double distance, double price, int time) {
        this.position = position;
        this.address = address;
        this.name = name;
        this.distance = distance;
        this.price = price;
        this.time = time;
    }

    public LatLng getPosition() {
        return position;
    }

    public int getTime() {
        return time;
    }

    public double getPrice() {
        return price;
    }

    public double getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
