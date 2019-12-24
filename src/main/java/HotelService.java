import java.util.HashSet;

public class HotelService implements ITestable {
    private Hotel hotel;
    private Service service;
    private int price;
    private int quality;
    private HashSet<Booking> givenServices;

    public HotelService(int price, int quality) {
        givenServices = new HashSet<Booking>();
        this.price = price;
        this.quality = quality;
    }

    public static boolean checkAllIntancesConstraints(Model model) {
        return model.HotelServiceAllInstances().stream().allMatch(HotelService::checkConstraints);
    }

    public void assignService(Service service) {
        this.service = service;
    }

    public void addBooking(Booking booking) {
        givenServices.add(booking);
    }


    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Service getService() {
        return service;
    }

    public int getPrice() {
        return price;
    }

    public int getQuality() {
        return quality;
    }

    public HashSet<Booking> getGivenServices() {
        return givenServices;
    }

    @Override
    public boolean checkConstraints() {
        return true;
    }
}
