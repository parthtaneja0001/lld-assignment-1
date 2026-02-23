public class GymAddOn implements PricingComponent {
    public Money monthly() {
        return new Money(300.0);
    }
}