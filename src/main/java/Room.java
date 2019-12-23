import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class Room implements ITestable {
    private RoomCategory roomCategory;
    private HashMap<Date, Booking> bookings;
    private int number;
    private Hotel hotel;


    public Room(int number) {
        this.number = number;
        bookings = new HashMap<Date, Booking>();
    }

    public static boolean checkAllIntancesConstraints(Model model) {
        return model.RoomAllInstances().stream().allMatch(Room::checkConstraints);
    }

    public void asignRoomCategory(RoomCategory roomCategory) {
        this.roomCategory = roomCategory;
    }

    public void addBooking(Booking booking, Date date) {
        bookings.put(date, booking);
    }

    public RoomCategory getRoomCategory() {
        return roomCategory;
    }

    public HashMap<Date, Booking> getBookings() {
        return bookings;
    }

    public int getNumber() {
        return number;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel h) {
        hotel = h;
    }

    @Override // Constraint 5 //
    public boolean checkConstraints() {
        return this.roomCategory.getType() != RoomCategory.RoomType.VIP || bookings.keySet().stream().map(d -> bookings.get(d).getServices()).flatMap(Collection::stream).allMatch(hs -> hs.getService() instanceof VipService);
    }

}
