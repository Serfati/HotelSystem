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
        boolean constraint3 = this.room != null && this.reservation != null && this.room.getHotel() != null && this.room.getHotel().equals(this.reservation.getReservationSet().getHotel());
        boolean constraint9 = this.services.stream().anyMatch(hs -> hs.getService() instanceof VipService) && review != null;
        boolean constraint13 = services.stream().allMatch(hs -> room.getHotel().getServices().containsValue(hs));
        return constraint3 && constraint8() && constraint9 && constraint13;
    }

    private boolean constraint8() {
        if (this.reservation.getRoomCategory().getType() == RoomCategory.RoomType.VIP)
            return this.room.getRoomCategory().getType() == RoomCategory.RoomType.VIP;
        if (this.reservation.getRoomCategory().getType() == RoomCategory.RoomType.SUITE)
            return this.room.getRoomCategory().getType() != RoomCategory.RoomType.BASIC;
        return true;
    }
}
