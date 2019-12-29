import java.util.ArrayList;

public class ReservationSet implements ITestable {
    private Client client;
    private Hotel hotel;
    private ArrayList<Reservation> reservations;

    public ReservationSet() {
        reservations = new ArrayList<Reservation>();
    }

    public static boolean checkAllIntancesConstraints(Model model) {
        return model.ReservationSetAllInstances().stream().allMatch(ReservationSet::checkConstraints);
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    @Override // Constraint 7 ////Constraint 2//
    public boolean checkConstraints() {
        boolean constraint2 = reservations.size() < 5 || reservations.stream().anyMatch(reservation -> reservation.getBookings().getRoom().getRoomCategory().getType().equals(RoomCategory.RoomType.VIP));
        return constraint2 && !this.hotel.getCity().equalsIgnoreCase("LAS VEGAS") || this.client.getAge() >= 21;
    }
}
