import java.util.HashMap;

public abstract class Service implements ITestable {

    protected HashMap<Hotel, HotelService> serviceAtHotels;
    protected String serviceName;

    public Service(String serviceName) {
        serviceAtHotels = new HashMap<Hotel, HotelService>();
        this.serviceName = serviceName;
    }

    public static boolean checkAllIntancesConstraints(Model model) {
        return true;
    }

    public void addHotel(Hotel h, HotelService hs) {
        serviceAtHotels.put(h, hs);
    }

    public HashMap<Hotel, HotelService> getServiceAtHotels() {
        return serviceAtHotels;
    }

    public String getServiceName() {
        return serviceName;
    }

    @Override
    public boolean checkConstraints() {
        return true;
    }
}
