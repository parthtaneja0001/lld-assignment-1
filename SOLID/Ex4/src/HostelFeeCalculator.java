import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;

    public HostelFeeCalculator(FakeBookingRepo repo) { this.repo = repo; }

    // Fixed OCP violation: switch + add-on branching + printing + persistence.
    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {

        List<PricingComponent> components = new ArrayList<>();
    
        // Room component
        switch (req.roomType) {
            case LegacyRoomTypes.SINGLE -> components.add(new SingleRoom());
            case LegacyRoomTypes.DOUBLE -> components.add(new DoubleRoom());
            case LegacyRoomTypes.TRIPLE -> components.add(new TripleRoom());
            default -> components.add(() -> new Money(16000.0));
        }
    
        // Add-on components
        for (AddOn a : req.addOns) {
            switch (a) {
                case MESS -> components.add(new MessAddOn());
                case LAUNDRY -> components.add(new LaundryAddOn());
                case GYM -> components.add(new GymAddOn());
            }
        }
    
        Money total = new Money(0.0);
        for (PricingComponent c : components) {
            total = total.plus(c.monthly());
        }
    
        return total;
    }
}
