public class EligibilityStatus {
    private String value = "ELIGIBLE";

    public void markNotEligible() {
        value = "NOT_ELIGIBLE";
    }

    public String getValue() {
        return value;
    }
}