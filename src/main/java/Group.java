import java.util.HashSet;

public class Group implements ITestable {
    HashSet<Hotel> hotels;
    private int groupId;

    public Group(int id) {
        hotels = new HashSet<>();
        groupId = id;
    }

    public static boolean checkAllIntancesConstraints(Model model) {
        return true;
    }

    //getters

    public void addHotelToGroup(Hotel hotel) {
        hotels.add(hotel);
    }

    public int getGroupId() {
        return groupId;
    }

    public HashSet<Hotel> getHotels() {
        return hotels;
    }

    @Override // Constraint 1 //// Constraint 4 //
    public boolean checkConstraints() {
        boolean constraint1 = this.hotels.stream().noneMatch(hotel1 -> this.hotels.stream().anyMatch(hotel2 -> (!hotel1.getName().equalsIgnoreCase(hotel2.getName())) && hotel1.getGroup().getGroupId() == hotel2.getGroup().getGroupId() && hotel1.getCity().equalsIgnoreCase(hotel2.getCity())));
        boolean constraint4 = this.hotels.stream().noneMatch(hotel1 -> this.hotels.stream().map(hotel2 -> hotel2.getServices().keySet()).anyMatch(h2Service -> !(hotel1.getServices().keySet().containsAll(h2Service) && h2Service.containsAll(hotel1.getServices().keySet()))));
        return constraint1 && constraint4;
    }


}
