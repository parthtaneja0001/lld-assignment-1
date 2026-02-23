public class LaundryAddOn implements PricingComponent {
    public Money monthly() {
        return new Money(500.0);
    }
}