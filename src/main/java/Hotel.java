import java.time.ZoneId;
import java.util.*;
import java.util.stream.IntStream;

public class Hotel implements ITestable {
    private String name;
    private HashMap<Client, ReservationSet> allReservation;
    private HashMap<Service, HotelService> services;
    private HashMap<Integer, Room> rooms;
    private String city;
    private Group group;
    private int rate;


    public Hotel(String city, String name, int rate) {
        this.city = city;
        this.name = name;
        this.rate = rate;
        rooms = new HashMap<Integer, Room>();
        allReservation = new HashMap<Client, ReservationSet>();
        services = new HashMap<Service, HotelService>();

    }

    public void addReservationSet(Client client, ReservationSet reservationSet) {
        allReservation.put(client, reservationSet);
    }

    public void addService(Service service, HotelService hotelService) {
        services.put(service, hotelService);
    }

    public void addRoom(int roomNumber, Room room) {
        rooms.put(roomNumber, room);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public HashMap<Client, ReservationSet> getAllReservation() {
        return allReservation;
    }

    public HashMap<Service, HotelService> getServices() {
        return services;
    }

    public int getRate() {
        return rate;
    }

    public static boolean checkAllIntancesConstraints(Model model) {
        return model.HotelAllInstances().stream().allMatch(Hotel::checkConstraints);
    }

    @Override // Constraint 12 //// Constraint 11 //// Constraint 6 //// Constraint 10//
    public boolean checkConstraints() {
        boolean constraint11 = services.keySet().stream().noneMatch(s1 -> services.keySet().stream().filter(s2 -> s1 != s2).anyMatch(s2 -> s1.serviceName.equals(s2.serviceName)));
        boolean constraint6 = !((int) this.rooms.keySet().stream().filter(num -> this.rooms.get(num).getRoomCategory().getType() == RoomCategory.RoomType.VIP).count() > (this.rooms.size() * 0.1));
        return constraint11 || constraint6 || constraint12() || constraint10();
    }

    private boolean constraint12() {
        HashMap<Integer, Integer> yearsHistory = new HashMap<>();
        this.services.keySet().forEach(s -> {
            HashSet<Booking> bookings = this.services.get(s).getGivenServices();
            bookings.stream().map(b -> b.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()).
                    forEach(lc -> yearsHistory.put(lc.getYear(), !yearsHistory.containsKey(lc.getYear()) ? this.services.get(s).getPrice() : yearsHistory.get(lc.getYear())+this.services.get(s).getPrice()));
        });
        Map<Integer, Integer> sorted = new TreeMap<>(yearsHistory);
        List<Integer> values = new ArrayList<>(sorted.values());
        return IntStream.range(0, values.size()-1).noneMatch(i -> values.get(i) > values.get(i+1));
    }

    //ממוצע הדירוג של מלונות 5 כוכבים הוא מעל 7.5‬
    private boolean constraint10() {
        float sumRanks = 0;
        float totalRes = 0;
        if (getRate() == 5)
            for(ReservationSet rs : allReservation.values())
                for(Reservation r : rs.getReservations())
                    if (r.getBookings().getReview() != null) {
                        sumRanks += r.getBookings().getReview().getRank();
                        totalRes++;
                    }
        return !(sumRanks / totalRes < 7.5);
    }
}
