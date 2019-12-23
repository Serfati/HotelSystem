import java.util.HashSet;

public class RoomCategory implements ITestable {
    HashSet<Room> rooms;
    HashSet<Reservation> reservations;
    private int price;
    private RoomType type;

    public RoomCategory(int price, RoomType rType) {
        rooms = new HashSet<Room>();
        reservations = new HashSet<Reservation>();
        type = rType;
    }

    public static boolean checkAllIntancesConstraints(Model model) {
        return true;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public HashSet<Room> getRooms() {
        return rooms;
    }

    public int getPrice() {
        return price;
    }

    public RoomType getType() {
        return type;
    }

    @Override
    public boolean checkConstraints() {
        return true;
    }

    enum RoomType {
        BASIC, SUITE, VIP;
    }
}
