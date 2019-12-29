import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class Model {
    HashSet<ITestable> allObjects;


    public Model() {
        allObjects = new HashSet<ITestable>();
    }

    public static Date getDateFromString(String dateString) {
        Date date = null;
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            date = simpleDateFormat.parse(dateString);
        } catch(ParseException pe) {
            System.out.println("Exception: Wrong date format.");
        }
        return date;
    }

    public void addObjectToModel(ITestable object) {
        allObjects.add(object);
    }

    public void create_link_group_hotel(Hotel hotel, Group group) {
        hotel.setGroup(group);
        group.addHotelToGroup(hotel);
    }

    public void create_link_client_hotel_reservationSet(Client client, Hotel hotel, ReservationSet reservationSet) {
        hotel.addReservationSet(client, reservationSet);
        client.addReservationSet(hotel, reservationSet);
        reservationSet.setClient(client);
        reservationSet.setHotel(hotel);
    }

    public void create_link_reservationSet_reservation(ReservationSet reservationSet, Reservation reservation) {
        reservationSet.addReservation(reservation);
        reservation.setReservationSet(reservationSet);
    }

    public void create_link_reservation_roomCategory(Reservation reservation, RoomCategory roomCategory) {
        reservation.addRoomCategory(roomCategory);
        roomCategory.addReservation(reservation);
    }

    public void create_link_reservation_booking(Booking booking, Reservation reservation) {
        booking.addReservation(reservation);
        reservation.addBooking(booking);
    }

    public void create_link_room_Booking(Room room, Booking booking) {
        booking.assignRoom(room);
        room.addBooking(booking, booking.getDate());
    }

    public void create_link_room_roomCategory(Room room, RoomCategory roomCategory) {
        roomCategory.addRoom(room);
        room.asignRoomCategory(roomCategory);
    }

    public void create_link_hotel_room(Room room, Hotel hotel) {
        hotel.addRoom(room.getNumber(), room);
        room.setHotel(hotel);
    }

    public void create_link_booking_review(Booking booking, Review review) {
        booking.addReview(review);
        review.addBooking(booking);
    }

    public void create_link_hotel_service_hotelService(Hotel hotel, Service service, HotelService hotelService) {
        hotel.addService(service, hotelService);
        service.addHotel(hotel, hotelService);
        hotelService.setHotel(hotel);
        hotelService.assignService(service);
    }

    public void create_link_hotelService_booking(HotelService hotelService, Booking booking) {
        hotelService.addBooking(booking);
        booking.addService(hotelService);
    }

    public boolean checkModelConstraints() {
        for(ITestable object : allObjects) {
            if (object.checkConstraints() == false) {
                System.out.println(object);
                return false;
            }
        }
        // check all instances constraints of each type
        if (Booking.checkAllIntancesConstraints(this) == false)
            return false;
        if (Client.checkAllIntancesConstraints(this) == false)
            return false;
        if (Group.checkAllIntancesConstraints(this) == false)
            return false;
        if (Hotel.checkAllIntancesConstraints(this) == false)
            return false;
        if (HotelService.checkAllIntancesConstraints(this) == false)
            return false;
        if (Reservation.checkAllIntancesConstraints(this) == false)
            return false;
        if (ReservationSet.checkAllIntancesConstraints(this) == false)
            return false;
        if (Review.checkAllIntancesConstraints(this) == false)
            return false;
        if (Room.checkAllIntancesConstraints(this) == false)
            return false;
        if (RoomCategory.checkAllIntancesConstraints(this) == false)
            return false;
        if (Service.checkAllIntancesConstraints(this) == false)
            return false;
        if (CommunityService.checkAllIntancesConstraints(this) == false)
            return false;
        if (RegularService.checkAllIntancesConstraints(this) == false)
            return false;
        if (VipService.checkAllIntancesConstraints(this) == false)
            return false;
        return Group.checkAllIntancesConstraints(this) != false;
    }

    public HashSet<Hotel> HotelAllInstances() {
        HashSet<Hotel> ans = new HashSet<Hotel>();
        for(ITestable object : allObjects) {
            if (object instanceof Hotel)
                ans.add((Hotel) object);
        }
        return ans;
    }

    public HashSet<Group> GroupAllInstances() {
        HashSet<Group> ans = new HashSet<Group>();
        for(ITestable object : allObjects) {
            if (object instanceof Group)
                ans.add((Group) object);
        }
        return ans;
    }

    public HashSet<Client> ClientAllInstances() {
        HashSet<Client> ans = new HashSet<Client>();
        for(ITestable object : allObjects) {
            if (object instanceof Client)
                ans.add((Client) object);
        }
        return ans;
    }

    public HashSet<ReservationSet> ReservationSetAllInstances() {
        HashSet<ReservationSet> ans = new HashSet<ReservationSet>();
        for(ITestable object : allObjects) {
            if (object instanceof ReservationSet)
                ans.add((ReservationSet) object);
        }
        return ans;
    }

    public HashSet<Reservation> ReservationAllInstances() {
        HashSet<Reservation> ans = new HashSet<Reservation>();
        for(ITestable object : allObjects) {
            if (object instanceof Reservation)
                ans.add((Reservation) object);
        }
        return ans;
    }

    public HashSet<RoomCategory> RoomCategoryAllInstances() {
        HashSet<RoomCategory> ans = new HashSet<RoomCategory>();
        for(ITestable object : allObjects) {
            if (object instanceof RoomCategory)
                ans.add((RoomCategory) object);
        }
        return ans;
    }

    public HashSet<Booking> BookingAllInstances() {
        HashSet<Booking> ans = new HashSet<Booking>();
        for(ITestable object : allObjects) {
            if (object instanceof Booking)
                ans.add((Booking) object);
        }
        return ans;
    }

    public HashSet<Room> RoomAllInstances() {
        HashSet<Room> ans = new HashSet<Room>();
        for(ITestable object : allObjects) {
            if (object instanceof Room)
                ans.add((Room) object);
        }
        return ans;
    }

    public HashSet<Review> ReviewAllInstances() {
        HashSet<Review> ans = new HashSet<Review>();
        for(ITestable object : allObjects) {
            if (object instanceof Review)
                ans.add((Review) object);
        }
        return ans;
    }

    public HashSet<HotelService> HotelServiceAllInstances() {
        HashSet<HotelService> ans = new HashSet<HotelService>();
        for(ITestable object : allObjects) {
            if (object instanceof HotelService)
                ans.add((HotelService) object);
        }
        return ans;
    }

    public HashSet<CommunityService> communityServiceServiceAllInstances() {
        HashSet<CommunityService> ans = new HashSet<CommunityService>();
        for(ITestable object : allObjects) {
            if (object instanceof CommunityService)
                ans.add((CommunityService) object);
        }
        return ans;
    }

    public HashSet<VipService> vipServiceServiceAllInstances() {
        HashSet<VipService> ans = new HashSet<VipService>();
        for(ITestable object : allObjects) {
            if (object instanceof VipService)
                ans.add((VipService) object);
        }
        return ans;
    }

    public HashSet<RegularService> regularServiceServiceAllInstances() {
        HashSet<RegularService> ans = new HashSet<RegularService>();
        for(ITestable object : allObjects) {
            if (object instanceof RegularService)
                ans.add((RegularService) object);
        }
        return ans;
    }

}