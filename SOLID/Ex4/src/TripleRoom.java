public class TripleRoom implements PricingComponent {
    public Money monthly() {
        return new Money(12000.0);
    }
}