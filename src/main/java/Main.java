import java.util.Date;

public class Main {
    public static void main(String[] args) {
//        test1();
//        System.out.println("===========2===========");
//        test2();
//        System.out.println("=========3=============");
//        test3();
//        System.out.println("=========7=============");
//        test7();
//        System.out.println("=========8=============");
//        test8();
//        System.out.println("=========9============");
//        test9();
        System.out.println("=========10===========");
        test10();
//        System.out.println("=========11===========");
//        test11();
//        System.out.println("========12=============");
//        test12();
//        System.out.println("==========13==========");
//        test13();
        // test0();

    }

    public static void test0() {
        Model m = new Model();
        Group g1 = new Group(1);
        Group g2 = new Group(2);

        Hotel h1 = new Hotel("las vegas", "hotel1", 5);
        Hotel h2 = new Hotel("city2", "hotel2", 4);
        m.addObjectToModel(g1);
        m.addObjectToModel(g2);

        m.addObjectToModel(h1);
        m.addObjectToModel(h2);
        m.create_link_group_hotel(h1, g1);
        m.create_link_group_hotel(h2, g1);

        Client c1 = new Client(1, 21, "client1", "city3");
        m.addObjectToModel(c1);

        ReservationSet s1 = new ReservationSet();
        m.addObjectToModel(s1);
        m.create_link_client_hotel_reservationSet(c1, h1, s1);

        Room room1 = new Room(10);
        m.addObjectToModel(room1);
        m.create_link_hotel_room(room1, h1);

        Room room2 = new Room(20);
        m.addObjectToModel(room2);
        m.create_link_hotel_room(room2, h1);


        RoomCategory rc2 = new RoomCategory(200, RoomCategory.RoomType.VIP);
        RoomCategory rc1 = new RoomCategory(200, RoomCategory.RoomType.BASIC);
        m.addObjectToModel(rc1);
        m.addObjectToModel(rc2);

        m.create_link_room_roomCategory(room1, rc1);
        m.create_link_room_roomCategory(room2, rc2);

        for(int i = 0; i < 8; i++) {
            Room room3 = new Room(i);
            m.addObjectToModel(room3);
            m.create_link_hotel_room(room3, h1);
            m.create_link_room_roomCategory(room3, rc1);

        }

        Date orDate = Model.getDateFromString("25-12-2019");
        Date reqDate = Model.getDateFromString("25-12-2020");
        Reservation res1 = new Reservation(orDate, reqDate, 1);
        m.addObjectToModel(res1);
        m.create_link_reservation_roomCategory(res1, rc1);
        m.create_link_reservationSet_reservation(s1, res1);

        Booking b1 = new Booking(reqDate, room1);
        m.addObjectToModel(b1);
        m.create_link_reservation_booking(b1, res1);
        m.create_link_room_Booking(room1, b1);

        Date reqDate2 = Model.getDateFromString("25-12-2021");
        Reservation res2 = new Reservation(orDate, reqDate2, 2);
        m.addObjectToModel(res2);
        m.create_link_reservation_roomCategory(res2, rc1);
        m.create_link_reservationSet_reservation(s1, res2);

        Booking b2 = new Booking(reqDate2, room2);
        m.addObjectToModel(b2);
        m.create_link_reservation_booking(b2, res2);
        m.create_link_room_Booking(room2, b2);

        Review rev1 = new Review(10, "very good", reqDate);
        m.addObjectToModel(rev1);
        m.create_link_booking_review(b2, rev1);


        Date reqDate3 = Model.getDateFromString("25-12-2022");
        Reservation res3 = new Reservation(orDate, reqDate3, 3);
        m.addObjectToModel(res3);
        m.create_link_reservation_roomCategory(res3, rc1);
        m.create_link_reservationSet_reservation(s1, res3);

        Booking b3 = new Booking(reqDate3, room1);
        m.addObjectToModel(b3);
        m.create_link_reservation_booking(b3, res3);
        m.create_link_room_Booking(room1, b3);

        Review rev2 = new Review(6, "good", reqDate);
        m.addObjectToModel(rev2);
        m.create_link_booking_review(b3, rev2);

        Date reqDate4 = Model.getDateFromString("25-12-2023");
        Reservation res4 = new Reservation(orDate, reqDate4, 4);
        m.addObjectToModel(res4);
        m.create_link_reservation_roomCategory(res4, rc1);
        m.create_link_reservationSet_reservation(s1, res4);

        Booking b4 = new Booking(reqDate4, room1);
        m.addObjectToModel(b4);
        m.create_link_reservation_booking(b4, res4);
        m.create_link_room_Booking(room1, b4);

        Date reqDate5 = Model.getDateFromString("25-12-2024");
        Reservation res5 = new Reservation(orDate, reqDate5, 5);
        m.addObjectToModel(res5);
        m.create_link_reservation_roomCategory(res5, rc1);
        m.create_link_reservationSet_reservation(s1, res5);

        Booking b5 = new Booking(reqDate5, room2);
        m.addObjectToModel(b5);
        m.create_link_reservation_booking(b5, res5);
        m.create_link_room_Booking(room2, b5);

        VipService cs1 = new VipService("service1");
        CommunityService cs2 = new CommunityService("service2");

        m.addObjectToModel(cs1);
        m.addObjectToModel(cs2);

        HotelService hs1 = new HotelService(200, 2);
        m.addObjectToModel(hs1);
        HotelService hs2 = new HotelService(203, 2);
        m.addObjectToModel(hs2);
        HotelService hs3 = new HotelService(203, 2);
        m.addObjectToModel(hs3);
        HotelService hs4 = new HotelService(200, 2);
        m.addObjectToModel(hs4);
        m.create_link_hotel_service_hotelService(h1, cs1, hs1);
        m.create_link_hotel_service_hotelService(h2, cs1, hs2);
        m.create_link_hotel_service_hotelService(h1, cs2, hs3);
        m.create_link_hotel_service_hotelService(h2, cs2, hs4);

        m.create_link_hotelService_booking(hs1, b2);
        m.create_link_hotelService_booking(hs3, b3);
        m.create_link_hotelService_booking(hs3, b3);

        System.out.println(m.checkModelConstraints()+" should be =true");
    }


    public static void test1() {
        Model m = new Model();

        // True case
        Group group1 = new Group(1);
        Group group2 = new Group(2);
        Hotel hotel1 = new Hotel("Las Vegas", "Paris", 4);
        Hotel hotel2 = new Hotel("Las Vegas", "Barcelona", 4);

        m.addObjectToModel(group1);
        m.addObjectToModel(group2);
        m.addObjectToModel(hotel1);
        m.addObjectToModel(hotel2);

        m.create_link_group_hotel(hotel1, group1);
        m.create_link_group_hotel(hotel2, group2);

        System.out.println("Correct Answer is TRUE: "+m.checkModelConstraints()); // True expected

        // =======================================================

        // False case
        Model m2 = new Model();

        Group group3 = new Group(3);
        Hotel hotel3 = new Hotel("Las Vegas", "Paris", 4);
        Hotel hotel4 = new Hotel("Las Vegas", "VegasLand", 4);

        m2.addObjectToModel(group3);
        m2.addObjectToModel(hotel3);
        m2.addObjectToModel(hotel4);

        m2.create_link_group_hotel(hotel1, group3);
        m2.create_link_group_hotel(hotel2, group3);

        System.out.println("Correct Answer is FALSE: "+m2.checkModelConstraints()); // False expected
    }

    public static void test2() {
        Model m = new Model();

        Client client = new Client(1, 20, "Dolev", "Tel Aviv");
        Hotel hotel = new Hotel("Tel Aviv", "Paris", 3);
        ReservationSet reservationSet = new ReservationSet();
        Reservation reservation1 = new Reservation(Model.getDateFromString("25-12-2019"), Model.getDateFromString("26-12-2019"), 101);
        Reservation reservation2 = new Reservation(Model.getDateFromString("10-12-2019"), Model.getDateFromString("11-12-2019"), 102);
        Reservation reservation3 = new Reservation(Model.getDateFromString("13-12-2019"), Model.getDateFromString("14-12-2019"), 103);
        Reservation reservation4 = new Reservation(Model.getDateFromString("01-10-2019"), Model.getDateFromString("03-10-2019"), 105);
        Reservation reservation5 = new Reservation(Model.getDateFromString("11-11-2019"), Model.getDateFromString("14-11-2019"), 106);

        RoomCategory roomCategory1 = new RoomCategory(200, RoomCategory.RoomType.BASIC);
        RoomCategory roomCategory2 = new RoomCategory(400, RoomCategory.RoomType.VIP);


        m.addObjectToModel(client);
        m.addObjectToModel(hotel);
        m.addObjectToModel(reservationSet);
        m.create_link_client_hotel_reservationSet(client, hotel, reservationSet);
        m.create_link_reservationSet_reservation(reservationSet, reservation1);
        m.create_link_reservationSet_reservation(reservationSet, reservation2);
        m.create_link_reservationSet_reservation(reservationSet, reservation3);
        m.create_link_reservationSet_reservation(reservationSet, reservation4);
        m.create_link_reservationSet_reservation(reservationSet, reservation5);
        m.create_link_reservation_roomCategory(reservation1, roomCategory1);
        m.create_link_reservation_roomCategory(reservation2, roomCategory1);
        m.create_link_reservation_roomCategory(reservation3, roomCategory1);
        m.create_link_reservation_roomCategory(reservation4, roomCategory1);
        m.create_link_reservation_roomCategory(reservation5, roomCategory2);


        System.out.println("Correct Answer is TRUE: "+m.checkModelConstraints()); // true

        // ====================================

        Model m2 = new Model();

        Client client1 = new Client(2, 20, "Dolev", "Tel Aviv");
        Hotel hotel1 = new Hotel("Beer Sheva", "Paris", 3);
        ReservationSet reservationSet1 = new ReservationSet();
        Reservation reservation6 = new Reservation(Model.getDateFromString("25-12-2019"), Model.getDateFromString("26-12-2019"), 101);
        Reservation reservation7 = new Reservation(Model.getDateFromString("10-12-2019"), Model.getDateFromString("11-12-2019"), 102);
        Reservation reservation8 = new Reservation(Model.getDateFromString("13-12-2019"), Model.getDateFromString("14-12-2019"), 103);
        Reservation reservation9 = new Reservation(Model.getDateFromString("01-10-2019"), Model.getDateFromString("03-10-2019"), 105);
        Reservation reservation10 = new Reservation(Model.getDateFromString("11-11-2019"), Model.getDateFromString("14-11-2019"), 106);

        RoomCategory roomCategory3 = new RoomCategory(200, RoomCategory.RoomType.BASIC);

        m2.addObjectToModel(client1);
        m2.addObjectToModel(hotel1);
        m2.addObjectToModel(reservationSet1);
        m2.create_link_client_hotel_reservationSet(client1, hotel1, reservationSet1);
        m2.create_link_reservationSet_reservation(reservationSet1, reservation6);
        m2.create_link_reservationSet_reservation(reservationSet1, reservation7);
        m2.create_link_reservationSet_reservation(reservationSet1, reservation8);
        m2.create_link_reservationSet_reservation(reservationSet1, reservation9);
        m2.create_link_reservationSet_reservation(reservationSet1, reservation10);
        m2.create_link_reservation_roomCategory(reservation6, roomCategory3);
        m2.create_link_reservation_roomCategory(reservation7, roomCategory3);
        m2.create_link_reservation_roomCategory(reservation8, roomCategory3);
        m2.create_link_reservation_roomCategory(reservation9, roomCategory3);
        m2.create_link_reservation_roomCategory(reservation10, roomCategory3);

        System.out.println("Correct Answer is FALSE: "+m2.checkModelConstraints()); // false
    }

    public static void test3() {
        Model m = new Model();

        Client client1 = new Client(1, 20, "Dolev", "Tel Aviv");
        Hotel hotel1 = new Hotel("Tel Aviv", "Paris", 4);
        Room room1 = new Room(404);
        ReservationSet reservationSet1 = new ReservationSet();
        Reservation reservation1 = new Reservation(Model.getDateFromString("25-12-2019"), Model.getDateFromString("01-01-2020"), 100);
        RoomCategory roomCategory1 = new RoomCategory(10, RoomCategory.RoomType.SUITE);
        Booking booking = new Booking(Model.getDateFromString("01-01-2020"), room1);

        m.addObjectToModel(client1);
        m.addObjectToModel(hotel1);
        m.addObjectToModel(reservationSet1);
        m.addObjectToModel(reservation1);
        m.addObjectToModel(room1);
        m.addObjectToModel(booking);
        m.addObjectToModel(roomCategory1);

        m.create_link_client_hotel_reservationSet(client1, hotel1, reservationSet1);
        m.create_link_reservationSet_reservation(reservationSet1, reservation1);
        m.create_link_hotel_room(room1, hotel1);
        m.create_link_reservation_booking(booking, reservation1);
        m.create_link_room_Booking(room1, booking);
        m.create_link_reservation_roomCategory(reservation1, roomCategory1);
        m.create_link_room_roomCategory(room1, roomCategory1);

        System.out.println("Correct Answer is TRUE: "+m.checkModelConstraints()); // true

        // ===================================================

        Model m2 = new Model();

        Client client2 = new Client(3, 20, "Dolev", "Tel Aviv");
        Hotel hotel2 = new Hotel("Beer Sheva", "Paris", 4);
        Hotel hotel3 = new Hotel("Beer Sheva", "Barcelona", 4);
        Room room2 = new Room(404);
        Room room3 = new Room(404);
        ReservationSet reservationSet2 = new ReservationSet();
        Reservation reservation2 = new Reservation(Model.getDateFromString("25-12-2019"), Model.getDateFromString("01-01-2020"), 100);
        RoomCategory roomCategory = new RoomCategory(10, RoomCategory.RoomType.BASIC);
        Booking booking2 = new Booking(Model.getDateFromString("01-01-2020"), room1);

        m2.addObjectToModel(client2);
        m2.addObjectToModel(hotel2);
        m2.addObjectToModel(hotel3);
        m2.addObjectToModel(reservationSet2);
        m2.addObjectToModel(reservation2);
        m2.addObjectToModel(room2);
        m2.addObjectToModel(room3);
        m2.addObjectToModel(booking2);
        m2.addObjectToModel(roomCategory);

        //res for room2 in hotel2 book for room3 in hotel3
        m2.create_link_client_hotel_reservationSet(client2, hotel2, reservationSet2); // reservation for room2 in hotel2
        m2.create_link_reservationSet_reservation(reservationSet2, reservation2);
        m2.create_link_reservation_roomCategory(reservation2, roomCategory);
        m2.create_link_hotel_room(room2, hotel2); //room2 in hotel2
        m2.create_link_hotel_room(room3, hotel3); //room3 in hotel3
        m2.create_link_reservation_booking(booking2, reservation2);
        m2.create_link_room_Booking(room3, booking2); //room3 in hotel3
        m2.create_link_room_roomCategory(room2, roomCategory);
        m2.create_link_room_roomCategory(room3, roomCategory);

        System.out.println("Correct Answer is FALSE: "+m2.checkModelConstraints()); // false
    }

    public static void test7() {
        Model m = new Model();

        Client client1 = new Client(1, 20, "Dolev", "Tel Aviv");
        Hotel hotel1 = new Hotel("Las Vegas", "Paris", 4);
        Room room1 = new Room(404);
        ReservationSet reservationSet1 = new ReservationSet();
        Reservation reservation1 = new Reservation(Model.getDateFromString("25-12-2019"), Model.getDateFromString("01-01-2020"), 100);
        RoomCategory roomCategory1 = new RoomCategory(200, RoomCategory.RoomType.BASIC);

        m.addObjectToModel(client1);
        m.addObjectToModel(hotel1);
        m.addObjectToModel(reservationSet1);
        m.addObjectToModel(reservation1);
        m.addObjectToModel(room1);

        m.create_link_client_hotel_reservationSet(client1, hotel1, reservationSet1);
        m.create_link_reservationSet_reservation(reservationSet1, reservation1);
        m.create_link_reservation_roomCategory(reservation1, roomCategory1);
        m.create_link_hotel_room(room1, hotel1);
        m.create_link_room_roomCategory(room1, roomCategory1);

        System.out.println("Correct Answer is FALSE: "+m.checkModelConstraints()); // false

        // =======================================================

        Model m2 = new Model();

        Client client2 = new Client(2, 21, "Dolev", "Tel Aviv");
        Hotel hotel2 = new Hotel("Las Vegas", "Paris", 4);
        Room room2 = new Room(405);
        ReservationSet reservationSet2 = new ReservationSet();
        Reservation reservation2 = new Reservation(Model.getDateFromString("25-12-2019"), Model.getDateFromString("01-01-2020"), 101);
        RoomCategory roomCategory2 = new RoomCategory(220, RoomCategory.RoomType.BASIC);

        m2.addObjectToModel(client2);
        m2.addObjectToModel(hotel2);
        m2.addObjectToModel(reservationSet2);
        m2.addObjectToModel(reservation2);
        m2.addObjectToModel(room2);

        m2.create_link_client_hotel_reservationSet(client2, hotel2, reservationSet2);
        m2.create_link_reservationSet_reservation(reservationSet2, reservation2);
        m2.create_link_reservation_roomCategory(reservation2, roomCategory2);
        m2.create_link_hotel_room(room2, hotel2);
        m2.create_link_room_roomCategory(room2, roomCategory2);

        System.out.println("Correct Answer is TRUE: "+m2.checkModelConstraints()); // true
    }

    public static void test8() {
        Model m = new Model();

        Client client = new Client(1, 20, "Dolev", "Tel Aviv");
        Hotel hotel = new Hotel("Tel Aviv", "Paris", 3);
        Room room1 = new Room(404);
        Room room2 = new Room(404);
        ReservationSet reservationSet = new ReservationSet();
        Reservation reservation = new Reservation(Model.getDateFromString("25-12-2019"), Model.getDateFromString("01-01-2020"), 101);
        RoomCategory roomCategory1 = new RoomCategory(200, RoomCategory.RoomType.BASIC);
        RoomCategory roomCategory2 = new RoomCategory(400, RoomCategory.RoomType.SUITE);
        Booking booking = new Booking(Model.getDateFromString("01-01-2020"), room1);


        m.addObjectToModel(client);
        m.addObjectToModel(hotel);
        m.addObjectToModel(roomCategory2);
        m.addObjectToModel(reservationSet);
        m.addObjectToModel(room2);
        m.addObjectToModel(booking);
        m.addObjectToModel(reservation);
        m.addObjectToModel(roomCategory1);
        m.addObjectToModel(room1);

        m.create_link_client_hotel_reservationSet(client, hotel, reservationSet);
        m.create_link_reservationSet_reservation(reservationSet, reservation);
        m.create_link_reservation_roomCategory(reservation, roomCategory2);
        m.create_link_hotel_room(room1, hotel);
        m.create_link_hotel_room(room2, hotel);
        m.create_link_room_roomCategory(room1, roomCategory1);
        m.create_link_room_roomCategory(room2, roomCategory2);

        m.create_link_reservation_booking(booking, reservation);
        m.create_link_room_Booking(room1, booking);

        System.out.println("Correct Answer is FALSE: "+m.checkModelConstraints()); // false

        // ====================================

        Model m2 = new Model();

        m2.addObjectToModel(client);
        m2.addObjectToModel(hotel);
        m2.addObjectToModel(roomCategory2);
        m2.addObjectToModel(reservationSet);
        m2.addObjectToModel(room2);
        m2.addObjectToModel(booking);
        m2.addObjectToModel(reservation);
        m2.addObjectToModel(roomCategory1);
        m2.addObjectToModel(room1);

        m2.create_link_client_hotel_reservationSet(client, hotel, reservationSet);
        m2.create_link_reservationSet_reservation(reservationSet, reservation);
        m2.create_link_reservation_roomCategory(reservation, roomCategory2);
        m2.create_link_hotel_room(room1, hotel);
        m2.create_link_hotel_room(room2, hotel);
        m2.create_link_room_roomCategory(room1, roomCategory1);
        m2.create_link_room_roomCategory(room2, roomCategory2);

        m2.create_link_reservation_booking(booking, reservation);
        m2.create_link_room_Booking(room2, booking);

        System.out.println("Correct Answer is TRUE: "+m.checkModelConstraints()); // false
    }

    public static void test9() {
        Model m = new Model();

        Client client1 = new Client(1, 20, "Dolev", "Tel Aviv");
        Hotel hotel1 = new Hotel("Tel Aviv", "Paris", 4);
        Room room1 = new Room(404);
        ReservationSet reservationSet1 = new ReservationSet();
        Reservation reservation1 = new Reservation(Model.getDateFromString("25-12-2019"), Model.getDateFromString("01-01-2020"), 100);
        RoomCategory roomCategory1 = new RoomCategory(200, RoomCategory.RoomType.BASIC);
        Booking booking = new Booking(Model.getDateFromString("01-01-2020"), room1);

        HotelService hotelService = new HotelService(0, 1);
        VipService vipService = new VipService("Service");

        hotelService.setHotel(hotel1);
        hotelService.assignService(vipService);
        hotel1.addService(vipService, hotelService);

        m.addObjectToModel(client1);
        m.addObjectToModel(hotel1);
        m.addObjectToModel(reservationSet1);
        m.addObjectToModel(reservation1);
        m.addObjectToModel(room1);
        m.addObjectToModel(hotelService);
        m.addObjectToModel(vipService);
        m.addObjectToModel(booking);

        m.create_link_client_hotel_reservationSet(client1, hotel1, reservationSet1);
        m.create_link_reservationSet_reservation(reservationSet1, reservation1);
        m.create_link_reservation_roomCategory(reservation1, roomCategory1);
        m.create_link_hotel_room(room1, hotel1);
        m.create_link_room_roomCategory(room1, roomCategory1);
        m.create_link_reservation_booking(booking, reservation1);
        m.create_link_room_Booking(room1, booking);

        m.create_link_hotelService_booking(hotelService, booking);

        System.out.println("Correct Answer is FALSE: "+m.checkModelConstraints()); // false

        // ===================================================

        Model m2 = new Model();

        m2.addObjectToModel(client1);
        m2.addObjectToModel(hotel1);
        m2.addObjectToModel(reservationSet1);
        m2.addObjectToModel(reservation1);
        m2.addObjectToModel(room1);
        m2.addObjectToModel(hotelService);
        m2.addObjectToModel(vipService);
        m2.addObjectToModel(booking);

        m2.create_link_client_hotel_reservationSet(client1, hotel1, reservationSet1);
        m2.create_link_reservationSet_reservation(reservationSet1, reservation1);
        m2.create_link_reservation_roomCategory(reservation1, roomCategory1);
        m2.create_link_hotel_room(room1, hotel1);
        m2.create_link_room_roomCategory(room1, roomCategory1);
        m2.create_link_reservation_booking(booking, reservation1);
        m2.create_link_room_Booking(room1, booking);

        m2.create_link_hotelService_booking(hotelService, booking);

        Review review = new Review(4, "text", Model.getDateFromString("01-01-2020"));

        m2.create_link_booking_review(booking, review);

        System.out.println("Correct Answer is TRUE: "+m2.checkModelConstraints()); // false
    }

    public static void test10() {
        Model m = new Model();

        // True case
        Group group = new Group(1);
        Hotel hotel1 = new Hotel("Las Vegas", "Paris", 5);
        Client client = new Client(1, 25, "Dolev", "Alabama");
        ReservationSet reservationSet = new ReservationSet();
        Reservation reservation = new Reservation(Model.getDateFromString("25-12-2019"), Model.getDateFromString("27-12-2019"), 1);
        Room room = new Room(2);
        RoomCategory roomCategory = new RoomCategory(10, RoomCategory.RoomType.BASIC);
        Booking booking = new Booking(Model.getDateFromString("27-12-2019"), room);
        Review review1 = new Review(10, "Great!", Model.getDateFromString("29-12-2019"));
        Review review2 = new Review(8, "Great!", Model.getDateFromString("29-12-2019"));

        m.addObjectToModel(group);
        m.addObjectToModel(hotel1);
        m.addObjectToModel(client);
        m.addObjectToModel(reservation);
        m.addObjectToModel(reservationSet);
        m.addObjectToModel(room);
        m.addObjectToModel(roomCategory);
        m.addObjectToModel(booking);
        m.addObjectToModel(review1);
        m.addObjectToModel(review2);

        m.create_link_group_hotel(hotel1, group);
        m.create_link_client_hotel_reservationSet(client, hotel1, reservationSet);
        m.create_link_room_roomCategory(room, roomCategory);
        m.create_link_reservation_roomCategory(reservation, roomCategory);
        m.create_link_reservation_booking(booking, reservation);
        m.create_link_reservationSet_reservation(reservationSet, reservation);
        m.create_link_booking_review(booking, review1);
        m.create_link_booking_review(booking, review2);
        m.create_link_hotel_room(room, hotel1);
        m.create_link_room_Booking(room, booking);

        System.out.println("Correct Answer is TRUE: "+m.checkModelConstraints()); // True expected

        // =======================================================

        // False case
        Model m2 = new Model();

        // True case
        Group group1 = new Group(1);
        Hotel hotel2 = new Hotel("Las Vegas", "Paris", 5);
        Client client1 = new Client(1, 25, "Dolev", "Alabama");
        ReservationSet reservationSet1 = new ReservationSet();
        Reservation reservation1 = new Reservation(Model.getDateFromString("25-12-2019"), Model.getDateFromString("27-12-2019"), 1);
        Room room1 = new Room(2);
        RoomCategory roomCategory1 = new RoomCategory(10, RoomCategory.RoomType.BASIC);
        Booking booking1 = new Booking(Model.getDateFromString("27-12-2019"), room);
        Review review3 = new Review(10, "Great!", Model.getDateFromString("29-12-2019"));
        Review review4 = new Review(5, "Great!", Model.getDateFromString("29-12-2019"));

        m2.addObjectToModel(group1);
        m2.addObjectToModel(hotel2);
        m2.addObjectToModel(client1);
        m2.addObjectToModel(reservation1);
        m2.addObjectToModel(reservationSet1);
        m2.addObjectToModel(room1);
        m2.addObjectToModel(roomCategory1);
        m2.addObjectToModel(booking1);
        m2.addObjectToModel(review3);
        m2.addObjectToModel(review4);

        m2.create_link_group_hotel(hotel2, group1);
        m2.create_link_client_hotel_reservationSet(client1, hotel2, reservationSet1);
        m2.create_link_room_roomCategory(room1, roomCategory1);
        m2.create_link_reservation_roomCategory(reservation1, roomCategory1);
        m2.create_link_reservation_booking(booking1, reservation1);
        m2.create_link_reservationSet_reservation(reservationSet1, reservation1);
        m2.create_link_booking_review(booking1, review3);
        m2.create_link_booking_review(booking1, review4);
        m2.create_link_hotel_room(room1, hotel2);
        m2.create_link_room_Booking(room1, booking1);

        System.out.println("Correct Answer is FALSE: "+m2.checkModelConstraints()); // False expected
    }

    public static void test11() {

        Model m = new Model();

        Hotel hotel1 = new Hotel("Tel Aviv", "Paris", 4);
        Service VIPService = new VipService("MASSAGE");
        Service CommunityService = new CommunityService("THAI-MASSAGE");
        HotelService hotelService1 = new HotelService(10, 10);
        HotelService hotelService2 = new HotelService(5, 9);

        m.addObjectToModel(hotel1);
        m.addObjectToModel(VIPService);
        m.addObjectToModel(CommunityService);
        m.addObjectToModel(hotelService1);
        m.addObjectToModel(hotelService2);

        m.create_link_hotel_service_hotelService(hotel1, VIPService, hotelService1);
        m.create_link_hotel_service_hotelService(hotel1, CommunityService, hotelService2);

        System.out.println("Correct Answer is TRUE: "+m.checkModelConstraints()); // true

        // ===================================================

        Model m2 = new Model();

        Hotel hotel2 = new Hotel("Tel Aviv", "Paris", 4);
        Service VIPService2 = new VipService("MASSAGE");
        Service CommunityService2 = new CommunityService("MASSAGE");
        HotelService hotelService3 = new HotelService(10, 10);
        HotelService hotelService4 = new HotelService(5, 9);

        m2.addObjectToModel(hotel2);
        m2.addObjectToModel(VIPService2);
        m2.addObjectToModel(CommunityService2);
        m2.addObjectToModel(hotelService3);
        m2.addObjectToModel(hotelService4);

        m2.create_link_hotel_service_hotelService(hotel2, VIPService2, hotelService3);
        m2.create_link_hotel_service_hotelService(hotel2, CommunityService2, hotelService4);

        System.out.println("Correct Answer is FALSE: "+m2.checkModelConstraints()); // false

    }

    public static void test12() {

        Model m = new Model();

        Service RegulService = new RegularService("lunch to room");
        Service communityService1 = new CommunityService("lunch in rest room");
        HotelService hotelService11 = new HotelService(100, 10);
        HotelService hotelService21 = new HotelService(10, 7);
        Hotel hotel11 = new Hotel("Beer Sheva", "Paris", 3);
        Group group1 = new Group(1);
        Room room11 = new Room(101);
        Room room21 = new Room(202);
        Booking booking11 = new Booking(Model.getDateFromString("25-10-2018"), room11);
        Booking booking21 = new Booking(Model.getDateFromString("25-12-2018"), room21);
        Booking booking31 = new Booking(Model.getDateFromString("25-01-2019"), room11);
        Booking booking41 = new Booking(Model.getDateFromString("25-02-2019"), room21);
        Client client11 = new Client(21, 25, "Dolev", "New York City");
        ReservationSet reservationSet11 = new ReservationSet();
        Reservation reservation61 = new Reservation(Model.getDateFromString("25-10-2018"), Model.getDateFromString("26-12-2019"), 101);
        Reservation reservation71 = new Reservation(Model.getDateFromString("25-12-2018"), Model.getDateFromString("11-12-2019"), 102);
        Reservation reservation81 = new Reservation(Model.getDateFromString("25-01-2019"), Model.getDateFromString("14-12-2019"), 103);
        Reservation reservation91 = new Reservation(Model.getDateFromString("25-02-2019"), Model.getDateFromString("03-10-2019"), 105);
        RoomCategory roomCategory31 = new RoomCategory(200, RoomCategory.RoomType.BASIC);

        m.addObjectToModel(RegulService);
        m.addObjectToModel(communityService1);
        m.addObjectToModel(hotel11);
        m.addObjectToModel(hotelService11);
        m.addObjectToModel(hotelService21);
        m.addObjectToModel(group1);
        m.addObjectToModel(room11);
        m.addObjectToModel(room21);
        m.addObjectToModel(booking11);
        m.addObjectToModel(booking21);
        m.addObjectToModel(booking31);
        m.addObjectToModel(booking41);
        m.addObjectToModel(client11);
        m.addObjectToModel(reservationSet11);
        m.addObjectToModel(reservation61);
        m.addObjectToModel(reservation71);
        m.addObjectToModel(reservation81);
        m.addObjectToModel(reservation91);
        m.addObjectToModel(roomCategory31);

        m.create_link_hotel_service_hotelService(hotel11, RegulService, hotelService11);
        m.create_link_hotel_service_hotelService(hotel11, communityService1, hotelService21);
        m.create_link_reservation_roomCategory(reservation61, roomCategory31);
        m.create_link_reservation_roomCategory(reservation71, roomCategory31);
        m.create_link_reservation_roomCategory(reservation81, roomCategory31);
        m.create_link_reservation_roomCategory(reservation91, roomCategory31);
        m.create_link_room_roomCategory(room11, roomCategory31);
        m.create_link_room_roomCategory(room21, roomCategory31);
        m.create_link_client_hotel_reservationSet(client11, hotel11, reservationSet11);
        m.create_link_room_Booking(room11, booking11);
        m.create_link_room_Booking(room21, booking21);
        m.create_link_room_Booking(room11, booking31);
        m.create_link_room_Booking(room21, booking41);
        m.create_link_group_hotel(hotel11, group1);
        m.create_link_reservationSet_reservation(reservationSet11, reservation61);
        m.create_link_reservationSet_reservation(reservationSet11, reservation71);
        m.create_link_reservationSet_reservation(reservationSet11, reservation81);
        m.create_link_reservationSet_reservation(reservationSet11, reservation91);
        m.create_link_hotelService_booking(hotelService21, booking11);
        m.create_link_hotelService_booking(hotelService21, booking21);
        m.create_link_hotelService_booking(hotelService11, booking31);
        m.create_link_hotelService_booking(hotelService21, booking41);
        m.create_link_reservation_booking(booking11, reservation61);
        m.create_link_reservation_booking(booking21, reservation71);
        m.create_link_reservation_booking(booking31, reservation81);
        m.create_link_reservation_booking(booking41, reservation91);


        System.out.println("Correct Answer is TRUE: "+m.checkModelConstraints()); // true

        // ====================================

        Model m2 = new Model();

        Service regularService1 = new RegularService("lunch to room");
        Service communityService = new CommunityService("lunch in rest room");

        HotelService hotelService1 = new HotelService(100, 10);
        HotelService hotelService2 = new HotelService(10, 7);


        Hotel hotel1 = new Hotel("Beer Sheva", "Paris", 3);

        Group group = new Group(1);

        Room room1 = new Room(101);
        Room room2 = new Room(202);

        Booking booking1 = new Booking(Model.getDateFromString("25-10-2018"), room1);
        Booking booking2 = new Booking(Model.getDateFromString("25-12-2018"), room2);
        Booking booking3 = new Booking(Model.getDateFromString("25-01-2019"), room1);
        Booking booking4 = new Booking(Model.getDateFromString("25-02-2019"), room2);

        Client client1 = new Client(21, 25, "Dolev", "New York City");
        ReservationSet reservationSet1 = new ReservationSet();
        Reservation reservation6 = new Reservation(Model.getDateFromString("25-10-2018"), Model.getDateFromString("26-12-2019"), 101);
        Reservation reservation7 = new Reservation(Model.getDateFromString("25-12-2018"), Model.getDateFromString("11-12-2019"), 102);
        Reservation reservation8 = new Reservation(Model.getDateFromString("25-01-2019"), Model.getDateFromString("14-12-2019"), 103);
        Reservation reservation9 = new Reservation(Model.getDateFromString("25-02-2019"), Model.getDateFromString("03-10-2019"), 105);

        RoomCategory roomCategory3 = new RoomCategory(200, RoomCategory.RoomType.VIP);

        m2.addObjectToModel(regularService1);
        m2.addObjectToModel(communityService);
        m2.addObjectToModel(hotel1);
        m2.addObjectToModel(hotelService1);
        m2.addObjectToModel(hotelService2);
        m2.addObjectToModel(group);
        m2.addObjectToModel(room1);
        m2.addObjectToModel(room2);
        m2.addObjectToModel(booking1);
        m2.addObjectToModel(booking2);
        m2.addObjectToModel(booking3);
        m2.addObjectToModel(booking4);
        m2.addObjectToModel(client1);
        m2.addObjectToModel(reservationSet1);
        m2.addObjectToModel(reservation6);
        m2.addObjectToModel(reservation7);
        m2.addObjectToModel(reservation8);
        m2.addObjectToModel(reservation9);
        m2.addObjectToModel(roomCategory3);

        m2.create_link_hotel_service_hotelService(hotel1, regularService1, hotelService1);
        m2.create_link_hotel_service_hotelService(hotel1, communityService, hotelService2);
        m2.create_link_reservation_roomCategory(reservation6, roomCategory3);
        m2.create_link_reservation_roomCategory(reservation7, roomCategory3);
        m2.create_link_reservation_roomCategory(reservation8, roomCategory3);
        m2.create_link_reservation_roomCategory(reservation9, roomCategory3);
        m.create_link_room_roomCategory(room1, roomCategory3);
        m.create_link_room_roomCategory(room2, roomCategory3);
        m2.create_link_client_hotel_reservationSet(client1, hotel1, reservationSet1);
        m2.create_link_room_Booking(room1, booking1);
        m2.create_link_room_Booking(room2, booking2);
        m2.create_link_room_Booking(room1, booking3);
        m2.create_link_room_Booking(room2, booking4);
        m2.create_link_group_hotel(hotel1, group);
        m2.create_link_reservationSet_reservation(reservationSet1, reservation6);
        m2.create_link_reservationSet_reservation(reservationSet1, reservation7);
        m2.create_link_reservationSet_reservation(reservationSet1, reservation8);
        m2.create_link_reservationSet_reservation(reservationSet1, reservation9);
        m2.create_link_hotelService_booking(hotelService1, booking1);
        m2.create_link_hotelService_booking(hotelService2, booking2);
        m2.create_link_hotelService_booking(hotelService2, booking3);
        m2.create_link_hotelService_booking(hotelService2, booking4);
        m.create_link_reservation_booking(booking1, reservation6);
        m.create_link_reservation_booking(booking2, reservation7);
        m.create_link_reservation_booking(booking3, reservation8);
        m.create_link_reservation_booking(booking4, reservation9);


        System.out.println("Correct Answer is FALSE: "+m2.checkModelConstraints()); // false

    }

    public static void test13() {

        Model m = new Model();

        Group group = new Group(1);
        Hotel hotel1 = new Hotel("Tel Aviv", "Paris", 4);
        Hotel hotel2 = new Hotel("Beer Sheva", "Europa", 4);
        Service regularService1 = new RegularService("MASSAGE");
        HotelService hotelService1 = new HotelService(10, 10);
        Room room = new Room(404);
        ReservationSet reservationSet = new ReservationSet();
        Reservation reservation = new Reservation(Model.getDateFromString("25-12-2019"), Model.getDateFromString("27-12-2019"), 1);
        Booking booking = new Booking(Model.getDateFromString("27-12-2019"), room);
        Client client = new Client(1, 25, "Dolev", "Tel Aviv");
        RoomCategory roomCategory = new RoomCategory(1, RoomCategory.RoomType.SUITE);

        m.addObjectToModel(hotel1);
        m.addObjectToModel(hotel2);
        m.addObjectToModel(room);
        m.addObjectToModel(reservationSet);
        m.addObjectToModel(reservation);
        m.addObjectToModel(booking);
        m.addObjectToModel(client);
        m.addObjectToModel(regularService1);
        m.addObjectToModel(hotelService1);
        m.addObjectToModel(roomCategory);
        m.addObjectToModel(group);

        m.create_link_hotel_service_hotelService(hotel2, regularService1, hotelService1);
        m.create_link_reservationSet_reservation(reservationSet, reservation);
        m.create_link_client_hotel_reservationSet(client, hotel1, reservationSet);
        m.create_link_hotelService_booking(hotelService1, booking);
        m.create_link_room_Booking(room, booking);
        m.create_link_reservation_booking(booking, reservation);
        m.create_link_hotelService_booking(hotelService1, booking);
        m.create_link_group_hotel(hotel1, group);
        m.create_link_group_hotel(hotel2, group);
        m.create_link_hotel_room(room, hotel1);
        m.create_link_room_roomCategory(room, roomCategory);
        m.create_link_reservation_roomCategory(reservation, roomCategory);

        System.out.println("Correct Answer is FALSE: "+m.checkModelConstraints()); // false

        // ===================================================

        Model m2 = new Model();

        Group group1 = new Group(1);
        Hotel hotel11 = new Hotel("Tel Aviv", "Paris", 4);
        Service regularService = new RegularService("MASSAGE");
        HotelService hotelService11 = new HotelService(10, 10);
        Room room1 = new Room(404);
        ReservationSet reservationSet1 = new ReservationSet();
        Reservation reservation1 = new Reservation(Model.getDateFromString("25-12-2019"), Model.getDateFromString("27-12-2019"), 1);
        Booking booking1 = new Booking(Model.getDateFromString("27-12-2019"), room1);
        Client client1 = new Client(1, 25, "Dolev", "Tel Aviv");
        RoomCategory roomCategory1 = new RoomCategory(1, RoomCategory.RoomType.SUITE);

        m2.addObjectToModel(hotel11);
        m2.addObjectToModel(room1);
        m2.addObjectToModel(reservationSet1);
        m2.addObjectToModel(reservation1);
        m2.addObjectToModel(booking1);
        m2.addObjectToModel(client1);
        m2.addObjectToModel(regularService);
        m2.addObjectToModel(hotelService11);
        m2.addObjectToModel(roomCategory1);
        m2.addObjectToModel(group1);

        m2.create_link_hotel_service_hotelService(hotel11, regularService, hotelService11);
        m2.create_link_reservationSet_reservation(reservationSet1, reservation1);
        m2.create_link_client_hotel_reservationSet(client1, hotel11, reservationSet1);
        m2.create_link_hotelService_booking(hotelService11, booking1);
        m2.create_link_room_Booking(room1, booking1);
        m2.create_link_reservation_booking(booking1, reservation1);
        m2.create_link_hotelService_booking(hotelService11, booking1);
        m2.create_link_group_hotel(hotel11, group1);
        m2.create_link_hotel_room(room1, hotel11);
        m2.create_link_room_roomCategory(room1, roomCategory1);
        m.create_link_reservation_roomCategory(reservation1, roomCategory1);

        System.out.println("Correct Answer is TRUE: "+m2.checkModelConstraints()); // true

    }

    public static void sht() {
        Model m1 = new Model();
        Group g = new Group(1);
        Hotel h1 = new Hotel("Haifa", "Dan Panorama", 4);
        Hotel h2 = new Hotel("Haifa", "Dan Carmel", 4);
        m1.addObjectToModel(g);
        m1.addObjectToModel(h1);
        m1.addObjectToModel(h2);
        m1.create_link_group_hotel(h1, g);
        m1.create_link_group_hotel(h2, g);
        System.out.println(m1.checkModelConstraints()+" should be =false");
    }

    public static void sht1() {
        Model m1 = new Model();
        Client client1 = new Client(1, 20, "Dolev", "Tel Aviv");
        Hotel hotel1 = new Hotel("Las Vegas", "Paris", 5);
        Room room1 = new Room(404);
        ReservationSet reservationSet1 = new ReservationSet();
        Date orDate = Model.getDateFromString("25-12-2019");
        Date reqDate = Model.getDateFromString("01-01-2020");
        Reservation reservation1 = new Reservation(orDate, reqDate, 100);
        RoomCategory roomCategory1 = new RoomCategory(200, RoomCategory.RoomType.BASIC);
        m1.addObjectToModel(client1);
        m1.addObjectToModel(hotel1);
        m1.addObjectToModel(reservationSet1);
        m1.addObjectToModel(reservation1);
        m1.addObjectToModel(room1);
        m1.create_link_client_hotel_reservationSet(client1, hotel1, reservationSet1);
        m1.create_link_reservationSet_reservation(reservationSet1, reservation1);
        m1.create_link_reservation_roomCategory(reservation1, roomCategory1);
        m1.create_link_hotel_room(room1, hotel1);
        m1.create_link_room_roomCategory(room1, roomCategory1);
        System.out.println(m1.checkModelConstraints()+" should be =false");
    }
}

