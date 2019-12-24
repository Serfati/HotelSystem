import java.util.Date;


public class Review implements ITestable {

    private Booking booking;
    private int rank;
    private String reviewContent;
    private Date date;

    public Review(int rank, String reviewContent, Date date) {
        this.rank = rank;
        this.reviewContent = reviewContent;
        this.date = date;
    }

    public static boolean checkAllIntancesConstraints(Model model) {
        return model.ReviewAllInstances().stream().allMatch(Review::checkConstraints);
    }

    public void addBooking(Booking booking) {
        this.booking = booking;
    }

    public int getRank() {
        return rank;
    }

    public Booking getBooking() {
        return booking;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    @Override
    public boolean checkConstraints() {
        return true;
    }
}