import java.util.ArrayList;
import java.util.HashMap;


public class Client implements ITestable {
    private HashMap<Hotel, ReservationSet> reservationsHistory;
    private int id;
    private int age;
    private String name;
    private String city;

    public Client(int a_id, int a_age, String a_name, String a_city) {
        reservationsHistory = new HashMap<Hotel, ReservationSet>();
        id = a_id;
        age = a_age;
        city = a_city;
        name = a_name;
    }

    public static boolean checkAllIntancesConstraints(Model model) {
        return model.ClientAllInstances().stream().allMatch(Client::checkConstraints);
    }

    public HashMap<Hotel, ReservationSet> getReservationsHistory() {
        return reservationsHistory;
    }

    // getters

    public void addReservationSet(Hotel hotel, ReservationSet reset) {
        reservationsHistory.put(hotel, reset);
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    @Override //Constraint 2//
    public boolean checkConstraints() {
        boolean vipRoom = false;
        ArrayList<Reservation> reservations;
        for(Hotel h : reservationsHistory.keySet()) {
            reservations = reservationsHistory.get(h).getReservations();
            if (reservations.size() >= 5) {
                if (reservations.stream().anyMatch(r -> r.getRoomCategory().getType() == RoomCategory.RoomType.VIP))
                    vipRoom = true;
                if (!vipRoom) return false;
            }
        }
        return true;
    }
}
