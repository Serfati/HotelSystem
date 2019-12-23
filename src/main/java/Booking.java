import java.util.ArrayList;
import java.util.Date;

public class Booking implements ITestable {
    private Date date;
    private Room room;
    private ArrayList<HotelService> services;
    private Reservation reservation;
    private Review review;


    public Booking(Date a_date, Room a_room) {
        date = a_date;
        room = a_room;
        services = new ArrayList<HotelService>();
    }

    public static boolean checkAllIntancesConstraints(Model model) {
        return model.BookingAllInstances().stream().allMatch(Booking::checkConstraints);
    }

    public void addService(HotelService s) {
        services.add(s);
    }

    public void addReview(Review a_review) {
        review = a_review;
    }

    public void addReservation(Reservation r) {
        reservation = r;
    }


    // getters

    public void assignRoom(Room room) {
        this.room = room;
    }

    public Date getDate() {
        return date;
    }

    public Room getRoom() {
        return room;
    }

    public ArrayList<HotelService> getServices() {
        return services;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public Review getReview() {
        return review;
    }

    @Override // Constraint 3//// Constraint 9//// Constraint 8//
    public boolean checkConstraints() {
        boolean constraint3 = this.room != null && this.room.getHotel().getName().equals(this.reservation.getReservationSet().getHotel().getName());
        boolean constraint9 = this.services.stream().anyMatch(hs -> hs.getService() instanceof VipService) && review != null;
        return constraint3 || constraint9 || constraint8();
    }

    private boolean constraint8() {
        if (this.room != null) if (this.room.getRoomCategory().getType() == RoomCategory.RoomType.VIP)
            return this.reservation.getRoomCategory().getType() == RoomCategory.RoomType.VIP;
        else if (this.room.getRoomCategory().getType() == RoomCategory.RoomType.SUITE)
            return this.reservation.getRoomCategory().getType() != RoomCategory.RoomType.BASIC;
        return true;
    }
}
